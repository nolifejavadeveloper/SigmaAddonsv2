package net.ethann.sigmaaddonsv2;

import net.ethann.sigmaaddonsv2.command.ConfigCommand;
import net.ethann.sigmaaddonsv2.listener.RenderListener;
import net.minecraft.command.CommandBase;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = SigmaAddons.MOD_ID, useMetadata=true)
public class SigmaAddons {
    public static final String MOD_ID = "sigmaaddonsv2";
    private static SigmaAddons instance;

    public RenderListener renderListener = new RenderListener();

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        instance = this;

        MinecraftForge.EVENT_BUS.register(renderListener);

        registerCommands();
    }


    private void registerCommands() {
        regCommand(new ConfigCommand());
    }

    private void regCommand(CommandBase command) {
        ClientCommandHandler.instance.registerCommand(command);
    }

    public static SigmaAddons getInstance() {
        return instance;
    }
}
