//package com.gufli.dbeantools.api;
//
//import com.gufli.dbeantools.api.context.AbstractDatabaseContext;
//import com.gufli.dbeantools.api.migration.MigrationTool;
//import com.gufli.dbeantools.api.mock.MockBean;
//import io.ebean.annotation.Platform;
//import org.junit.jupiter.api.*;
//
//import java.io.File;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.ResultSet;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class DatabaseContextTests {
//
//    private static AbstractDatabaseContext databaseContext;
//
//    private static File tempdir;
//
//    @BeforeAll
//    public static void init() {
//        databaseContext = new AbstractDatabaseContext("TestDatabase") {
//            @Override
//            public Class<?>[] classes() {
//                return new Class[] { MockBean.class };
//            }
//        };
//
//        tempdir = new File("tmp");
//        tempdir.mkdirs();
//    }
//
//    @AfterAll
//    public static void finish() {
//        databaseContext.shutdown();
//        deleteDirectory(tempdir);
//    }
//
//    private static boolean deleteDirectory(File directoryToBeDeleted) {
//        File[] allContents = directoryToBeDeleted.listFiles();
//        if (allContents != null) {
//            for (File file : allContents) {
//                deleteDirectory(file);
//            }
//        }
//        return directoryToBeDeleted.delete();
//    }
//
//    @Test
//    @Order(1)
//    public void generateMigrationFiles() throws IOException {
//        MigrationTool tool = new MigrationTool(databaseContext, tempdir.toPath().toString(), Platform.H2);
//        tool.generate();
//
//        File[] files = new File(tempdir, "migrations/model").listFiles();
//        assertNotNull(files);
//        assertEquals(1, files.length);
//    }
//
//    @Test
//    @Order(2)
//    public void initializeDatabase() throws Exception {
//        databaseContext.init("jdbc:h2:mem:migrationdb;", "dbuser", "", null);
//        databaseContext.migrate("filesystem:" + tempdir.toPath().resolve("migrations"));
//        try (
//                Connection conn = databaseContext.getConnection();
//                ResultSet rs = conn.prepareStatement("SELECT COUNT(*) FROM db_migration").executeQuery()
//        ) {
//            assertTrue(rs.next());
//            assertEquals(2, rs.getInt(1));
//        }
//    }
//
//}
