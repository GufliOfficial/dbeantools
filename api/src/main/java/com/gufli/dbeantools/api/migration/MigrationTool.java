package com.gufli.dbeantools.api.migration;

import com.gufli.dbeantools.api.context.DatabaseContext;
import io.ebean.annotation.Platform;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

public class MigrationTool {

    private final DatabaseContext databaseContext;
    private final String resourcePath;
    private final Platform[] platforms;

    public MigrationTool(DatabaseContext databaseContext, String resourcePath, Platform... platforms) {
        this.databaseContext = databaseContext;
        this.resourcePath = resourcePath;
        this.platforms = platforms;
    }

    public MigrationTool(DatabaseContext databaseContext, Platform... platforms) {
        this(databaseContext, null, platforms);
    }

    public void generate() throws IOException {
        MigrationGenerator generator = new MigrationGenerator(databaseContext.dataSourceName(),
                resourcePath, platforms);
        Arrays.stream(databaseContext.classes()).forEach(generator::addClass);

        if ( databaseContext.database() != null ) {
            generator.generate(databaseContext.database());
        } else {
            generator.generate();
        }
    }

    public void apply() throws SQLException {
        databaseContext.migrate(resourcePath);
    }
}
