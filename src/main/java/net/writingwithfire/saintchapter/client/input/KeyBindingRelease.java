package net.writingwithfire.saintchapter.client.input;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.client.event.InputEvent;
import net.writingwithfire.saintchapter.client.ClientProxy;
import net.writingwithfire.saintchapter.client.lib.LibKeyBindings;
import net.writingwithfire.saintchapter.common.data.sync.SCPacketHandler;
import net.writingwithfire.saintchapter.common.data.sync.msg.MSGMindCapabilitySync;
import net.writingwithfire.saintchapter.common.lib.LibCapabilities;

public class KeyBindingRelease {
    public static void onKeyInput(InputEvent.KeyInputEvent event) {
        PlayerEntity playerEntity = Minecraft.getInstance().player;
        if (playerEntity != null && LibKeyBindings.RELEASE.isPressed()){
            playerEntity.getCapability(LibCapabilities.MIND_CAPABILITY).ifPresent((capability -> {
                int mindStrength = capability.getMindStrength();
                playerEntity.sendMessage(new StringTextComponent("Client mind strength: " + mindStrength), ClientProxy.IN_GAME_UUID);
                capability.setMindStrength(mindStrength - 1);
                SCPacketHandler.INSTANCE.sendToServer(new MSGMindCapabilitySync(mindStrength - 1));
            }));
        }
    }
}
