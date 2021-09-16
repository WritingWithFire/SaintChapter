package net.writingwithfire.saintchapter.common.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.FireBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class BlockDreamFire extends FireBlock {
    public BlockDreamFire() {
        super(AbstractBlock.Properties.create(Material.FIRE, MaterialColor.TNT).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
            return 15;
        }).sound(SoundType.CLOTH));
    }

    @Override
    protected boolean canDie(@Nonnull World worldIn, @Nonnull BlockPos pos) {
        return false;
    }

    @Override
    public boolean canCatchFire(@Nonnull IBlockReader world, @Nonnull BlockPos pos, @Nonnull Direction face) {
        return true;
    }

    @Override
    public int getFlammability(@Nonnull BlockState state) {
        return 300;
    }
}
