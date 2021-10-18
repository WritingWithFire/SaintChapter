package net.writingwithfire.saintchapter.client.event;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.MainWindow;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.writingwithfire.saintchapter.client.render.gui.MindStrengthGui;
import net.writingwithfire.saintchapter.common.capability.IMindCapability;
import net.writingwithfire.saintchapter.common.lib.LibCapabilities;

public class OverlayRenderer {
    public static final OverlayRenderer INSTANCE = new OverlayRenderer();

    private OverlayRenderer() {}

    public void attachEventListeners(IEventBus eventBus) {
        eventBus.addListener(this::mindStrengthRender);
    }

    private void mindStrengthRender(RenderGameOverlayEvent.Post event) {
        if (event.getType() != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }
        if (Minecraft.getInstance().player == null || !Minecraft.getInstance().player.getCapability(LibCapabilities.MIND_CAPABILITY).isPresent()) {
            return;
        }
        PlayerEntity playerEntity = Minecraft.getInstance().player;
        MatrixStack matrixStack = event.getMatrixStack();
        MainWindow window = event.getWindow();
        MindStrengthGui.INSTANCE.render(matrixStack, window, playerEntity);
    }
}
