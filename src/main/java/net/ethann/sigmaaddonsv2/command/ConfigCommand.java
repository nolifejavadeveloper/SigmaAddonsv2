package net.ethann.sigmaaddonsv2.command;

import net.ethann.sigmaaddonsv2.SigmaAddons;
import net.ethann.sigmaaddonsv2.ui.clickgui.ClickGUIScreen;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

import java.util.Arrays;
import java.util.List;

public class ConfigCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "sigma";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        SigmaAddons.getInstance().getRenderListener().renderNextTick(new ClickGUIScreen());
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        // duh

        return true;
    }

    @Override
    public List<String> getCommandAliases() {
        return Arrays.asList("sig", "sigaddons", "sigmaaddons", "sigmaaddon", "sigaddon", "saddons", "saddon");
    }
}
