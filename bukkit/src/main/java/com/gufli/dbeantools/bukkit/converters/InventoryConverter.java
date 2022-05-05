package com.gufli.dbeantools.bukkit.converters;

import com.gufli.dbeantools.bukkit.BukkitSerializer;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import javax.persistence.Converter;
import java.io.IOException;

@Converter
public class InventoryConverter implements AttributeConverter<Inventory, String> {

    @Override
    public String convertToDatabaseColumn(Inventory attribute) {
        try {
            return BukkitSerializer.encodeArray(attribute.getContents());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Inventory convertToEntityAttribute(String dbData) {
        try {
            ItemStack[] items = BukkitSerializer.decodeArray(ItemStack.class, dbData);
            Inventory inv = Bukkit.createInventory(null, items.length);
            for ( int i = 0; i < items.length; i++ ) {
                inv.setItem(i, items[i]);
            }
            return inv;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}