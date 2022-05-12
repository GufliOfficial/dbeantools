package com.gufli.dbeantools.api;

import com.gufli.dbeantools.api.context.AbstractDatabaseContext;
import com.gufli.dbeantools.api.migration.MigrationGenerator;
import io.ebean.annotation.Platform;
import io.ebean.config.DatabaseConfig;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DatabaseContextTests {

    private static AbstractDatabaseContext databaseContext;
    private static Set<Class<?>> classes = new HashSet<>();

    private static File tempdir;

    @BeforeAll
    public static void init() {
        classes.add(TestBean.class);

        databaseContext = new AbstractDatabaseContext("TestDatabase") {
            @Override
            protected void buildConfig(DatabaseConfig config) {
                classes.forEach(config::addClass);
            }
        };

        tempdir = new File("tmp");
        tempdir.mkdirs();
    }

    @AfterAll
    public static void finish() {
        databaseContext.shutdown();
        deleteDirectory(tempdir);
    }

    private static boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }

    @Test
    @Order(1)
    public void generateMigrationFiles() throws IOException {
        MigrationGenerator generator = new MigrationGenerator("TestDatabase",
                tempdir.toPath(), Platform.H2);
        classes.forEach(generator::addClass);
        generator.generate();

        File[] files = new File(tempdir, "migrations/model").listFiles();
        assertNotNull(files);
        assertEquals(1, files.length);
    }

    @Test
    @Order(2)
    public void initializeDatabase() throws Exception {
        databaseContext.init("jdbc:h2:mem:migrationdb;", "dbuser", "", null,
                "filesystem:" + tempdir.toPath().resolve("migrations"));

        try (
                Connection conn = databaseContext.getConnection();
                ResultSet rs = conn.prepareStatement("SELECT COUNT(*) FROM db_migration").executeQuery()
        ) {
            assertTrue(rs.next());
            assertEquals(2, rs.getInt(1));
        }
    }

}
