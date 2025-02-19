package net.ethann.sigmaaddonsv2.util;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class ChatUtil {
    public static final char COLOR_SYMBOL = '§';
    public static final IChatComponent PREFIX = new ChatComponentText(COLOR_SYMBOL + "6" + "SigmaAddons " + COLOR_SYMBOL + "7> " + COLOR_SYMBOL + "r");

    public static void sendMessageAsMod(String s) {
        Minecraft.getMinecraft().thePlayer.addChatMessage(PREFIX.appendText(s));
    }
}
