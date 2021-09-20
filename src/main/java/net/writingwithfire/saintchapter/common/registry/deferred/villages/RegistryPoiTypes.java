package net.writingwithfire.saintchapter.common.registry.deferred.villages;

import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.SaintChapter;

public class RegistryPoiTypes {
    public static final DeferredRegister<PointOfInterestType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, SaintChapter.MODID);
}
