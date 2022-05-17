package com.gufli.dbeantools.api.mock;

import com.gufli.dbeantools.api.BaseModel;
import io.ebean.Model;
import io.ebean.annotation.DbName;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@DbName("TestDatabase")
@Table(name = "mock_beans")
public class MockBean extends Model implements BaseModel {

    @Id
    private UUID id;

    public MockBean() {
        super("TestDatabase");
    }

    public UUID id() {
        return id;
    }

}
