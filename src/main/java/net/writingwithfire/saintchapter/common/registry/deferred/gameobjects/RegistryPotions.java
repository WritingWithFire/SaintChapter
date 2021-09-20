package net.writingwithfire.saintchapter.common.registry.deferred.gameobjects;

import net.minecraft.potion.Effect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.SaintChapter;

public class RegistryPotions {
    public static final DeferredRegister<Effect> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, SaintChapter.MODID);
}
