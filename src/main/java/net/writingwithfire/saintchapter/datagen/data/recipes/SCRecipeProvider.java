package net.writingwithfire.saintchapter.datagen.data.recipes;

import net.minecraft.advancements.criterion.*;
import net.minecraft.block.Block;
import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tags.ITag;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
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

//        SaintChapter.LOGGER.info(ForgeRegistries.ITEMS.getEntries().toString());

         // 帕秋莉的书不在注册表中..
        ShapedRecipeBuilder.shapedRecipe(RegistryItems.BOOK_OF_TRUTH.get())
                .patternLine("MMM")
                .patternLine("MBM")
                .patternLine("MMM")
                .key('M', RegistryItems.MIND_CRYSTAL.get())
                .key('B', Items.BOOK)
                .addCriterion("has_item", hasItem(RegistryItems.MIND_CRYSTAL.get()))
                .build(registrar);

    }
}
