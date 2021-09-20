package net.writingwithfire.saintchapter.common.registry.deferred.gameobjects;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.SaintChapter;

public class RegistryEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, SaintChapter.MODID);
}
