package com.gufli.dbeantools.bukkit.converters.mutable;

import com.gufli.dbeantools.api.value.MutableDatabaseValueConverter;
import com.gufli.dbeantools.bukkit.converters.InventoryConverter;
import org.bukkit.inventory.Inventory;

public class MutableInventoryConverter extends MutableDatabaseValueConverter<Inventory> {

    public MutableInventoryConverter() {
        super(new InventoryConverter());
    }

}
