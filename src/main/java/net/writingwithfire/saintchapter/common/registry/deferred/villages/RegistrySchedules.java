package net.writingwithfire.saintchapter.common.registry.deferred.villages;

import net.minecraft.entity.ai.brain.schedule.Schedule;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.SaintChapter;

public class RegistrySchedules {
    public static final DeferredRegister<Schedule> SCHEDULES = DeferredRegister.create(ForgeRegistries.SCHEDULES, SaintChapter.MODID);
}
