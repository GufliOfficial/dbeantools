package com.gufli.dbeantools.api.value;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class MutableDatabaseValueConverter<T> implements AttributeConverter<MutableDatabaseValue<T>, String> {

    private final AttributeConverter<T, String> converter;
    public MutableDatabaseValueConverter(AttributeConverter<T, String> converter) {
        this.converter = converter;
    }


    @Override
    public String convertToDatabaseColumn(MutableDatabaseValue<T> attribute) {
        return converter.convertToDatabaseColumn(attribute.value());
    }

    @Override
    public MutableDatabaseValue<T> convertToEntityAttribute(String dbData) {
        return new MutableDatabaseValue<>(converter.convertToEntityAttribute(dbData));
    }
}