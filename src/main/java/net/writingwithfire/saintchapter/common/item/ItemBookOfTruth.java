package net.writingwithfire.saintchapter.common.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.common.lib.LibTab;
import vazkii.patchouli.api.PatchouliAPI;

import javax.annotation.Nonnull;

public class ItemBookOfTruth extends Item{
    public ItemBookOfTruth() {
        super(new Item.Properties().group(LibTab.ITEM_GROUP_SC));
    }

    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);

        if (playerIn instanceof ServerPlayerEntity) {
            PatchouliAPI.get().openBookGUI((ServerPlayerEntity) playerIn, ForgeRegistries.ITEMS.getKey(this));
        }

        return new ActionResult<>(ActionResultType.SUCCESS, stack);
    }
}
