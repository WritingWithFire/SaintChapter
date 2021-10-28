package net.writingwithfire.saintchapter.datagen.data.loot.tables;

import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.writingwithfire.saintchapter.SaintChapter;
import net.writingwithfire.saintchapter.common.registry.deferred.gameobjects.RegistryBlocks;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.stream.Collectors;

public class BlockLootTableProvider extends BlockLootTables {

    @Override
    protected void addTables() {
        this.registerDropSelfLootTable(RegistryBlocks.IMPREGNATED_STONE.get());
        this.registerDropSelfLootTable(RegistryBlocks.MIND_STONE.get());
        this.registerDropSelfLootTable(RegistryBlocks.DREAM_FIRE.get());
        this.registerDropSelfLootTable(RegistryBlocks.DEBUG_AND_TEST.get());
        this.registerDropSelfLootTable(RegistryBlocks.WRITING_DESK.get());
    }

    @Nonnull
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getValues().stream()
                .filter((IForgeRegistryEntry<?> entry) -> {
                    return Objects.requireNonNull(entry.getRegistryName()).getNamespace().equals(SaintChapter.MODID);
                })
                .collect(Collectors.toList());
    }
}
