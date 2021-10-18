package net.writingwithfire.saintchapter.common.event.handler;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.network.PacketDistributor;
import net.writingwithfire.saintchapter.common.capability.IMindCapability;
import net.writingwithfire.saintchapter.common.capability.ISoulCapability;
import net.writingwithfire.saintchapter.common.data.sync.SCPacketHandler;
import net.writingwithfire.saintchapter.common.data.sync.msg.MSGMindCapabilitySync;
import net.writingwithfire.saintchapter.common.data.sync.msg.MSGSoulCapabilitySync;
import net.writingwithfire.saintchapter.common.lib.LibCapabilities;

public class EventHandlerMisc {
    public static void attachListeners(IEventBus eventBus) {
        eventBus.addListener(CapabilityChangeHandler::onPlayerCloned);
        eventBus.addListener(CapabilityChangeHandler::onPlayerLoggedIn);
    }

}
