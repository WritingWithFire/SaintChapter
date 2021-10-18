package net.writingwithfire.saintchapter.client.registry;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.writingwithfire.saintchapter.SaintChapter;
import org.lwjgl.glfw.GLFW;

import static net.writingwithfire.saintchapter.client.lib.LibKeyBindings.*;

public class RegistryKeyBindings {

    public static void init() {
        ENGRAVE = register("engrave", GLFW.GLFW_KEY_V);
        RELEASE = register("release", GLFW.GLFW_KEY_C);
    }

    private static KeyBinding register(String name, int glfwKey) {
        KeyBinding keyBinding = new KeyBinding(String.format("key.%s.%s", SaintChapter.MODID, name), KeyConflictContext.IN_GAME, InputMappings.Type.KEYSYM, glfwKey, SaintChapter.NAME);
        ClientRegistry.registerKeyBinding(keyBinding);
        return keyBinding;
    }
}
