package net.writingwithfire.saintchapter.common.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.writingwithfire.saintchapter.common.tile.TileMindStone;
import net.writingwithfire.saintchapter.common.tile.TileMindTank;

import javax.annotation.Nullable;

public class BlockMindTank extends Block {
    private final VoxelShape shape;

    public BlockMindTank() {
        super(Properties.create(Material.ROCK).notSolid().hardnessAndResistance(5));

        this.shape = makeShape();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileMindTank();
    }

    private VoxelShape makeShape(){
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.or(shape, VoxelShapes.create(0.25, 0.25, 0.25, 0.75, 0.75, 0.75));
        shape = VoxelShapes.or(shape, VoxelShapes.create(0, 0, 0, 1, 0.0625, 1));
        shape = VoxelShapes.or(shape, VoxelShapes.create(0, 0.9375, 0, 1, 1, 1));
        shape = VoxelShapes.or(shape, VoxelShapes.create(0, 0.0625, 0.9375, 0.0625, 0.9375, 1));
        shape = VoxelShapes.or(shape, VoxelShapes.create(0.1875, 0.0625, 0.9375, 0.25, 0.9375, 1));
        shape = VoxelShapes.or(shape, VoxelShapes.create(0.4375, 0.0625, 0.9375, 0.5, 0.9375, 1));
        shape = VoxelShapes.or(shape, VoxelShapes.create(0.6875, 0.0625, 0.9375, 0.75, 0.9375, 1));
        shape = VoxelShapes.or(shape, VoxelShapes.create(0.9375, 0.0625, 0.9375, 1, 0.9375, 1));
        shape = VoxelShapes.or(shape, VoxelShapes.create(0, 0.0625, 0, 0.0625, 0.9375, 0.0625));
        shape = VoxelShapes.or(shape, VoxelShapes.create(0.1875, 0.0625, 0, 0.25, 0.9375, 0.0625));
        shape = VoxelShapes.or(shape, VoxelShapes.create(0.4375, 0.0625, 0, 0.5, 0.9375, 0.0625));
        shape = VoxelShapes.or(shape, VoxelShapes.create(0.6875, 0.0625, 0, 0.75, 0.9375, 0.0625));
        shape = VoxelShapes.or(shape, VoxelShapes.create(0.9375, 0.0625, 0, 1, 0.9375, 0.0625));
        shape = VoxelShapes.or(shape, VoxelShapes.create(0, 0.0625, 0.75, 0.0625, 0.9375, 0.8125));
        shape = VoxelShapes.or(shape, VoxelShapes.create(0, 0.0625, 0.5625, 0.0625, 0.9375, 0.625));
        shape = VoxelShapes.or(shape, VoxelShapes.create(0, 0.0625, 0.375, 0.0625, 0.9375, 0.4375));
        shape = VoxelShapes.or(shape, VoxelShapes.create(0, 0.0625, 0.1875, 0.0625, 0.9375, 0.25));
        shape = VoxelShapes.or(shape, VoxelShapes.create(0.9375, 0.0625, 0.75, 1, 0.9375, 0.8125));
        shape = VoxelShapes.or(shape, VoxelShapes.create(0.9375, 0.0625, 0.5625, 1, 0.9375, 0.625));
        shape = VoxelShapes.or(shape, VoxelShapes.create(0.9375, 0.0625, 0.375, 1, 0.9375, 0.4375));
        shape = VoxelShapes.or(shape, VoxelShapes.create(0.9375, 0.0625, 0.1875, 1, 0.9375, 0.25));
        shape = VoxelShapes.or(shape, VoxelShapes.create(0.25, 0.25, 0.25, 0.75, 0.75, 0.75));

        return shape;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return this.shape;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }
}
