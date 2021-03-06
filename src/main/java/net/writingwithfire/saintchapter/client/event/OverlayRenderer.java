package net.writingwithfire.saintchapter.client.event;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.MainWindow;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.writingwithfire.saintchapter.client.render.gui.MindStrengthGui;
import net.writingwithfire.saintchapter.common.lib.LibCapabilities;

public class OverlayRenderer {
    public static final OverlayRenderer INSTANCE = new OverlayRenderer();

    private OverlayRenderer() {}

    public void attachEventListeners(IEventBus eventBus) {
        eventBus.addListener(this::mindStrengthRender);
    }

    private void mindStrengthRender(RenderGameOverlayEvent.Pre event) {
        if (event.getType() != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }
        if (Minecraft.getInstance().player == null || !Minecraft.getInstance().player.getCapability(LibCapabilities.MIND_CAPABILITY).isPresent() || Minecraft.getInstance().player.isCreative() || Minecraft.getInstance().player.isSpectator()) {
            return;
        }
        MatrixStack matrixStack = event.getMatrixStack();
        MainWindow window = event.getWindow();
//        MindStrengthGui mindStrengthGui = new MindStrengthGui(matrixStack, window);
//        mindStrengthGui.render();
        MindStrengthGui.INSTANCE.render(matrixStack, window);
    }
}
