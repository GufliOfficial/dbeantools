package com.gufli.dbeantools.bukkit.converters.mutable;

import com.gufli.dbeantools.api.value.MutableDatabaseValueConverter;
import com.gufli.dbeantools.bukkit.converters.LocationConverter;
import org.bukkit.Location;

public class MutableLocationConverter extends MutableDatabaseValueConverter<Location> {

    public MutableLocationConverter() {
        super(new LocationConverter());
    }

}
