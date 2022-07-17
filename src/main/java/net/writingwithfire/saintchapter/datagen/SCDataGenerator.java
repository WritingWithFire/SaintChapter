package net.writingwithfire.saintchapter.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.writingwithfire.saintchapter.SaintChapter;

@Mod.EventBusSubscriber(modid = SaintChapter.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SCDataGenerator {

    @SubscribeEvent
    public static void gather(GatherDataEvent event) {
        if (!SaintChapter.isDoingDataGeneration()) {
            return;
        }

        DataGenerator gen = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        if (event.includeServer()) {
        }

        if (event.includeClient()) {
        }
    }
}
