package net.writingwithfire.saintchapter.common.registry.deferred.gameobjects;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.SaintChapter;
import net.writingwithfire.saintchapter.common.item.ItemDebugAndTestStick;
import net.writingwithfire.saintchapter.common.item.ItemRevelationScroll;
import net.writingwithfire.saintchapter.common.lib.TabLib;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public class RegistryItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SaintChapter.MODID);
    public static final Set<RegistryObject<Item>> ITEM_SET = new HashSet<>();
    public static final Set<RegistryObject<BlockItem>> BLOCK_ITEM_SET = new HashSet<>();

    // 注册普通物品
    public static final RegistryObject<Item> REVELATION_SCROLL = registerAndPut("revelation_scroll", ItemRevelationScroll::new);
    public static final RegistryObject<Item> MIND_CRYSTAL = registerAndPut("mind_crystal", ItemDebugAndTestStick::new);
    public static final RegistryObject<Item> DEBUG_AND_TEST_STICK = registerAndPut("debug_and_test_stick", ItemDebugAndTestStick::new);

    // 注册方块物品
    public static final RegistryObject<BlockItem> IMPREGNATED_STONE = registryAndPut("impregnated_stone", () -> new BlockItem(RegistryBlocks.IMPREGNATED_STONE.get(), new Item.Properties().group(TabLib.ITEM_GROUP_SC)));
    public static final RegistryObject<BlockItem> MIND_STONE = registryAndPut("mind_stone", () -> new BlockItem(RegistryBlocks.MIND_STONE.get(), new Item.Properties().group(TabLib.ITEM_GROUP_SC)));
    public static final RegistryObject<BlockItem> DEBUG_AND_TEST = registryAndPut("debug_and_test", () -> new BlockItem(RegistryBlocks.DEBUG_AND_TEST.get(), new Item.Properties().group(TabLib.ITEM_GROUP_SC)));
    public static final RegistryObject<BlockItem> DREAM_FIRE = registryAndPut("dream_fire", () -> new BlockItem(RegistryBlocks.DREAM_FIRE.get(), new Item.Properties().group(TabLib.ITEM_GROUP_SC)));

    private static RegistryObject<Item> registerAndPut(String name, Supplier<Item> supplier) {
        RegistryObject<Item> registryObject = ITEMS.register(name, supplier);
        ITEM_SET.add(registryObject);
        return registryObject;
    }

    private static RegistryObject<BlockItem> registryAndPut(String name, Supplier<BlockItem> supplier) {
        RegistryObject<BlockItem> registryObject = ITEMS.register(name, supplier);
        BLOCK_ITEM_SET.add(registryObject);
        return registryObject;
    }
}
