package net.writingwithfire.saintchapter.datagen.assets.model;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.writingwithfire.saintchapter.common.registry.deferred.gameobjects.RegistryBlocks;

public class SCBlockStateProvider extends BlockStateProvider {
    public SCBlockStateProvider(DataGenerator gen, String modid, ExistingFileHelper fileHelper) {
        super(gen, modid, fileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(RegistryBlocks.MIND_STONE.get());
        simpleBlockItem(RegistryBlocks.MIND_STONE.get());
        simpleBlock(RegistryBlocks.IMPREGNATED_STONE.get());
        simpleBlockItem(RegistryBlocks.IMPREGNATED_STONE.get());
    }

    private void simpleBlockItem(Block block) {
        simpleBlockItem(block, cubeAll(block));
    }
}
