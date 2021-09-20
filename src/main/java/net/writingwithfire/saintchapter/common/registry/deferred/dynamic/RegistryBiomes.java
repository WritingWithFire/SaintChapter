package net.writingwithfire.saintchapter.common.registry.deferred.dynamic;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.SaintChapter;

public class RegistryBiomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, SaintChapter.MODID);
}
