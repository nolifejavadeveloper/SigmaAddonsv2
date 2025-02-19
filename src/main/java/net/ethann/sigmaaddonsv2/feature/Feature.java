package net.ethann.sigmaaddonsv2.feature;

import lombok.Getter;
import net.ethann.sigmaaddonsv2.util.ChatUtil;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Logger;

public abstract class Feature {
    Minecraft mc = Minecraft.getMinecraft();
    @Getter
    protected String name;
    @Getter
    protected String description;
    @Getter
    protected boolean enabled;
    @Getter
    protected Category category;
    @Getter
    protected List<net.ethann.sigmaaddonsv2.feature.field.Field<?>> fields;


    public Feature() {
        FeatureInfo info = getClass().getAnnotation(FeatureInfo.class);
        if (info == null) {
            Logger.getGlobal().severe("feature " + getClass().getName() + " has no @FeatureInfo annotation");
            return;
        }

        name = info.name();
        description = info.description();
        enabled = info.enabledByDefault();
        category = info.category();

        // scanning for values
//        for (Field field : getClass().getDeclaredFields()) {
//            field.setAccessible(true);
//            try {
//                fields.add((net.ethann.sigmaaddonsv2.feature.field.Field<?>) field.get(this));
//            } catch (IllegalAccessException e) {
//                Logger.getGlobal().severe("cannot access field " + field.getName() + " in feature " + getClass().getName());
//                return;
//            }
//        }
    }

    public void setEnabled(boolean enabled) {
        if (enabled == this.enabled) return;

        this.enabled = enabled;
        String status;
        if (enabled) {
            MinecraftForge.EVENT_BUS.register(this);

            status = "&aenabled";
            onEnable();
        }else {
            MinecraftForge.EVENT_BUS.unregister(this);

            status = "&cdisabled";
            onDisable();
        }

        ChatUtil.sendMessageAsMod("sigma enabled!");
    }

    public abstract void onDisable();
    public abstract void onEnable();
}
