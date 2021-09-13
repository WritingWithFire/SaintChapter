package net.writingwithfire.saintchapter.common.capability;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import javax.annotation.Nullable;

public class CapabilityRegisterHandler {
    public CapabilityRegisterHandler() {}

    public static void capabilityRegisterHandler(FMLCommonSetupEvent event) {
        event.enqueueWork(
                () -> {
                    CapabilityManager.INSTANCE.register(
                            IMindCapability.class,
                            new Capability.IStorage<IMindCapability>() {
                                @Nullable
                                @Override
                                public INBT writeNBT(Capability<IMindCapability> capability, IMindCapability instance, Direction side) {
                                    return null;
                                }

                                @Override
                                public void readNBT(Capability<IMindCapability> capability, IMindCapability instance, Direction side, INBT nbt) {

                                }
                            },
                            () -> null
                    );
                }
        );
    }
}
