package net.writingwithfire.saintchapter.common.registry.deferred.gameobjects;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.SaintChapter;

public class RegistryContainers {
    public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, SaintChapter.MODID);
}
