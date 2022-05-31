package me.ttrss.fishyclient.stats;

import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

@SideOnly(Side.CLIENT)
public class FishCount extends Count {

    private Pattern pattern;

    public FishCount(int initial) {
        super("(Session) Fish", initial);
        this.customColor = (int)Long.parseLong("fff3f379", 16);
        this.pattern = Pattern.compile("^You caught a \\S*", Pattern.MULTILINE);
        MinecraftForge.EVENT_BUS.register(this);
    }

    // You caught a cod!
    // You caught a salmon!
    // You caught a clownfish!
    // You caught a pufferfish!
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onChatMessage(ClientChatReceivedEvent event) {
        String msg = event.message.getUnformattedText();
        if (this.pattern.matcher(msg).matches()) {
            this.count++;
        }
    }
}
