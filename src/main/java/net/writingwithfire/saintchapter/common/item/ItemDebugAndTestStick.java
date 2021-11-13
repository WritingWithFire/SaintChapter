package net.writingwithfire.saintchapter.common.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.network.PacketDistributor;
import net.writingwithfire.saintchapter.common.CommonProxy;
import net.writingwithfire.saintchapter.common.capability.IMindCapability;
import net.writingwithfire.saintchapter.common.data.WSD.WorldDataFlowerOfWorld;
import net.writingwithfire.saintchapter.common.network.SCPacketHandler;
import net.writingwithfire.saintchapter.common.network.msg.MSGMindCapabilitySync;
import net.writingwithfire.saintchapter.common.lib.LibCapabilities;
import net.writingwithfire.saintchapter.common.lib.LibTab;

public class ItemDebugAndTestStick extends Item{
    public ItemDebugAndTestStick() {
        super(new Properties().group(LibTab.ITEM_GROUP_SC));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (!worldIn.isRemote() && handIn == Hand.MAIN_HAND) {
//            // 意志能力测试
//            LazyOptional<IMindCapability> mindCap = playerIn.getCapability(LibCapabilities.MIND_CAPABILITY);
//            mindCap.ifPresent((cap) -> {
//                int mindStrength = cap.getMindStrength();
//                cap.setMindStrength(mindStrength + 1);
//                SCPacketHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) playerIn), new MSGMindCapabilitySync(mindStrength + 1));
//                playerIn.sendMessage(new StringTextComponent("Server Mind Strength: " + (mindStrength + 1)), CommonProxy.IN_GAME_UUID);
//            });

//            // 灵魂能力测试
//            LazyOptional<ISoulCapability> soulCap = playerIn.getCapability(LibCapabilities.SOUL_CAPABILITY);
//            soulCap.ifPresent((cap) -> {
//                if (!cap.getInitialized()) {
//                    cap.setInitialized(true);
//                    cap.setSoulStrength(((int) playerIn.getMaxHealth()));
//                }
//                int soulStrength = cap.getSoulStrength();
//                playerIn.sendMessage(new StringTextComponent(String.valueOf(soulStrength)), CommonProxy.IN_GAME_UUID);
//                cap.setSoulStrength(soulStrength + 1);
//                SCPacketHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> ServerPlayerEntity) playerIn), new MSGSoulCapabilitySync(soulStrength + 1, true));
//            });

            // 世界之花数据保存测试
            WorldDataFlowerOfWorld flowerOfWorld = WorldDataFlowerOfWorld.get(worldIn);
            playerIn.sendMessage(new StringTextComponent("flower: " + flowerOfWorld.getFlower()), CommonProxy.IN_GAME_UUID);
            flowerOfWorld.setFlower(flowerOfWorld.getFlower() + 1);
            playerIn.sendMessage(new StringTextComponent("new flower" + flowerOfWorld.getFlower()), CommonProxy.IN_GAME_UUID);
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
