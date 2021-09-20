package net.writingwithfire.saintchapter.common.registry.deferred.custom.forge;

import net.minecraftforge.registries.DataSerializerEntry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.SaintChapter;

public class RegistryDataSerializers {
    public static final DeferredRegister<DataSerializerEntry> DATA_SERIALIZERS = DeferredRegister.create(ForgeRegistries.DATA_SERIALIZERS, SaintChapter.MODID);
}
