package net.writingwithfire.saintchapter.datagen;

import net.minecraft.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.writingwithfire.saintchapter.SaintChapter;
import net.writingwithfire.saintchapter.datagen.assets.language.SCLanguageProvider_en_us;
import net.writingwithfire.saintchapter.datagen.assets.language.SCLanguageProvider_zh_cn;
import net.writingwithfire.saintchapter.datagen.assets.model.SCBlockModelProvider;
import net.writingwithfire.saintchapter.datagen.assets.model.SCBlockStateProvider;
import net.writingwithfire.saintchapter.datagen.assets.model.SCItemModelProvider;
import net.writingwithfire.saintchapter.datagen.data.advancements.SCAdvancementProvider;
import net.writingwithfire.saintchapter.datagen.data.loot.SCGlobalLootModifierProvider;
import net.writingwithfire.saintchapter.datagen.data.loot.SCLootTableProvider;
import net.writingwithfire.saintchapter.datagen.data.recipes.SCRecipeProvider;
import net.writingwithfire.saintchapter.datagen.data.tags.SCBlockTagsProvider;
import net.writingwithfire.saintchapter.datagen.data.tags.SCItemTagsProvider;

@Mod.EventBusSubscriber(modid = SaintChapter.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SCDataGenerator {

    @SubscribeEvent
    public static void gather(GatherDataEvent event) {
        if (!SaintChapter.isDoingDataGeneration()) {
            return;
        }

        net.minecraft.data.DataGenerator gen = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        if (event.includeServer()) {
            gen.addProvider(new SCAdvancementProvider(gen));
            gen.addProvider(new SCGlobalLootModifierProvider(gen, SaintChapter.MODID));
            gen.addProvider(new SCLootTableProvider(gen));
            gen.addProvider(new SCRecipeProvider(gen));
            BlockTagsProvider blockTagsProvider = new SCBlockTagsProvider(gen, fileHelper);
            gen.addProvider(blockTagsProvider);
            gen.addProvider(new SCItemTagsProvider(gen, blockTagsProvider, fileHelper));
        }

        if (event.includeClient()) {
            gen.addProvider(new SCLanguageProvider_en_us(gen, SaintChapter.MODID, "en_us"));
            gen.addProvider(new SCLanguageProvider_zh_cn(gen, SaintChapter.MODID, "zh_cn"));
            gen.addProvider(new SCItemModelProvider(gen, SaintChapter.MODID, fileHelper));
            gen.addProvider(new SCBlockStateProvider(gen, SaintChapter.MODID, fileHelper));
            gen.addProvider(new SCBlockModelProvider(gen, SaintChapter.MODID, fileHelper));
        }
    }
}
