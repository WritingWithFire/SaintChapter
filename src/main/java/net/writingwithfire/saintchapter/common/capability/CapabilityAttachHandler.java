package net.writingwithfire.saintchapter.common.capability;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.writingwithfire.saintchapter.SaintChapter;
import net.writingwithfire.saintchapter.common.lib.LibCapabilities;

public class CapabilityAttachHandler {
    public CapabilityAttachHandler() {}

    public static void capabilityAttachHandler(AttachCapabilitiesEvent<Entity> event) {
        Entity entity = event.getObject();
        if (entity instanceof PlayerEntity){
            event.addCapability(SaintChapter.key("mind_strength"), new MindCapabilityProvider());
            event.addCapability(SaintChapter.key("soul_strength"), new SoulCapabilityProvider());
        }
        if (entity instanceof MobEntity) {
            event.addCapability(SaintChapter.key("soul_strength"), new SoulCapabilityProvider());
        }
    }
}
