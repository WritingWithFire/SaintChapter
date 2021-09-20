package net.writingwithfire.saintchapter.common.registry.deferred.villages;

import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.SaintChapter;

public class RegistryProfessions {
    public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(ForgeRegistries.PROFESSIONS, SaintChapter.MODID);
}
