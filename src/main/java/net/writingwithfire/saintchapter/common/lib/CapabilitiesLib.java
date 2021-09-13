package net.writingwithfire.saintchapter.common.lib;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.writingwithfire.saintchapter.common.capability.IMindCapability;

public class CapabilitiesLib {

    private CapabilitiesLib() {}

    @CapabilityInject(IMindCapability.class)
    public static Capability<IMindCapability> MIND_CAPABILITY;

}
