package net.writingwithfire.saintchapter.datagen.assets.model;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.writingwithfire.saintchapter.SaintChapter;
import net.writingwithfire.saintchapter.common.block.BlockWritingDesk;
import net.writingwithfire.saintchapter.common.lib.LibBlocks;
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

        this.getVariantBuilder(RegistryBlocks.WRITING_DESK.get())
                .partialState().with(BlockWritingDesk.HORIZONTAL_FACING, Direction.EAST).with(BlockWritingDesk.DESK_TYPE, BlockWritingDesk.DeskType.NONE)
                .addModels(new ConfiguredModel(model("writing_desk_none"), 0, 270, false))
                .partialState().with(BlockWritingDesk.HORIZONTAL_FACING, Direction.EAST).with(BlockWritingDesk.DESK_TYPE, BlockWritingDesk.DeskType.LITTLE)
                .addModels(new ConfiguredModel(model("writing_desk_little"), 0, 270, false))
                .partialState().with(BlockWritingDesk.HORIZONTAL_FACING, Direction.EAST).with(BlockWritingDesk.DESK_TYPE, BlockWritingDesk.DeskType.MEDIUM)
                .addModels(new ConfiguredModel(model("writing_desk_medium"), 0, 270, false))
                .partialState().with(BlockWritingDesk.HORIZONTAL_FACING, Direction.EAST).with(BlockWritingDesk.DESK_TYPE, BlockWritingDesk.DeskType.MANY)
                .addModels(new ConfiguredModel(model("writing_desk_many"), 0, 270, false))
                .partialState().with(BlockWritingDesk.HORIZONTAL_FACING, Direction.EAST).with(BlockWritingDesk.DESK_TYPE, BlockWritingDesk.DeskType.FULL)
                .addModels(new ConfiguredModel(model("writing_desk_full"), 0, 270, false))
                .partialState().with(BlockWritingDesk.HORIZONTAL_FACING, Direction.SOUTH).with(BlockWritingDesk.DESK_TYPE, BlockWritingDesk.DeskType.NONE)
                .addModels(new ConfiguredModel(model("writing_desk_none"), 0, 0, false))
                .partialState().with(BlockWritingDesk.HORIZONTAL_FACING, Direction.SOUTH).with(BlockWritingDesk.DESK_TYPE, BlockWritingDesk.DeskType.LITTLE)
                .addModels(new ConfiguredModel(model("writing_desk_little"), 0, 0, false))
                .partialState().with(BlockWritingDesk.HORIZONTAL_FACING, Direction.SOUTH).with(BlockWritingDesk.DESK_TYPE, BlockWritingDesk.DeskType.MEDIUM)
                .addModels(new ConfiguredModel(model("writing_desk_medium"), 0, 0, false))
                .partialState().with(BlockWritingDesk.HORIZONTAL_FACING, Direction.SOUTH).with(BlockWritingDesk.DESK_TYPE, BlockWritingDesk.DeskType.MANY)
                .addModels(new ConfiguredModel(model("writing_desk_many"), 0, 0, false))
                .partialState().with(BlockWritingDesk.HORIZONTAL_FACING, Direction.SOUTH).with(BlockWritingDesk.DESK_TYPE, BlockWritingDesk.DeskType.FULL)
                .addModels(new ConfiguredModel(model("writing_desk_full"), 0, 0, false))
                .partialState().with(BlockWritingDesk.HORIZONTAL_FACING, Direction.WEST).with(BlockWritingDesk.DESK_TYPE, BlockWritingDesk.DeskType.NONE)
                .addModels(new ConfiguredModel(model("writing_desk_none"), 0, 90, false))
                .partialState().with(BlockWritingDesk.HORIZONTAL_FACING, Direction.WEST).with(BlockWritingDesk.DESK_TYPE, BlockWritingDesk.DeskType.LITTLE)
                .addModels(new ConfiguredModel(model("writing_desk_little"), 0, 90, false))
                .partialState().with(BlockWritingDesk.HORIZONTAL_FACING, Direction.WEST).with(BlockWritingDesk.DESK_TYPE, BlockWritingDesk.DeskType.MEDIUM)
                .addModels(new ConfiguredModel(model("writing_desk_medium"), 0, 90, false))
                .partialState().with(BlockWritingDesk.HORIZONTAL_FACING, Direction.WEST).with(BlockWritingDesk.DESK_TYPE, BlockWritingDesk.DeskType.MANY)
                .addModels(new ConfiguredModel(model("writing_desk_many"), 0, 90, false))
                .partialState().with(BlockWritingDesk.HORIZONTAL_FACING, Direction.WEST).with(BlockWritingDesk.DESK_TYPE, BlockWritingDesk.DeskType.FULL)
                .addModels(new ConfiguredModel(model("writing_desk_full"), 0, 90, false))
                .partialState().with(BlockWritingDesk.HORIZONTAL_FACING, Direction.NORTH).with(BlockWritingDesk.DESK_TYPE, BlockWritingDesk.DeskType.NONE)
                .addModels(new ConfiguredModel(model("writing_desk_none"), 0, 180, false))
                .partialState().with(BlockWritingDesk.HORIZONTAL_FACING, Direction.NORTH).with(BlockWritingDesk.DESK_TYPE, BlockWritingDesk.DeskType.LITTLE)
                .addModels(new ConfiguredModel(model("writing_desk_little"), 0, 180, false))
                .partialState().with(BlockWritingDesk.HORIZONTAL_FACING, Direction.NORTH).with(BlockWritingDesk.DESK_TYPE, BlockWritingDesk.DeskType.MEDIUM)
                .addModels(new ConfiguredModel(model("writing_desk_medium"), 0, 180, false))
                .partialState().with(BlockWritingDesk.HORIZONTAL_FACING, Direction.NORTH).with(BlockWritingDesk.DESK_TYPE, BlockWritingDesk.DeskType.MANY)
                .addModels(new ConfiguredModel(model("writing_desk_many"), 0, 180, false))
                .partialState().with(BlockWritingDesk.HORIZONTAL_FACING, Direction.NORTH).with(BlockWritingDesk.DESK_TYPE, BlockWritingDesk.DeskType.FULL)
                .addModels(new ConfiguredModel(model("writing_desk_full"), 0, 180, false));
        simpleBlockItem(RegistryBlocks.WRITING_DESK.get(), model("writing_desk_little"));

//        simpleBlock(RegistryBlocks.DEBUG_AND_TEST.get(), models().cubeAll(LibName.BlockName.DEBUG_AND_TEST, new ResourceLocation("minecraft", "block/stone")));
        simpleBlock(LibBlocks.MIND_TANK, model(LibName.BlockName.MIND_TANK));
        simpleBlockItem(LibBlocks.MIND_TANK, model(LibName.BlockName.MIND_TANK));
    }

    private void simpleBlockGen(Block block) {
        simpleBlock(block);
        simpleBlockItem(block);
    }

    private void simpleBlockItem(Block block) {
        simpleBlockItem(block, cubeAll(block));
    }

    private static ModelFile model(ResourceLocation name) {
        return new ModelFile.UncheckedModelFile(prefixPath(name, "block/"));
    }

    // 对于Blockbence创建的模型，其实只需要导出的模型就行了
    private static ModelFile model(String name) {
        return new ModelFile.UncheckedModelFile(new ResourceLocation(SaintChapter.MODID, "block/" + name));
    }

    private static ResourceLocation prefixPath(ResourceLocation key, String prefix) {
        return new ResourceLocation(key.getNamespace(), prefix + key.getPath());
    }
}
