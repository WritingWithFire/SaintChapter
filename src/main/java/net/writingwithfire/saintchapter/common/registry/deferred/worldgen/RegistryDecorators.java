package net.writingwithfire.saintchapter.common.registry.deferred.worldgen;

import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.SaintChapter;

public class RegistryDecorators {
    public static final DeferredRegister<Placement<?>> DECORATORS = DeferredRegister.create(ForgeRegistries.DECORATORS, SaintChapter.MODID);
}
