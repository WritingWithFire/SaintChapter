package net.writingwithfire.saintchapter.common.registry.deferred.gameobjects;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.SaintChapter;
import net.writingwithfire.saintchapter.common.block.*;
import net.writingwithfire.saintchapter.common.lib.LibName;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public class RegistryBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SaintChapter.MODID);
    public static final Set<RegistryObject<Block>> BLOCK_SET = new HashSet<>();

    public static final RegistryObject<Block> IMPREGNATED_STONE = registerAndPut(LibName.BlockName.IMPREGNATED_STONE, BlockImpregnatedStone::new);
    public static final RegistryObject<Block> MIND_STONE = registerAndPut(LibName.BlockName.MIND_STONE, BlockMindStone::new);
    public static final RegistryObject<Block> DREAM_FIRE = registerAndPut(LibName.BlockName.DREAM_FIRE, BlockDreamFire::new);
    public static final RegistryObject<Block> DEBUG_AND_TEST = registerAndPut(LibName.BlockName.DEBUG_AND_TEST, BlockDebugAndTest::new);
    public static final RegistryObject<Block> WRITING_DESK = registerAndPut(LibName.BlockName.WRITING_DESK, BlockWritingDesk::new);
    public static final RegistryObject<Block> MIND_TANK = registerAndPut(LibName.BlockName.MIND_TANK, BlockMindTank::new);

    private static RegistryObject<Block> registerAndPut(String name, Supplier<Block> supplier) {
        RegistryObject<Block> registryObject = BLOCKS.register(name, supplier);
        BLOCK_SET.add(registryObject);
        return registryObject;
    }
}
