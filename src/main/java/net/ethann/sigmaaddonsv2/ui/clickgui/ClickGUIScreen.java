package net.ethann.sigmaaddonsv2.ui.clickgui;

import net.ethann.sigmaaddonsv2.feature.Feature;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClickGUIScreen extends GuiScreen {
    FontRenderer fontRenderer = Minecraft.getMinecraft().fontRendererObj;
    ScaledResolution scaledresolution = new ScaledResolution(Minecraft.getMinecraft());

    final int topBarHeight = 40;

    final int backgroundWidth = 700;
    final int backgroundHeight = 500;

    final int backgroundX = scaledresolution.getScaledWidth() / 2 - backgroundWidth / 2;
    final int backgroundY = scaledresolution.getScaledHeight() / 2 - backgroundHeight / 2;

    private boolean isInSearchbar = false;
    final int searchBarRightPadding = 30;
    final int searchBarLineLength = 100;
    final int searchBarTextToLinePadding = 1;
    final int searchBarTextOffset = 2;

    final double searchBarFontScaleFactor = 1.5;

    final int searchBarHeight = (int) ((fontRenderer.FONT_HEIGHT * searchBarFontScaleFactor) + searchBarTextToLinePadding + 1);
    final int searchBarX = backgroundX + backgroundWidth - searchBarRightPadding - searchBarLineLength;
    final int searchBarY = backgroundY + ((topBarHeight - searchBarHeight) / 2);
    private int searchBarEntryWidth = 0;
    private String searchBarDisplay = "";
    private String searchBarEntry = "";


    private List<Feature> selectedFeatures = new ArrayList<>();

    @Override
    public void initGui() {
        super.initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        // BACKGROUND
        drawRect(backgroundX, backgroundY, backgroundX + backgroundWidth, backgroundY + backgroundHeight, 0x4C000000);
        drawRect(backgroundX, backgroundY, backgroundX + backgroundWidth, backgroundY + topBarHeight, 0x6C000000);

        drawTitle();
        drawSearchBar();
    }

    @Override
    protected void mouseClicked(final int mouseX, final int mouseY, final int mouseButton) throws IOException {
        System.out.println(isClickOnSearchBar(mouseX, mouseY));
        isInSearchbar = isClickOnSearchBar(mouseX, mouseY);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        if (keyCode == 1) {
            this.mc.displayGuiScreen(null);
        }

        if (isInSearchbar) {
            updateSearch(typedChar);
        }
    }

    private void drawTitle() {
        double scaleFactor = 2;
        GlStateManager.pushMatrix();

        GlStateManager.translate(backgroundX + 20, backgroundY + ((topBarHeight - (scaleFactor * fontRenderer.FONT_HEIGHT)) / 2), 0);
        GlStateManager.scale(scaleFactor, scaleFactor, 1);

        fontRenderer.drawString("SigmaAddons V2",0, 0, 0xFFFFFFFF);
        GlStateManager.popMatrix();
    }

    private void updateSearch(char c) {
        searchBarEntry += c;
        searchBarEntryWidth += fontRenderer.getCharWidth(c);
        searchBarDisplay += c;
        while (searchBarEntryWidth > searchBarLineLength / searchBarFontScaleFactor) {
            char removing = searchBarDisplay.charAt(0);
            searchBarDisplay = searchBarDisplay.substring(1);
            searchBarEntryWidth -= fontRenderer.getCharWidth(removing);
            System.out.println(searchBarEntryWidth);
        }
    }
    private void drawSearchBar() {
        GlStateManager.pushMatrix();
        GlStateManager.translate(searchBarX, searchBarY, 0);
        drawRect(0, (int) (fontRenderer.FONT_HEIGHT * searchBarFontScaleFactor) + searchBarTextToLinePadding, searchBarLineLength, (int) (fontRenderer.FONT_HEIGHT * searchBarFontScaleFactor) + searchBarTextToLinePadding + 1, 0xFFFFFFFF);
        GlStateManager.translate(searchBarTextToLinePadding, 0, 0);
        GlStateManager.scale(searchBarFontScaleFactor, searchBarFontScaleFactor, 1);
        fontRenderer.drawString(searchBarEntry.isEmpty() ? "Search" : searchBarDisplay,0, 0, 0xFFFFFFFF);
        GlStateManager.popMatrix();
    }

    private boolean isClickOnSearchBar(int x, int y) {
        return x >= searchBarX && x <= searchBarX + searchBarLineLength && y >= searchBarY && y <= searchBarY + searchBarHeight;
    }
}
