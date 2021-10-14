package net.writingwithfire.saintchapter.common.lib;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.writingwithfire.saintchapter.common.capability.IMindCapability;
import net.writingwithfire.saintchapter.common.capability.ISoulCapability;

public class LibCapabilities {

    private LibCapabilities() {}

    @CapabilityInject(IMindCapability.class)
    public static Capability<IMindCapability> MIND_CAPABILITY = null;

    @CapabilityInject(ISoulCapability.class)
    public static Capability<ISoulCapability> SOUL_CAPABILITY = null;

}
