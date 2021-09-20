package net.writingwithfire.saintchapter.common.registry.deferred.gameobjects;

import net.minecraft.particles.ParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.writingwithfire.saintchapter.SaintChapter;

public class RegisterParticleTypes {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, SaintChapter.MODID);
}
