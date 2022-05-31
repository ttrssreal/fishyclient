package me.ttrss.fishyclient.stats;

import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.regex.Pattern;

public class TreasureCount extends Count {

    private Pattern pattern;

    public TreasureCount(int initial) {
        super("(Session) Treasure", initial);
        this.customColor = (int)Long.parseLong("ff55ff55", 16);
        this.pattern = Pattern.compile("^You caught an? .*, that's a treasure!$", Pattern.MULTILINE);
        MinecraftForge.EVENT_BUS.register(this);
    }

    // You caught a diamond sword, that's a treasure!
    // You caught an enchanted book, that's a treasure!
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onChatMessage(ClientChatReceivedEvent event) {
        String msg = event.message.getUnformattedText();
        if (this.pattern.matcher(msg).matches()) {
            this.count++;
        }
    }
}
