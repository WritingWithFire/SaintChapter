package net.writingwithfire.saintchapter.common.registry.deferred.worldgen;

import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.SaintChapter;

public class RegistryWorldCarvers {
    public static final DeferredRegister<WorldCarver<?>> WORLD_CARVERS = DeferredRegister.create(ForgeRegistries.WORLD_CARVERS, SaintChapter.MODID);
}
