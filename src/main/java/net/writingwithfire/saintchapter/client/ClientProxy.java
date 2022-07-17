package net.writingwithfire.saintchapter.client;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.writingwithfire.saintchapter.common.CommonProxy;

public class ClientProxy extends CommonProxy {

    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    protected void initializeConfigurations() {
        super.initializeConfigurations();
    }

    @Override
    public void attachLifecycle(IEventBus modEventBus) {
        super.attachLifecycle(modEventBus);

        modEventBus.addListener(this::onClientSetup);
    }

    @Override
    public void attachEventHandlers(IEventBus eventBus) {
        super.attachEventHandlers(eventBus);
    }

    private void onClientSetup(FMLClientSetupEvent event) {
    }
}
