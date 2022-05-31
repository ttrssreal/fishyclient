package me.ttrss.fishyclient;

import me.ttrss.fishyclient.gui.FishyGUI;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = "fishyclient", version = "0.1", clientSideOnly = true)
@SideOnly(Side.CLIENT)
public class FishyClient
{
    public static final String MODNAME = "FishyClient";
    public static final String VERSION = "0.1";
    public final Logger logger = LogManager.getLogger("FishyClient");

    public static FishyGUI GUI;

    @EventHandler
    @SideOnly(Side.CLIENT)
    public void init(FMLInitializationEvent event)
    {
        String message =
                MODNAME + " version " + VERSION + " starting up...";
        logger.info(message);
        GUI = new FishyGUI().start();
    }
}
