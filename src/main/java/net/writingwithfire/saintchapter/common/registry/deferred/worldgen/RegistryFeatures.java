package net.writingwithfire.saintchapter.common.registry.deferred.worldgen;

import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.SaintChapter;

public class RegistryFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, SaintChapter.MODID);
}
