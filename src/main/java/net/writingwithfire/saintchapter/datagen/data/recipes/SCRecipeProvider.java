package net.writingwithfire.saintchapter.datagen.data.recipes;

import net.minecraft.advancements.criterion.*;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tags.ITag;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.SaintChapter;
import net.writingwithfire.saintchapter.common.registry.deferred.gameobjects.RegistryItems;
import net.writingwithfire.saintchapter.datagen.data.recipes.vanilla.VanillaTypeRecipeProvider;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.function.Consumer;

public class SCRecipeProvider extends RecipeProvider {
    public SCRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void registerRecipes(@Nonnull Consumer<IFinishedRecipe> registrar) {
        VanillaTypeRecipeProvider.registerCookingRecipes(registrar);
        VanillaTypeRecipeProvider.registerCustomRecipes(registrar);
        registerShapedRecipes(registrar);
        VanillaTypeRecipeProvider.registerStoneCutterRecipes(registrar);
    }

    public static void registerShapedRecipes(Consumer<IFinishedRecipe> registrar) {

         // 帕秋莉的书在数据生成阶段不在注册表中，所以没有采用合成的方法
        ShapedRecipeBuilder.shapedRecipe(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(SaintChapter.MODID, "debug_and_test"))))
                .patternLine("MMM")
                .patternLine("MBM")
                .patternLine("MMM")
                .key('M', RegistryItems.MIND_CRYSTAL.get())
                .key('B', Items.BOOK)
                .addCriterion("has_item", hasItem(RegistryItems.MIND_CRYSTAL.get()))
                .build(registrar);
    }
}
