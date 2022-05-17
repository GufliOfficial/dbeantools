package com.gufli.dbeantools.spigot.converters.mutable;

import com.gufli.dbeantools.api.value.MutableDatabaseValueConverter;
import com.gufli.dbeantools.spigot.converters.LocationConverter;
import org.bukkit.Location;

public class MutableLocationConverter extends MutableDatabaseValueConverter<Location> {

    public MutableLocationConverter() {
        super(new LocationConverter());
    }

}
