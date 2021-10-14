package net.writingwithfire.saintchapter.common.capability;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.writingwithfire.saintchapter.SaintChapter;

public class CapabilityAttachHandler {
    public CapabilityAttachHandler() {}

    public static void capabilityAttachHandler(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof PlayerEntity){
            event.addCapability(SaintChapter.key("mind_strength"), new MindCapabilityProvider());
            SaintChapter.LOGGER.info("Mind Capability attached");
            event.addCapability(SaintChapter.key("soul_strength"), new SoulCapabilityProvider());
            SaintChapter.LOGGER.info("Player Soul Capability attached");
            SaintChapter.LOGGER.info("Player Capability attached");
        }
        if (event.getObject() instanceof MobEntity) {
            event.addCapability(SaintChapter.key("soul_strength"), new SoulCapabilityProvider());
            SaintChapter.LOGGER.info("Mob Soul Capability attached");
            SaintChapter.LOGGER.info("Mob Capability attached");
        }
    }
}
