package com.gufli.dbeantools.spigot.converters;

import org.bukkit.inventory.ItemStack;

import javax.persistence.Converter;

@Converter
public class ItemStackConverter extends ConfigurationSerializableConverter<ItemStack> {

    public ItemStackConverter() {
        super(ItemStack.class);
    }

}