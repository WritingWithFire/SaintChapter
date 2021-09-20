package net.writingwithfire.saintchapter.common.registry.deferred.gameobjects;

import net.minecraft.stats.StatType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.SaintChapter;

public class RegistryStatTypes {
    public static final DeferredRegister<StatType<?>> STAT_TYPES = DeferredRegister.create(ForgeRegistries.STAT_TYPES, SaintChapter.MODID);
}
