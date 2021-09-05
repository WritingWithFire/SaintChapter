package net.writingwithfire.saintchapter.common.registry.deferred.worldgen;

import net.minecraft.world.chunk.ChunkStatus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryChunkStatus {
    public static final DeferredRegister<ChunkStatus> CHUNK_STATUS = DeferredRegister.create(ForgeRegistries.CHUNK_STATUS, "saintchapter");
}
