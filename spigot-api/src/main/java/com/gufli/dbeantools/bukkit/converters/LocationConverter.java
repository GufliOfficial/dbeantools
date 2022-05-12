package com.gufli.dbeantools.bukkit.converters;

import org.bukkit.Location;

import javax.persistence.Converter;

@Converter
public class LocationConverter extends ConfigurationSerializableConverter<Location> {

    public LocationConverter() {
        super(Location.class);
    }

}