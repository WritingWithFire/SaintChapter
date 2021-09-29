package net.writingwithfire.saintchapter.common.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.writingwithfire.saintchapter.common.lib.LibTab;
import net.writingwithfire.saintchapter.common.lib.LibTranslationText;
import net.writingwithfire.saintchapter.common.util.NameUtil;

import javax.annotation.Nullable;
import java.util.List;

public class ItemRevelationScroll extends Item {
    public ItemRevelationScroll() {
        super(new Properties().group(LibTab.ITEM_GROUP_SC));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent(LibTranslationText.TOOL_TIP + NameUtil.getDefaultName(this)).mergeStyle(Style.EMPTY.setColor(Color.fromTextFormatting(TextFormatting.GOLD))));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
