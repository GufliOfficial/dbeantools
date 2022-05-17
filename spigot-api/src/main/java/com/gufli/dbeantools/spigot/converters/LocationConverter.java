package com.gufli.dbeantools.spigot.converters;

import org.bukkit.Location;

import javax.persistence.Converter;

@Converter
public class LocationConverter extends ConfigurationSerializableConverter<Location> {

    public LocationConverter() {
        super(Location.class);
    }

}