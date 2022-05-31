package me.ttrss.fishyclient.stats;

import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.regex.Pattern;

public class TrashCount extends Count {

    private Pattern pattern;

    public TrashCount(int initial) {
        super("(Session) Trash", initial);
        this.customColor = (int)Long.parseLong("ffff5555", 16);
        this.pattern = Pattern.compile("^Oh no, you caught .*", Pattern.MULTILINE);
        MinecraftForge.EVENT_BUS.register(this);
    }

    // Oh no, you caught string!
    // Oh no, you caught leather!
    // Oh no, you caught bone!
    // Oh no, you caught lily pad!
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onChatMessage(ClientChatReceivedEvent event) {
        String msg = event.message.getUnformattedText();
        if (this.pattern.matcher(msg).matches()) {
            this.count++;
        }
    }
}
