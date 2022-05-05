package com.gufli.dbeantools.bukkit.converters;

import org.bukkit.inventory.ItemStack;

import javax.persistence.Converter;

@Converter
public class ItemStackConverter extends ConfigurationSerializableConverter<ItemStack> {

    public ItemStackConverter() {
        super(ItemStack.class);
    }

}