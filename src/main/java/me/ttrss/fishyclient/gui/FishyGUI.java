package me.ttrss.fishyclient.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

@SideOnly(Side.CLIENT)
public class FishyGUI {

    private static final HashMap<Integer, IGUI> guis = new HashMap<Integer, IGUI>();
    private boolean renderGui = false;

    public FishyGUI() {
        loadGuis();
        MinecraftForge.EVENT_BUS.register(this);
    }

    public FishyGUI start() {
        this.renderGui = true;
        return this;
    }

    public FishyGUI stop() {
        this.renderGui = false;
        return this;
    }

    private void loadGuis() {
        guis.put(10, new StatsGUI());
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onRenderGUI(RenderGameOverlayEvent.Post event) {
        if (!renderGui) return;
        if (Minecraft.getMinecraft().gameSettings.showDebugInfo) return;
        if (event.type == RenderGameOverlayEvent.ElementType.TEXT) {
            Object[] priorities = guis.keySet().toArray();
            Arrays.sort(priorities);
            Collections.reverse(Arrays.asList(priorities));
                for (Object priority : priorities)
            {
                guis.get((Integer)priority).render();
            }
        }
    }
}