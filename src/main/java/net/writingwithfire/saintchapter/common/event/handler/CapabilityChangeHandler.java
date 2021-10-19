package net.writingwithfire.saintchapter.common.event.handler;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.network.PacketDistributor;
import net.writingwithfire.saintchapter.common.CommonProxy;
import net.writingwithfire.saintchapter.common.capability.IMindCapability;
import net.writingwithfire.saintchapter.common.capability.ISoulCapability;
import net.writingwithfire.saintchapter.common.network.SCPacketHandler;
import net.writingwithfire.saintchapter.common.network.msg.MSGMindCapabilitySync;
import net.writingwithfire.saintchapter.common.network.msg.MSGSoulCapabilitySync;
import net.writingwithfire.saintchapter.common.lib.LibCapabilities;

public class CapabilityChangeHandler {

    public static void onPlayerCloned(PlayerEvent.Clone event) {
        // 死亡或者转换维度时的能力处理
        if (!event.getOriginal().world.isRemote() && !event.getPlayer().world.isRemote() && event.getOriginal() != null && event.getPlayer() != null) {
            LazyOptional<IMindCapability> oldMindCap = event.getOriginal().getCapability(LibCapabilities.MIND_CAPABILITY);
            LazyOptional<IMindCapability> newMindCap = event.getPlayer().getCapability(LibCapabilities.MIND_CAPABILITY);
            LazyOptional<ISoulCapability> oldSoulCap = event.getOriginal().getCapability(LibCapabilities.SOUL_CAPABILITY);
            LazyOptional<ISoulCapability> newSoulCap = event.getPlayer().getCapability(LibCapabilities.SOUL_CAPABILITY);
            if (oldMindCap.isPresent() && newMindCap.isPresent()) {
                newMindCap.ifPresent(capability -> {
                    oldMindCap.ifPresent(capabilityOld -> {
                        event.getPlayer().sendMessage(new StringTextComponent("Before: " + capability.getMindStrength()), CommonProxy.IN_GAME_UUID);
                        capability.deserializeNBT(capabilityOld.serializeNBT());
                        event.getPlayer().sendMessage(new StringTextComponent("After: " + capability.getMindStrength()), CommonProxy.IN_GAME_UUID);
                    });
//                    SCPacketHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()), new MSGMindCapabilitySync(capability.getMindStrength()));
                    // 为什么要从客户端发送到服务端？
//                    SCPacketHandler.INSTANCE.sendToServer(new MSGMindCapabilitySync(capability.getMindStrength()));
                });
            }
            if (oldSoulCap.isPresent() && newSoulCap.isPresent()) {
                newSoulCap.ifPresent(capability -> {
                    oldSoulCap.ifPresent(capabilityOld -> {
                        capability.deserializeNBT(capabilityOld.serializeNBT());
                    });
//                    SCPacketHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> {return (ServerPlayerEntity) event.getPlayer();}), new MSGSoulCapabilitySync(capability.getSoulStrength(), capability.getInitialized()));
//                    SCPacketHandler.INSTANCE.sendToServer(new MSGSoulCapabilitySync(capability.getSoulStrength(), capability.getInitialized()));
                });
            }
        }
    }

    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        ServerPlayerEntity serverPlayer = (ServerPlayerEntity) event.getPlayer();
        // 进入游戏或重进地图同步能力
        serverPlayer.getCapability(LibCapabilities.MIND_CAPABILITY).ifPresent(capability -> {
            SCPacketHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> {
                return serverPlayer;
            }), new MSGMindCapabilitySync(capability.getMindStrength()));
        });
        serverPlayer.getCapability(LibCapabilities.SOUL_CAPABILITY).ifPresent(capability -> {
            SCPacketHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> {
                return serverPlayer;
            }), new MSGSoulCapabilitySync(capability.getSoulStrength(), capability.getInitialized()));
        });
    }

    public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        // 玩家重生后同步能力
        ServerPlayerEntity playerEntity = (ServerPlayerEntity) event.getPlayer();
        playerEntity.getCapability(LibCapabilities.MIND_CAPABILITY).ifPresent(capability -> {
            SCPacketHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> playerEntity), new MSGMindCapabilitySync(capability.getMindStrength()));
        });
        playerEntity.getCapability(LibCapabilities.SOUL_CAPABILITY).ifPresent(capability -> {
            SCPacketHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> playerEntity), new MSGSoulCapabilitySync(capability.getSoulStrength(), capability.getInitialized()));
        });
    }
}
