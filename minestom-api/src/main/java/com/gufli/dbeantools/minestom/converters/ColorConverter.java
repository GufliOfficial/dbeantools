package com.gufli.dbeantools.minestom.converters;

import net.minestom.server.color.Color;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ColorConverter implements AttributeConverter<Color, String> {

    @Override
    public String convertToDatabaseColumn(Color attribute) {
        return "#" + Integer.toHexString(attribute.asRGB());
    }

    @Override
    public Color convertToEntityAttribute(String dbData) {
        return new Color(Integer.parseInt(dbData.substring(1), 16));
    }
}