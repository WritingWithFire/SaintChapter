package net.writingwithfire.saintchapter.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.StemBlock;
import net.minecraft.block.material.Material;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.writingwithfire.saintchapter.common.tile.TileMindStone;

import javax.annotation.Nullable;

public class BlockWritingDesk extends Block {

    public static final DirectionProperty HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final EnumProperty<DeskType> DESK_TYPE = EnumProperty.create("desk_type", DeskType.class);

    private final VoxelShape shape_none, shape_little, shape_medium, shape_many, shape_full;

    public BlockWritingDesk() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(10).harvestLevel(1).sound(SoundType.ANVIL).notSolid());
        this.setDefaultState(this.getStateContainer().getBaseState().with(HORIZONTAL_FACING, Direction.EAST).with(DESK_TYPE, DeskType.LITTLE));
        this.shape_none = makeShape();
        this.shape_little = addShape1();
        this.shape_medium = addShape2();
        this.shape_many = addShape3();
        this.shape_full = addShape4();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileMindStone();
    }

    public VoxelShape makeShape() {
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.or(shape, VoxelShapes.create(0.1875, 0, 0.1875, 0.8125, 0.0625, 0.8125));
        shape = VoxelShapes.or(shape, VoxelShapes.create(0.3125, 0.0625, 0.3125, 0.6875, 0.625, 0.6875));
        shape = VoxelShapes.or(shape, VoxelShapes.create(0.0625, 0.625, 0.0625, 0.9375, 0.6875, 0.9375));
        return shape;
    }

    public VoxelShape addShape1() {
        VoxelShape shape = shape_none;
        shape = VoxelShapes.or(shape, VoxelShapes.create(0.75, 0.6875, 0.125, 0.8125, 1, 0.3125));
        shape = VoxelShapes.or(shape, VoxelShapes.create(0.8125, 0.6875, 0.125, 0.875, 0.9375, 0.3125));
        return shape;
    }

    public VoxelShape addShape2() {
        VoxelShape shape = shape_little;
        shape = VoxelShapes.or(shape, VoxelShapes.create(0.6875, 0.6875, 0.125, 0.75, 0.9375, 0.3125));
        shape = VoxelShapes.or(shape, VoxelShapes.create(0.625, 0.6875, 0.125, 0.6875, 0.9375, 0.3125));
        return shape;
    }

    public VoxelShape addShape3() {
        VoxelShape shape = shape_medium;
        shape = VoxelShapes.or(shape, VoxelShapes.create(0.5625, 0.6875, 0.125, 0.625, 1, 0.3125));
        shape = VoxelShapes.or(shape, VoxelShapes.create(0.5, 0.6875, 0.125, 0.5625, 0.9375, 0.3125));
        return shape;
    }

    public VoxelShape addShape4() {
        VoxelShape shape = shape_many;
        shape = VoxelShapes.or(shape, VoxelShapes.create(0.4375, 0.6875, 0.125, 0.5, 0.9375, 0.3125));
        shape = VoxelShapes.or(shape, VoxelShapes.create(0.375, 0.6875, 0.125, 0.4375, 0.9375, 0.3125));
        return shape;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(HORIZONTAL_FACING, DESK_TYPE);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(DESK_TYPE)) {
            case NONE:
                return this.shape_none;
            case LITTLE:
                return this.shape_little;
            case MEDIUM:
                return this.shape_medium;
            case MANY:
                return this.shape_many;
            case FULL:
                return this.shape_full;
            default:
                return null;
        }
    }

    public static enum DeskType implements IStringSerializable {
        NONE("little"),
        LITTLE("small"),
        MEDIUM("medium"),
        MANY("large"),
        FULL("full");

        private final String name;

        private DeskType(String name) {
            this.name = name;
        }

        @Override
        public String getString() {
            return this.name;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
}
