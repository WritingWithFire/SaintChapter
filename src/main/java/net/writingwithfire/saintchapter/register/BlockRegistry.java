package net.writingwithfire.saintchapter.register;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.block.BlockImpregnatedStone;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "saintchapter");

    public static final RegistryObject<BlockImpregnatedStone> IMPREGNATED_STONE = BLOCKS.register("impregnated_stone", BlockImpregnatedStone::new);
}
