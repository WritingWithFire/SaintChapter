package net.writingwithfire.saintchapter.common.registry.deferred.gameobjects;

import net.minecraft.block.Block;
import net.minecraft.block.FireBlock;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.common.block.BlockDreamFire;
import net.writingwithfire.saintchapter.common.block.BlockImpregnatedStone;
import net.writingwithfire.saintchapter.common.block.BlockMindStone;

public class RegistryBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "saintchapter");

    public static final RegistryObject<Block> IMPREGNATED_STONE = BLOCKS.register("impregnated_stone", BlockImpregnatedStone::new);
    public static final RegistryObject<Block> MIND_STONE = BLOCKS.register("mind_stone", BlockMindStone::new);
    public static final RegistryObject<Block> DREAM_FIRE = BLOCKS.register("dream_fire", BlockDreamFire::new);
}
