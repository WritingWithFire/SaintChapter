package net.writingwithfire.saintchapter.common;

import net.minecraftforge.eventbus.api.IEventBus;
import net.writingwithfire.saintchapter.common.registry.internal.InternalRegistryPrimer;
import net.writingwithfire.saintchapter.common.registry.internal.PrimerEventHandler;

public class CommonProxy {

    private InternalRegistryPrimer registryPrimer;
    private PrimerEventHandler registryEventHandler;

    public void initialize() {
        this.registryPrimer = new InternalRegistryPrimer();
        this.registryEventHandler = new PrimerEventHandler(this.registryPrimer);
    }

    public void attachLifecycle(IEventBus modEventBus) {
        registryEventHandler.attachEventHandlers(modEventBus);
    }

    public void attachEventHandlers(IEventBus eventBus) {

    }

    public InternalRegistryPrimer getRegistryPrimer() {
        return registryPrimer;
    }
}
