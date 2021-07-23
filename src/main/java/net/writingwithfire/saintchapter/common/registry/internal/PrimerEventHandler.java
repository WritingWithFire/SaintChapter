package net.writingwithfire.saintchapter.common.registry.internal;

import net.minecraftforge.eventbus.api.IEventBus;
import net.writingwithfire.saintchapter.common.registry.deferred.RegistryBlocks;
import net.writingwithfire.saintchapter.common.registry.deferred.RegistryItems;
import net.writingwithfire.saintchapter.common.registry.deferred.RegistrySounds;
import net.writingwithfire.saintchapter.common.registry.deferred.RegistryTileEntities;

public class PrimerEventHandler {
    private final InternalRegistryPrimer registry;

    public PrimerEventHandler(InternalRegistryPrimer registry) {
        this.registry = registry;
    }

    public void attachEventHandlers(IEventBus eventBus) {
        // DeferredRegister注册
        RegistryItems.ITEMS.register(eventBus);
        RegistryBlocks.BLOCKS.register(eventBus);
        RegistrySounds.SOUNDS.register(eventBus);
        RegistryTileEntities.TILE_ENTITIRE.register(eventBus);

        // 其他方式注册
    }
}
