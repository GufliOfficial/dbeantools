package com.gufli.dbeantools.bukkit.converters;

import com.gufli.dbeantools.bukkit.BukkitSerializer;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import javax.persistence.AttributeConverter;
import java.io.IOException;

public abstract class ConfigurationSerializableConverter<T extends ConfigurationSerializable> implements AttributeConverter<T, String> {

    private final Class<T> type;
    public ConfigurationSerializableConverter(Class<T> type) {
        this.type = type;
    }

    @Override
    public String convertToDatabaseColumn(T attribute) {
        try {
            return BukkitSerializer.encodeObject(attribute);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public T convertToEntityAttribute(String dbData) {
        try {
            return BukkitSerializer.decodeObject(type, dbData);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}