package net.writingwithfire.saintchapter.datagen.assets.model;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.writingwithfire.saintchapter.common.lib.LibName;
import net.writingwithfire.saintchapter.common.registry.deferred.gameobjects.RegistryBlocks;

public class SCBlockStateProvider extends BlockStateProvider {
    public SCBlockStateProvider(DataGenerator gen, String modid, ExistingFileHelper fileHelper) {
        super(gen, modid, fileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockGen(RegistryBlocks.MIND_STONE.get());
        simpleBlockGen(RegistryBlocks.IMPREGNATED_STONE.get());
        simpleBlockGen(RegistryBlocks.DEBUG_AND_TEST.get());

//        simpleBlock(RegistryBlocks.DEBUG_AND_TEST.get(), models().cubeAll(LibName.BlockName.DEBUG_AND_TEST, new ResourceLocation("minecraft", "block/stone")));
    }

    private void simpleBlockGen(Block block) {
        simpleBlock(block);
        simpleBlockItem(block);
    }

    private void simpleBlockItem(Block block) {
        simpleBlockItem(block, cubeAll(block));
    }
}
