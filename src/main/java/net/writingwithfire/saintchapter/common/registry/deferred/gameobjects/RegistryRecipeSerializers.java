package net.writingwithfire.saintchapter.common.registry.deferred.gameobjects;

import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.SaintChapter;

public class RegistryRecipeSerializers {
    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERs = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, SaintChapter.MODID);
}
