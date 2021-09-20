package net.writingwithfire.saintchapter.common.registry.deferred.worldgen;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.SaintChapter;

public class RegistrySurfaceBuilders {
    public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, SaintChapter.MODID);
}
