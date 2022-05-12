package com.gufli.dbeantools.api;

import io.ebean.Model;
import io.ebean.annotation.DbName;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@DbName("TestDatabase")
@Table(name = "test_beans")
public class TestBean extends Model implements BaseModel {

    @Id
    private UUID id;

    public TestBean() {
        super("TestDatabase");
    }

    public UUID id() {
        return id;
    }

}
