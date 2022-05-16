package com.gufli.dbeantools.api.context;


import com.gufli.dbeantools.api.BaseModel;
import io.ebean.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;

public interface DatabaseContext {

    void shutdown();

    Connection getConnection() throws SQLException;

    String dataSourceName();

    Class<?>[] classes();

    void migrate() throws  SQLException;

    void migrate(String migrationsPath) throws SQLException;

    Database database();

    // UTILS

    CompletableFuture<Void> saveAsync(BaseModel... models);

    CompletableFuture<Void> saveAsync(Collection<? extends BaseModel> models);

    CompletableFuture<Void> deleteAsync(BaseModel... models);

    CompletableFuture<Void> deleteAsync(Collection<? extends BaseModel> models);

}
