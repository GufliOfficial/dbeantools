package com.gufli.dbeantools.spigot.converters;

import com.gufli.dbeantools.spigot.SpigotSerializer;
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
            return SpigotSerializer.encodeObject(attribute);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public T convertToEntityAttribute(String dbData) {
        try {
            return SpigotSerializer.decodeObject(type, dbData);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}