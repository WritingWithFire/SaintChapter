package net.writingwithfire.saintchapter.common.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.writingwithfire.saintchapter.common.lib.NameLib;
import net.writingwithfire.saintchapter.common.lib.TabLib;
import net.writingwithfire.saintchapter.common.lib.TranslationTextLib;
import net.writingwithfire.saintchapter.common.util.NameUtil;

import javax.annotation.Nullable;
import java.util.List;

public class ItemMindCrystal extends Item{
    public ItemMindCrystal() {
        super(new Properties().group(TabLib.ITEM_GROUP_SC));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent(TranslationTextLib.TOOL_TIP + NameUtil.getDefaultName(this)).mergeStyle(Style.EMPTY.setColor(Color.fromTextFormatting(TextFormatting.GOLD))));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
