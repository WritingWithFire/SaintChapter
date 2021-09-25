package net.writingwithfire.saintchapter.datagen.data.loot;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.loot.*;
import net.minecraft.util.ResourceLocation;
import net.writingwithfire.saintchapter.datagen.data.loot.tables.*;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SCLootTableProvider extends LootTableProvider {
    public SCLootTableProvider(DataGenerator generator) {
        super(generator);
    }

    @Nonnull
    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        return Lists.newArrayList(
                Pair.of(BlockLootTableProvider::new, LootParameterSets.BLOCK),
                Pair.of(EntityLootTableProvider::new, LootParameterSets.ENTITY),
                Pair.of(ChestLootTableProvider::new, LootParameterSets.CHEST),
                Pair.of(GameplayLootTableProvider::new, LootParameterSets.GIFT),
                Pair.of(FishingLootTableProvider::new, LootParameterSets.FISHING)
        );
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> tables, @Nonnull ValidationTracker tracker) {
        tables.forEach((key, table) -> LootTableManager.validateLootTable(tracker, key, table));
    }
}
