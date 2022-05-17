package com.gufli.dbeantools.spigot.converters.mutable;

import com.gufli.dbeantools.api.value.MutableDatabaseValueConverter;
import com.gufli.dbeantools.spigot.converters.ItemStackConverter;
import org.bukkit.inventory.ItemStack;

public class MutableItemStackConverter extends MutableDatabaseValueConverter<ItemStack> {

    public MutableItemStackConverter() {
        super(new ItemStackConverter());
    }

}
