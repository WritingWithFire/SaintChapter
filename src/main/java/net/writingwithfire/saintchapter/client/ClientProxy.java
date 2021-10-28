package net.writingwithfire.saintchapter.client;

import hellfirepvp.observerlib.common.util.tick.ITickHandler;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.writingwithfire.saintchapter.client.event.OverlayRenderer;
import net.writingwithfire.saintchapter.client.input.KeyBindingEventHandler;
import net.writingwithfire.saintchapter.client.registry.RegistryBlockRenderTypes;
import net.writingwithfire.saintchapter.client.registry.RegistryKeyBindings;
import net.writingwithfire.saintchapter.common.CommonProxy;

import java.util.function.Consumer;

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

        // 渲染
        OverlayRenderer.INSTANCE.attachEventListeners(eventBus);

        KeyBindingEventHandler.attachKeyInputHandler(eventBus);
    }

    @Override
    public void attachTickListeners(Consumer<ITickHandler> registrar) {
        super.attachTickListeners(registrar);
    }

    private void onClientSetup(FMLClientSetupEvent event) {
        RegistryKeyBindings.init();

        RegistryBlockRenderTypes.registerRenderTypes();
    }
}
