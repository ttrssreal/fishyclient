package me.ttrss.fishyclient.gui;

import me.ttrss.fishyclient.stats.FishCount;
import me.ttrss.fishyclient.stats.IStat;
import me.ttrss.fishyclient.stats.TrashCount;
import me.ttrss.fishyclient.stats.TreasureCount;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

public class StatsGUI extends Gui implements IGUI {

    int defaultTextColor;
    int fontHeight;
    int elementGap = 10;
    int topOffset = 10;
    int leftOffset = 15;
    private final FontRenderer fontRenderer = Minecraft.getMinecraft().fontRendererObj;
    private IStat[] stats;

    public StatsGUI() {
        this.defaultTextColor = (int)Long.parseLong("ff00ffff", 16);
        this.fontHeight = fontRenderer.FONT_HEIGHT;
        this.stats = new IStat[]{
                new FishCount(0),
                new TreasureCount(0),
                new TrashCount(0)
        };
    }

    public void render() {
        int currTopOffset = topOffset;
        for (IStat stat : this.stats) {
            String elementName = stat.getName();
            int x = fontRenderer.getStringWidth(elementName)/2 + this.leftOffset;
            int color = stat.hasColor() ? stat.getColor() : this.defaultTextColor;
            drawCenteredString(this.fontRenderer, elementName + ": " + stat.getValue(), x, currTopOffset, color);
            currTopOffset += this.fontHeight + this.elementGap;
        }
    }
}
