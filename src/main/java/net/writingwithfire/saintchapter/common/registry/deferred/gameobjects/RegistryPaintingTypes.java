package net.writingwithfire.saintchapter.common.registry.deferred.gameobjects;

import net.minecraft.entity.item.PaintingType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryPaintingTypes {
    public static final DeferredRegister<PaintingType> PAINTING_TYPES = DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, "saintchapter");
}
