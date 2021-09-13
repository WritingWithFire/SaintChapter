package net.writingwithfire.saintchapter.common.capability;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.writingwithfire.saintchapter.SaintChapter;
import net.writingwithfire.saintchapter.common.capability.provider.MindCapabilityProvider;

public class CapabilityAttachHandler {
    public CapabilityAttachHandler() {}

    public static void capabilityAttachHandler(AttachCapabilitiesEvent<Entity> event) {
        Entity playerEntity = event.getObject();
        if (playerEntity instanceof PlayerEntity) {
            event.addCapability(new ResourceLocation(SaintChapter.MODID, "mindStrength"), new MindCapabilityProvider());
        }
    }
}
