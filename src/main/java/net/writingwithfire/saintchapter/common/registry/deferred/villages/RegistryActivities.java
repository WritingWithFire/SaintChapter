package net.writingwithfire.saintchapter.common.registry.deferred.villages;

import net.minecraft.entity.ai.brain.schedule.Activity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.SaintChapter;

public class RegistryActivities {
    public static final DeferredRegister<Activity> ACTIVITIES = DeferredRegister.create(ForgeRegistries.ACTIVITIES, SaintChapter.MODID);
}
