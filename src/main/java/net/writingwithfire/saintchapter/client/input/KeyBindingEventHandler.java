package net.writingwithfire.saintchapter.client.input;

import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.IEventBus;

public class KeyBindingEventHandler {

    public static void attachKeyInputHandler(IEventBus eventBus) {
        eventBus.addListener(KeyBindingEngrave::onKeyInput);
        eventBus.addListener(KeyBindingRelease::onKeyInput);
    }
}
