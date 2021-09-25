package net.writingwithfire.saintchapter.common.world;

import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.writingwithfire.saintchapter.common.registry.deferred.gameobjects.RegistryBlocks;

public class WorldGenHandlers {

    public static void generateOres(final BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder gen = event.getGeneration();

        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryBlocks.MIND_STONE.get().getDefaultState(), 1))
                .range(12)
                .square()
                .count(1));
    }
}
