package net.writingwithfire.saintchapter.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockImpregnatedStone extends Block {
    public BlockImpregnatedStone() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(5));
    }
}
