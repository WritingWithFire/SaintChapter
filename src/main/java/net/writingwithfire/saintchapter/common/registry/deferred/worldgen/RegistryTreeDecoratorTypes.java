package net.writingwithfire.saintchapter.common.registry.deferred.worldgen;

import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.SaintChapter;

public class RegistryTreeDecoratorTypes {
    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATOR_TYPES = DeferredRegister.create(ForgeRegistries.TREE_DECORATOR_TYPES, SaintChapter.MODID);
}
