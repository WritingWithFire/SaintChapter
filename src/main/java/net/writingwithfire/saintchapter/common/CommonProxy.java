package net.writingwithfire.saintchapter.common;

import hellfirepvp.observerlib.common.util.tick.ITickHandler;
import net.minecraftforge.eventbus.api.IEventBus;
import net.writingwithfire.saintchapter.common.register.BlockRegistry;
import net.writingwithfire.saintchapter.common.register.ItemRegistry;
import net.writingwithfire.saintchapter.common.register.SoundEventRegistry;
import net.writingwithfire.saintchapter.common.register.TileEntityTypeRegistry;

import java.util.function.Consumer;

public class CommonProxy {

    public void initialize() {

    }

    public void attachLifecycle(IEventBus modEventBus) {
        ItemRegistry.ITEMS.register(modEventBus);
        BlockRegistry.BLOCKS.register(modEventBus);
        SoundEventRegistry.SOUNDS.register(modEventBus);
        TileEntityTypeRegistry.TILE_ENTITYS.register(modEventBus);
    }

    public void attachEventHandlers(IEventBus eventBus) {

    }

    public void attachTickListeners(Consumer<ITickHandler> registrar) {

    }

    protected void initializeConfigurations() {

    }
}
