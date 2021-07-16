package net.writingwithfire.saintchapter.common.tab;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.writingwithfire.saintchapter.common.register.ItemRegistry;

public class TabBase extends ItemGroup {
    public TabBase() {
        super("base_tab");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ItemRegistry.REVELATION_SCROLL.get());
    }
}
