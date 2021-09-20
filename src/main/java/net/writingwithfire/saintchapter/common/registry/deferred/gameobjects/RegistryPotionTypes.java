package net.writingwithfire.saintchapter.common.registry.deferred.gameobjects;

import net.minecraft.potion.Potion;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.SaintChapter;

public class RegistryPotionTypes {
    public static final DeferredRegister<Potion> POTION_TYPES = DeferredRegister.create(ForgeRegistries.POTION_TYPES, SaintChapter.MODID);
}
