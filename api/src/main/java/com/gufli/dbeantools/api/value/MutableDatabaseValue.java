package com.gufli.dbeantools.api.value;

// no record because it will mess up the equals
public class MutableDatabaseValue<T> {

    private final T value;

    public MutableDatabaseValue(T value) {
        this.value = value;
    }

    public T value() {
        return value;
    }
}
