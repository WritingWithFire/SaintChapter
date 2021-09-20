package net.writingwithfire.saintchapter.common.registry.deferred.villages;

import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.SaintChapter;

public class RegistrySensorTypes {
    public static final DeferredRegister<SensorType<?>> SENSOR_TYPES = DeferredRegister.create(ForgeRegistries.SENSOR_TYPES, SaintChapter.MODID);
}
