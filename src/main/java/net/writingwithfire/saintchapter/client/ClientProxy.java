package net.writingwithfire.saintchapter.client;

import hellfirepvp.observerlib.common.util.tick.ITickHandler;
import net.minecraftforge.eventbus.api.IEventBus;
import net.writingwithfire.saintchapter.common.CommonProxy;

import java.util.function.Consumer;

public class ClientProxy extends CommonProxy {

    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    protected void initializeConfigurations() {

    }

    @Override
    public void attachLifecycle(IEventBus modEventBus) {

    }

    @Override
    public void attachEventHandlers(IEventBus eventBus) {

    }

    @Override
    public void attachTickListeners(Consumer<ITickHandler> registrar) {

    }
}
