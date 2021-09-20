package net.writingwithfire.saintchapter.common.registry.deferred.worldgen;

import net.minecraft.world.gen.blockplacer.BlockPlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.SaintChapter;

public class RegistryBlockPlacerTypes {
    public static final DeferredRegister<BlockPlacerType<?>> BLOCK_PLACER_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_PLACER_TYPES, SaintChapter.MODID);
}
