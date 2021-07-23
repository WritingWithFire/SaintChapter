package net.writingwithfire.saintchapter.common.registry.deferred;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistrySounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "saintchapter");

    public static final RegistryObject<SoundEvent> HEART_BEAT = SOUNDS.register("heart_beat", () -> new SoundEvent(new ResourceLocation("saintchapter", "heart_beat")));
}
