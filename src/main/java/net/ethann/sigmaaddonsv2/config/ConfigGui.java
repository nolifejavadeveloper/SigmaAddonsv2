package net.ethann.sigmaaddonsv2.config;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class ConfigGui extends GuiScreen {

    @Override
    public void initGui() {
        super.initGui();
    }

    @Override
    protected void actionPerformed(GuiButton button) {

    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        // darken background
        int left = 10;
        int top = 20;

        //drawRect(0, 0, this.width, this.height, 0x80000000);

        drawRect(left, top, left + 100, top - 20, 0xFFFFFFFF);

        String text = "Centered Text!";

        // Get the width of the text using fontRenderer
        int textWidth = (100 - Minecraft.getMinecraft().fontRendererObj.getStringWidth(text)) / 2;

        Minecraft.getMinecraft().fontRendererObj.drawString(text, left + textWidth, top + ((20 - 9) / 2), 0x000000);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
