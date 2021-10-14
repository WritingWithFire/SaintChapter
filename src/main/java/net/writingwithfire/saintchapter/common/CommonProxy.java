package net.writingwithfire.saintchapter.common;

import hellfirepvp.observerlib.common.util.tick.ITickHandler;
import net.minecraft.entity.Entity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.writingwithfire.saintchapter.common.capability.CapabilityAttachHandler;
import net.writingwithfire.saintchapter.common.capability.CapabilityRegisterHandler;
import net.writingwithfire.saintchapter.common.data.config.CommonConfig;
import net.writingwithfire.saintchapter.common.data.config.ServerConfig;
import net.writingwithfire.saintchapter.common.data.config.entry.WorldGenConfig;
import net.writingwithfire.saintchapter.common.registry.internal.InternalRegistryPrimer;
import net.writingwithfire.saintchapter.common.registry.internal.PrimerEventHandler;
import net.writingwithfire.saintchapter.common.registry.internal.RegistryRegistries;
import net.writingwithfire.saintchapter.common.world.WorldGenHandlers;

import java.util.UUID;
import java.util.function.Consumer;

public class CommonProxy {
    public static final UUID IN_GAME_UUID = UUID.randomUUID();

    private InternalRegistryPrimer registryPrimer;
    private PrimerEventHandler registryEventHandler;

    private CommonConfig commonConfig;
    private ServerConfig serverConfig;

    public void initialize() {
        this.registryPrimer = new InternalRegistryPrimer();
        this.registryEventHandler = new PrimerEventHandler(this.registryPrimer);

        this.commonConfig = new CommonConfig();
        this.serverConfig = new ServerConfig();

        this.initializeConfigurations();

        this.commonConfig.buildConfiguration();
        this.serverConfig.buildConfiguration();
    }

    public void attachLifecycle(IEventBus modEventBus) {
        modEventBus.addListener(this::onCommonSetup);

        modEventBus.addListener(RegistryRegistries::buildRegistries);

        registryEventHandler.attachEventHandlers(modEventBus);
    }

    public void attachEventHandlers(IEventBus eventBus) {
        eventBus.addListener(WorldGenHandlers::generateOres);
        eventBus.addGenericListener(Entity.class, CapabilityAttachHandler::capabilityAttachHandler);
    }

    public InternalRegistryPrimer getRegistryPrimer() {
        return registryPrimer;
    }

    protected void initializeConfigurations() {
        this.commonConfig.addConfigEntry(WorldGenConfig.CONFIG);
    }

    public void attachTickListeners(Consumer<ITickHandler> registrar) {

    }

    // Mod Event
    private void onCommonSetup(FMLCommonSetupEvent event) {
        CapabilityRegisterHandler.capabilityRegisterHandler(event);
    }
}
