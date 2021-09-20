package net.writingwithfire.saintchapter.common.capability;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.writingwithfire.saintchapter.SaintChapter;

public class CapabilityAttachHandler {
    public CapabilityAttachHandler() {}

    public static void capabilityAttachHandler(AttachCapabilitiesEvent<Entity> event) {
        Entity playerEntity = event.getObject();
        if (playerEntity instanceof PlayerEntity) {
            event.addCapability(SaintChapter.key("mind_strength"), new MindCapabilityProvider());
        }
    }
}
