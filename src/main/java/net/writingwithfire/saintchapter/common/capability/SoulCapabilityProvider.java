package net.writingwithfire.saintchapter.common.capability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.writingwithfire.saintchapter.common.lib.LibCapabilities;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class SoulCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundNBT> {
    private ISoulCapability soulCapability;

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == LibCapabilities.SOUL_CAPABILITY ? LazyOptional.of(this::getOrCreateCapability).cast() : LazyOptional.empty();
    }

    @Nonnull
    private ISoulCapability getOrCreateCapability() {
        if (soulCapability == null) {
            this.soulCapability = new SoulCapability(888, false);
        }
        return this.soulCapability;
    }

    @Override
    public CompoundNBT serializeNBT() {
        return getOrCreateCapability().serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        getOrCreateCapability().deserializeNBT(nbt);
    }
}
