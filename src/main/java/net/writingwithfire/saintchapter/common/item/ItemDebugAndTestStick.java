package net.writingwithfire.saintchapter.common.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;
import net.writingwithfire.saintchapter.common.CommonProxy;
import net.writingwithfire.saintchapter.common.capability.IMindCapability;
import net.writingwithfire.saintchapter.common.capability.ISoulCapability;
import net.writingwithfire.saintchapter.common.lib.LibCapabilities;
import net.writingwithfire.saintchapter.common.lib.LibTab;

public class ItemDebugAndTestStick extends Item{
    public ItemDebugAndTestStick() {
        super(new Properties().group(LibTab.ITEM_GROUP_SC));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (worldIn.isRemote && handIn == Hand.MAIN_HAND) {
            LazyOptional<IMindCapability> mindCap = playerIn.getCapability(LibCapabilities.MIND_CAPABILITY);
            LazyOptional<ISoulCapability> soulCap = playerIn.getCapability(LibCapabilities.SOUL_CAPABILITY);
            mindCap.ifPresent((cap) -> {
                int mindStrength = cap.getMindStrength();
                playerIn.sendMessage(new StringTextComponent("Mind Strength: " + mindStrength), CommonProxy.IN_GAME_UUID);
            });
            soulCap.ifPresent((cap) -> {
                boolean isInitialized = cap.getInitialized();
                int soulStrength = cap.getSoulStrength();
                if (!isInitialized) {
                    cap.setSoulStrength(playerIn.getMaxHealth());
                    cap.setInitialized(true);
                    playerIn.sendMessage(new StringTextComponent("Soul Strength: " + playerIn.getMaxHealth()), CommonProxy.IN_GAME_UUID);
                }else {
                    playerIn.sendMessage(new StringTextComponent("Soul Strength: " + soulStrength), CommonProxy.IN_GAME_UUID);
                }
            });
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
