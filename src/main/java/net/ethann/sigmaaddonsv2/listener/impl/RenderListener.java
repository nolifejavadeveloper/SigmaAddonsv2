package net.ethann.sigmaaddonsv2.listener.impl;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class RenderListener {
    private GuiScreen guiToRender;

    public RenderListener() {}

    public void renderNextTick(GuiScreen gui) {
        guiToRender = gui;
    }

    @SubscribeEvent()
    public void onRender(TickEvent.RenderTickEvent e) {
        if (guiToRender != null) {
            Minecraft.getMinecraft().displayGuiScreen(guiToRender);
            guiToRender = null;
        }
    }
}
