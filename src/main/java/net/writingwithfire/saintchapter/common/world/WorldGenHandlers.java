package net.writingwithfire.saintchapter.common.world;

import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class WorldGenHandlers {

    public static void generateOres(final BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder gen = event.getGeneration();
    }
}
