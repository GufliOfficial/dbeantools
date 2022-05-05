package com.gufli.dbeantools.api;

import io.ebean.Model;
import io.ebean.annotation.DbName;
import net.minestom.server.color.Color;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.item.ItemStack;
import org.jglrxavpok.hephaistos.nbt.NBTCompound;
import com.gufli.dbeantools.api.converters.ColorConverter;
import com.gufli.dbeantools.api.converters.ItemStackConverter;
import com.gufli.dbeantools.api.converters.NBTCompoundConverter;
import com.gufli.dbeantools.api.converters.PosConverter;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@DbName("TestDatabase")
@Table(name = "test_beans")
public class TestBean extends Model implements BaseModel {

    @Id
    private UUID id;

    @Convert(converter = ItemStackConverter.class, attributeName = "itemStack")
    private ItemStack itemStack;

    @Convert(converter = ColorConverter.class, attributeName = "color")
    private Color color;

    @Convert(converter = NBTCompoundConverter.class, attributeName = "NBTCompound")
    private NBTCompound NBTCompound;

    @Convert(converter = PosConverter.class, attributeName = "pos")
    private Pos pos;

    public TestBean() {
        super("TestDatabase");
    }

    public UUID id() {
        return id;
    }

    public ItemStack itemStack() {
        return itemStack;
    }

    public Color color() {
        return color;
    }

    public NBTCompound NBTCompound() {
        return NBTCompound;
    }

    public Pos pos() {
        return pos;
    }

    //


    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setNBTCompound(org.jglrxavpok.hephaistos.nbt.NBTCompound NBTCompound) {
        this.NBTCompound = NBTCompound;
    }

    public void setPos(Pos pos) {
        this.pos = pos;
    }
}
