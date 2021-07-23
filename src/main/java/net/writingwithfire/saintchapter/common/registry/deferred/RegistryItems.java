package net.writingwithfire.saintchapter.common.registry.deferred;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.common.item.ItemMindCrystal;
import net.writingwithfire.saintchapter.common.item.ItemRevelationScroll;
import net.writingwithfire.saintchapter.common.lib.TabLib;

public class RegistryItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "saintchapter");

    // 注册普通物品
    public static final RegistryObject<Item> REVELATION_SCROLL = ITEMS.register("revelation_scroll", ItemRevelationScroll::new);
    public static final RegistryObject<Item> MIND_CRYSTAL = ITEMS.register("mind_crystal", ItemMindCrystal::new);

    // 注册方块物品
    public static final RegistryObject<Item> IMPREGNATED_STONE = ITEMS.register("impregnated_stone", () -> new BlockItem(RegistryBlocks.IMPREGNATED_STONE.get(), new Item.Properties().group(TabLib.ITEM_GROUP_SC)));
    public static final RegistryObject<Item> MIND_STONE = ITEMS.register("mind_stone", () -> new BlockItem(RegistryBlocks.MIND_STONE.get(), new Item.Properties().group(TabLib.ITEM_GROUP_SC)));
}
