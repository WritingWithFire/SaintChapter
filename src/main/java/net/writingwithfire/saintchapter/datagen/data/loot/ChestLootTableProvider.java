package net.writingwithfire.saintchapter.datagen.data.loot;

import net.minecraft.data.loot.ChestLootTables;
import net.minecraft.loot.LootTable;
import net.minecraft.util.ResourceLocation;

import java.util.function.BiConsumer;

public class ChestLootTableProvider extends ChestLootTables {
    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> registrar) {

    }
}
