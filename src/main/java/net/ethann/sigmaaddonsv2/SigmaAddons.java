package net.ethann.sigmaaddonsv2;

import lombok.Getter;
import net.ethann.sigmaaddonsv2.command.ConfigCommand;
import net.ethann.sigmaaddonsv2.feature.FeatureManager;
import net.ethann.sigmaaddonsv2.listener.ListenerManager;
import net.ethann.sigmaaddonsv2.listener.impl.RenderListener;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = SigmaAddons.MOD_ID, useMetadata=true)
@Getter
public class SigmaAddons {
    public static final String MOD_ID = "sigmaaddonsv2";
    @Getter
    private static SigmaAddons instance;

    @Getter
    private final RenderListener renderListener = new RenderListener();

    private FeatureManager featureManager;


    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        instance = this;

        featureManager = new FeatureManager();

        MinecraftForge.EVENT_BUS.register(renderListener);

        registerCommands();
    }


    private void registerCommands() {
        regCommand(new ConfigCommand());
    }

    private void regCommand(CommandBase command) {
        ClientCommandHandler.instance.registerCommand(command);
    }
}
