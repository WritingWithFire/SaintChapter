package net.writingwithfire.saintchapter.datagen.data.advancements.bulider;

import com.google.common.collect.Lists;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.command.FunctionObject;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;
import java.util.List;

public class SCAdvancementRewardBuilder {
    private int experience;
    private final List<ResourceLocation> loot = Lists.newArrayList();
    private final List<ResourceLocation> recipes = Lists.newArrayList();
    @Nullable
    private ResourceLocation function;

    public static SCAdvancementRewardBuilder experience(int experienceIn) {
        return (new SCAdvancementRewardBuilder()).addExperience(experienceIn);
    }

    public SCAdvancementRewardBuilder addExperience(int experienceIn) {
        this.experience += experienceIn;
        return this;
    }

    public static SCAdvancementRewardBuilder recipe(ResourceLocation recipeIn) {
        return (new SCAdvancementRewardBuilder()).addRecipe(recipeIn);
    }

    public SCAdvancementRewardBuilder addRecipe(ResourceLocation recipeIn) {
        this.recipes.add(recipeIn);
        return this;
    }

    public SCAdvancementRewardBuilder loot(ResourceLocation lootIn) {
        return (new SCAdvancementRewardBuilder()).addLoot(lootIn);
    }

    public SCAdvancementRewardBuilder addLoot(ResourceLocation lootIn) {
        loot.add(lootIn);
        return this;
    }

    public SCAdvancementRewardBuilder function(ResourceLocation functionIn) {
        return (new SCAdvancementRewardBuilder()).addFunction(functionIn);
    }

    public SCAdvancementRewardBuilder addFunction(ResourceLocation functionIn) {
        this.function = functionIn;
        return this;
    }

    public AdvancementRewards build() {
        return new AdvancementRewards(this.experience, this.loot.toArray(new ResourceLocation[0]), this.recipes.toArray(new ResourceLocation[0]), this.function == null ? FunctionObject.CacheableFunction.EMPTY : new FunctionObject.CacheableFunction(this.function));
    }
}
