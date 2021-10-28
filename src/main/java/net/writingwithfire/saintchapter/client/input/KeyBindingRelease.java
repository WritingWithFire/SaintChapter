package net.writingwithfire.saintchapter.client.input;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.client.event.InputEvent;
import net.writingwithfire.saintchapter.client.ClientProxy;
import net.writingwithfire.saintchapter.client.lib.LibKeyBindings;
import net.writingwithfire.saintchapter.common.network.SCPacketHandler;
import net.writingwithfire.saintchapter.common.network.msg.MSGMindCapabilitySync;
import net.writingwithfire.saintchapter.common.lib.LibCapabilities;

public class KeyBindingRelease {
    public static void onKeyInput(InputEvent.KeyInputEvent event) {
        PlayerEntity playerEntity = Minecraft.getInstance().player;
        if (playerEntity != null && LibKeyBindings.RELEASE.isPressed()){
            playerEntity.getCapability(LibCapabilities.MIND_CAPABILITY).ifPresent((capability -> {
                int mindStrength = capability.getMindStrength();
                capability.setMindStrength(mindStrength - 1);
                SCPacketHandler.INSTANCE.sendToServer(new MSGMindCapabilitySync(mindStrength - 1));
                playerEntity.sendMessage(new StringTextComponent("Client mind strength: " + (mindStrength - 1)), ClientProxy.IN_GAME_UUID);
            }));
        }
    }
}
