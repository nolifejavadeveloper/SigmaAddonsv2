package net.ethann.sigmaaddonsv2.listener;

import net.minecraftforge.common.MinecraftForge;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

import java.util.Set;

public class ListenerManager {
    public static void registerListeners() throws InstantiationException, IllegalAccessException {
        Reflections reflections = new Reflections("net.ethann.sigmaaddonsv2.listener.impl");
        Set<Class<?>> classes = reflections.get(Scanners.SubTypes.of(Object.class).asClass());

        for (Class<?> clazz : classes) {
            MinecraftForge.EVENT_BUS.register(clazz.newInstance());
        }
    }
}
