package net.ethann.sigmaaddonsv2.feature;

import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Set;

public class FeatureManager {
    private final HashMap<Class<? extends Feature>, Feature> features = new HashMap<>();

    public void load() throws InstantiationException, IllegalAccessException {
        Reflections reflection = new Reflections("net.ethann.sigmaaddonsv2.feature.impl");
        Set<Class<? extends Feature>> classes = reflection.getSubTypesOf(Feature.class);
        for (Class<? extends Feature> clazz : classes) {
            features.put(clazz, clazz.newInstance());
        }
    }

    public Feature getFeature(Class<? extends Feature> clazz) {
        return features.get(clazz);
    }

    public Feature getFeature(String name) {
        return features.values().stream().filter(f -> f.getName().equals(name)).findFirst().orElse(null);
    }

    public Feature[] getFeatures(Category c) {
        return features.values().stream().filter(f -> f.getCategory() == c).toArray(Feature[]::new);
    }
}
