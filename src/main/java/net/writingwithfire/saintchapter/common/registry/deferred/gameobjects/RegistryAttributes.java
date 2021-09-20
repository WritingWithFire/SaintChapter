package net.writingwithfire.saintchapter.common.registry.deferred.gameobjects;

import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.SaintChapter;

public class RegistryAttributes {
    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, SaintChapter.MODID);
}
