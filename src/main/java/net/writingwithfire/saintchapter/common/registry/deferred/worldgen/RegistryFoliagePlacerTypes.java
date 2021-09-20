package net.writingwithfire.saintchapter.common.registry.deferred.worldgen;

import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.SaintChapter;

public class RegistryFoliagePlacerTypes {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER_TYPES = DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, SaintChapter.MODID);
}
