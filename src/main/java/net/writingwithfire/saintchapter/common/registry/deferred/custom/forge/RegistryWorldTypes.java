package net.writingwithfire.saintchapter.common.registry.deferred.custom.forge;

import net.minecraftforge.common.world.ForgeWorldType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.SaintChapter;

public class RegistryWorldTypes {
    public static final DeferredRegister<ForgeWorldType> WORLD_TYPES = DeferredRegister.create(ForgeRegistries.WORLD_TYPES, SaintChapter.MODID);
}
