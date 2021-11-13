package net.writingwithfire.saintchapter.common.data.WSD;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.DimensionSavedDataManager;
import net.minecraft.world.storage.WorldSavedData;

public class WorldDataFlowerOfWorld extends WorldSavedData {
    private static final String NAME = "flower_of_world";
    private int flower = 0;

    public WorldDataFlowerOfWorld(String name) {
        super(name);
    }

    public void setFlower(int flower) {
        this.flower = flower;
        markDirty();
    }

    public int getFlower() {
        return flower;
    }

    public static WorldDataFlowerOfWorld get(World worldIn) {
        if (!(worldIn instanceof ServerWorld)) {
            throw new RuntimeException("禁止从客户端获取数据");
        }
        ServerWorld serverWorld = (ServerWorld) worldIn;
        DimensionSavedDataManager manager = serverWorld.getSavedData();
        return manager.getOrCreate(() -> {
            return new WorldDataFlowerOfWorld(NAME);
        }, NAME);
    }

    @Override
    public void read(CompoundNBT nbt) {
        this.flower = nbt.getInt("flower");
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.putInt("flower", this.flower);
        return compound;
    }
}
