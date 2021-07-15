package net.writingwithfire.saintchapter.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockImpregnatedStone extends Block {
    public BlockImpregnatedStone() {
        super(Properties.of(Material.STONE).strength(5));
    }
}
