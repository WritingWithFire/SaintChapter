package net.writingwithfire.saintchapter.common.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
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
        if (!worldIn.isRemote && handIn == Hand.MAIN_HAND) {
            LazyOptional<IMindCapability> mindCap = playerIn.getCapability(LibCapabilities.MIND_CAPABILITY);
            mindCap.ifPresent((cap) -> {
                int mindStrength = cap.getMindStrength();
                playerIn.sendMessage(new StringTextComponent("Mind Strength: " + mindStrength), CommonProxy.IN_GAME_UUID);
            });
            LazyOptional<ISoulCapability> soulCap = playerIn.getCapability(LibCapabilities.SOUL_CAPABILITY);
            soulCap.ifPresent((cap) -> {
                playerIn.sendMessage(new StringTextComponent(String.valueOf(cap.serializeNBT().getBoolean("initialized"))), CommonProxy.IN_GAME_UUID);
                if (!cap.getInitialized()) {
                    CompoundNBT nbt = new CompoundNBT();
                    nbt.putInt("soulStrength", (int) playerIn.getMaxHealth());
                    nbt.putBoolean("initialized", true);
                    cap.deserializeNBT(nbt);
                }
                playerIn.sendMessage(new StringTextComponent("Soul Strength: " + cap.serializeNBT().getInt("soulStrength") + ", " + cap.getInitialized()), CommonProxy.IN_GAME_UUID);
            });
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
