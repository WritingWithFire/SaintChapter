package net.writingwithfire.saintchapter.common.registry.internal;

import com.google.common.collect.Lists;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InternalRegistryPrimer {
    private final Map<Class<?>, List<IForgeRegistryEntry<?>>> primed = new HashMap<>();

    public <V extends IForgeRegistryEntry<V>> V register(V entry) {
        Class<V> type = entry.getRegistryType();
        List<IForgeRegistryEntry<?>> entries = primed.computeIfAbsent(type, k -> Lists.newLinkedList());
        entries.add(entry);
        return entry;
    }

    <T extends IForgeRegistryEntry<T>> List<?> getEntries(Class<T> type) {
        return primed.getOrDefault(type, Collections.emptyList());
    }
}
