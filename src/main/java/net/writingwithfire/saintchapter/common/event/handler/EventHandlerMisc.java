package net.writingwithfire.saintchapter.common.event.handler;

import net.minecraftforge.eventbus.api.IEventBus;

public class EventHandlerMisc {
    public static void attachListeners(IEventBus eventBus) {
        eventBus.addListener(CapabilityChangeHandler::onPlayerCloned);
        eventBus.addListener(CapabilityChangeHandler::onPlayerLoggedIn);
        eventBus.addListener(CapabilityChangeHandler::onPlayerRespawn);
    }

}
