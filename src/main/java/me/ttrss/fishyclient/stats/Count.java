package me.ttrss.fishyclient.stats;

import net.minecraftforge.common.MinecraftForge;
import scala.Int;

import java.util.regex.Pattern;

public class Count implements IStat<Integer> {

    protected String name;
    protected Integer count;
    protected Integer customColor = null;

    public Count(String name, int initial) {
        this.name = name;
        this.count = initial;
    }

    @Override
    public void setValue(Integer value) {
        this.count = value;
    }

    @Override
    public String getValue() {
        return this.count.toString();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean hasColor() {
        return this.customColor != null;
    }

    @Override
    public int getColor() {
        return this.customColor;
    }

}
