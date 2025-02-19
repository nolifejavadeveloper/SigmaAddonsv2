package net.ethann.sigmaaddonsv2.listener;

import net.minecraftforge.common.MinecraftForge;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListenerManager {
    public void registerListeners() {
        Reflections reflections = new Reflections("net.ethann.sigmaaddonsv2.listener.impl");
        Set<Class<?>> classes = reflections.get(Scanners.SubTypes.of(Object.class).asClass());

        for (Class<?> clazz : classes) {
            try {
                Class<?> instance = (Class<?>) clazz.newInstance();
                MinecraftForge.EVENT_BUS.register(instance);
            } catch (InstantiationException | IllegalAccessException e) {
                Logger.getGlobal().log(Level.SEVERE, "failed to load listeners", e);
            }
        }
    }
}
