package net.ethann.sigmaaddonsv2.feature;

import lombok.Getter;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

import java.lang.reflect.Field;

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


    public Feature() {
        FeatureInfo info = getClass().getAnnotation(FeatureInfo.class);
        if (info == null) {
            throw new NullPointerException("feature " + getClass().getName() + " has no @FeatureInfo annotation");
        }

        name = info.name();
        description = info.description();
        enabled = info.enabledByDefault();
        category = info.category();

        // scanning for values
        for (Field field : getClass().getFields()) {
            FieldInfo fieldInfo = field.getAnnotation(FieldInfo.class);
            if (fieldInfo != null) {
                // config field

            }
        }
    }

    public void setEnabled(boolean enabled) {
        if (enabled == this.enabled) return;

        this.enabled = enabled;
        if (enabled) {
            MinecraftForge.EVENT_BUS.register(this);

            onEnable();
        }else {
            MinecraftForge.EVENT_BUS.unregister(this);

            onDisable();
        }
    }

    public abstract void onDisable();
    public abstract void onEnable();
}
