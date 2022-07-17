package net.writingwithfire.saintchapter.common;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import software.bernie.geckolib3.GeckoLib;

public class CommonProxy {
    public void initialize() {
        GeckoLib.initialize();

        this.initializeConfigurations();
    }

    public void attachLifecycle(IEventBus modEventBus) {
        modEventBus.addListener(this::onCommonSetup);
    }

    public void attachEventHandlers(IEventBus eventBus) {
    }

    protected void initializeConfigurations() {
    }

    // Mod Event
    private void onCommonSetup(FMLCommonSetupEvent event) {
    }
}
