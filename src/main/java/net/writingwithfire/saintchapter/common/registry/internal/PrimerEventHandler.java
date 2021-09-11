package net.writingwithfire.saintchapter.common.registry.internal;

import net.minecraftforge.eventbus.api.IEventBus;
import net.writingwithfire.saintchapter.common.registry.deferred.custom.RegistryChapters;
import net.writingwithfire.saintchapter.common.registry.deferred.custom.forge.RegistryDataSerializers;
import net.writingwithfire.saintchapter.common.registry.deferred.custom.forge.RegistryLootModifierSerializers;
import net.writingwithfire.saintchapter.common.registry.deferred.custom.forge.RegistryWorldTypes;
import net.writingwithfire.saintchapter.common.registry.deferred.gameobjects.*;
import net.writingwithfire.saintchapter.common.registry.deferred.villages.*;
import net.writingwithfire.saintchapter.common.registry.deferred.worldgen.*;

public class PrimerEventHandler {
    private final InternalRegistryPrimer registry;

    public PrimerEventHandler(InternalRegistryPrimer registry) {
        this.registry = registry;
    }

    public void attachEventHandlers(IEventBus eventBus) {
        // DeferredRegister注册,此处列出了Forge提供的所有注册入口，或许哪一天有用，同时充当Lib
        // game objects
        RegisterParticleTypes.PARTICLE_TYPES.register(eventBus);
        RegistryAttributes.ATTRIBUTES.register(eventBus);
        RegistryBlocks.BLOCKS.register(eventBus);
        RegistryContainers.CONTAINERS.register(eventBus);
        RegistryEnchantments.ENCHANTMENTS.register(eventBus);
        RegistryEntities.ENTITIES.register(eventBus);
        RegistryFluids.FLUIDS.register(eventBus);
        RegistryItems.ITEMS.register(eventBus);
        RegistryPaintingTypes.PAINTING_TYPES.register(eventBus);
        RegistryPotions.POTIONS.register(eventBus);
        RegistryPotionTypes.POTION_TYPES.register(eventBus);
        RegistryRecipeSerializers.RECIPE_SERIALIZERs.register(eventBus);
        RegistrySoundEvents.SOUND_EVENTS.register(eventBus);
        RegistryStatTypes.STAT_TYPES.register(eventBus);
        RegistryTileEntities.TILE_ENTITIES.register(eventBus);
        //villages
        RegistryActivities.ACTIVITIES.register(eventBus);
        RegistryMemoryModuleTypes.MEMORY_MODULE_TYPES.register(eventBus);
        RegistryPoiTypes.POI_TYPES.register(eventBus);
        RegistryProfessions.PROFESSIONS.register(eventBus);
        RegistrySchedules.SCHEDULES.register(eventBus);
        RegistrySensorTypes.SENSOR_TYPES.register(eventBus);
        //world gen
        RegistryBlockPlacerTypes.BLOCK_PLACER_TYPES.register(eventBus);
        RegistryBlockStateProviderTypes.BLOCK_STATE_PROVIDER_TYPES.register(eventBus);
        RegistryChunkStatus.CHUNK_STATUS.register(eventBus);
        RegistryDecorators.DECORATORS.register(eventBus);
        RegistryFeatures.FEATURES.register(eventBus);
        RegistryFoliagePlacerTypes.FOLIAGE_PLACER_TYPES.register(eventBus);
        RegistryStructureFeatures.STRUCTURE_FEATURES.register(eventBus);
        RegistrySurfaceBuilders.SURFACE_BUILDERS.register(eventBus);
        RegistryTreeDecoratorTypes.TREE_DECORATOR_TYPES.register(eventBus);
        RegistryWorldCarvers.WORLD_CARVERS.register(eventBus);
        // custom
        RegistryDataSerializers.DATA_SERIALIZERS.register(eventBus);
        RegistryLootModifierSerializers.LOOT_MODIFIER_SERIALIZERS.register(eventBus);
        RegistryWorldTypes.WORLD_TYPES.register(eventBus);

        RegistryChapters.CHAPTERS.register(eventBus);

        // 利用星辉魔法提供的注册方式注册
    }
}
