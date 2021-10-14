package net.writingwithfire.saintchapter.common.event.handler;

import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.writingwithfire.saintchapter.common.capability.IMindCapability;
import net.writingwithfire.saintchapter.common.capability.ISoulCapability;
import net.writingwithfire.saintchapter.common.lib.LibCapabilities;

public class EventHandlerMisc {
    public static void attachListeners(IEventBus eventBus) {
        eventBus.addListener(EventHandlerMisc::onPlayerCloned);
    }

    // 防止玩家死亡后能力失去
    private static void onPlayerCloned(PlayerEvent.Clone event) {
        LazyOptional<IMindCapability> oldMindCap = event.getOriginal().getCapability(LibCapabilities.MIND_CAPABILITY);
        LazyOptional<IMindCapability> newMindCap = event.getOriginal().getCapability(LibCapabilities.MIND_CAPABILITY);
        if (oldMindCap.isPresent() && newMindCap.isPresent()) {
            newMindCap.ifPresent((newCap) -> {
                oldMindCap.ifPresent((oldCap) -> {
                    newCap.deserializeNBT(oldCap.serializeNBT());
                });
            });
        }

        LazyOptional<ISoulCapability> oldSoulCap = event.getOriginal().getCapability(LibCapabilities.SOUL_CAPABILITY);
        LazyOptional<ISoulCapability> newSoulCap = event.getOriginal().getCapability(LibCapabilities.SOUL_CAPABILITY);
        if (oldSoulCap.isPresent() && newSoulCap.isPresent()) {
            newSoulCap.ifPresent((newCap) -> {
                oldSoulCap.ifPresent((oldCap) -> {
                    newCap.deserializeNBT(oldCap.serializeNBT());
                });
            });
        }
    }
}
