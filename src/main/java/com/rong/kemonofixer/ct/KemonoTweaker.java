package com.rong.kemonofixer.ct;

import java.util.HashMap;
import java.util.Map;

import com.rong.kemonofixer.ItemStackWrapper;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.entity.IEntity;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.oredict.IOreDict;
import erx.kemonocraft.entity.EntityIsFriends;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.kemonocraft")
public class KemonoTweaker {
    
    //EntityIsFriends here instead of just EntityCaracal to make things a lot easier in the future.
    public static final Map<EntityIsFriends, ItemStackWrapper> MINOR_FOOD = new HashMap<>();
    public static final Map<EntityIsFriends, ItemStackWrapper> LOVE_FOOD = new HashMap<>();
    
    @ZenMethod
    public static void addMinorFood(IEntity entity, IItemStack... ctStack) {
        if (!(entity instanceof EntityIsFriends)) {
            throw new IllegalArgumentException("addLoveFood does not allow any non-friend entities.");
        }
        for (IItemStack stack : ctStack) {
            if (stack.isFood()) {
                MINOR_FOOD.put((EntityIsFriends) CraftTweakerMC.getEntity(entity), new ItemStackWrapper(CraftTweakerMC.getItemStack(stack)));
            }
            else {
                CraftTweakerAPI.logWarning(stack.getDisplayName().concat(" wasn't added to the list of minor foods."));
            }
        }
    }
    
    @ZenMethod
    public static void addLoveFood(IEntity entity, IItemStack... ctStack) {
        if (!(entity instanceof EntityIsFriends)) {
            throw new IllegalArgumentException("addLoveFood does not allow any non-friend entities.");
        }
        for (IItemStack stack : ctStack) {
            if (stack.isFood()) {
                LOVE_FOOD.put((EntityIsFriends) CraftTweakerMC.getEntity(entity), new ItemStackWrapper(CraftTweakerMC.getItemStack(stack)));
            }
            else {
                CraftTweakerAPI.logWarning(stack.getDisplayName().concat(" wasn't added to the list of love foods."));
            }
        }
    }
    
    @ZenMethod
    public static void addMinorFood(IEntity entity, IItemStack ctStack) {
        if (!(entity instanceof EntityIsFriends)) {
            throw new IllegalArgumentException("addMinorFood does not allow any non-friend entities.");
        }
        else if (ctStack.isFood()) {
            MINOR_FOOD.put((EntityIsFriends) CraftTweakerMC.getEntity(entity), new ItemStackWrapper(CraftTweakerMC.getItemStack(ctStack)));
        }
        else {
            CraftTweakerAPI.logWarning(ctStack.getDisplayName().concat(" wasn't added to the list of minor foods."));
            throw new IllegalArgumentException("addMinorFood does not allow any non-food ItemStacks.");
        }
    }
    
    @ZenMethod
    public static void addLoveFood(IEntity entity, IItemStack ctStack) {
        if (!(entity instanceof EntityIsFriends)) {
            throw new IllegalArgumentException("addLoveFood does not allow any non-friend entities.");
        }
        else if (ctStack.isFood()) {
            LOVE_FOOD.put((EntityIsFriends) CraftTweakerMC.getEntity(entity), new ItemStackWrapper(CraftTweakerMC.getItemStack(ctStack)));
        }
        else {
            CraftTweakerAPI.logWarning(ctStack.getDisplayName().concat(" wasn't added to the list of love foods."));
            throw new IllegalArgumentException("addLoveFood does not allow any non-food ItemStacks.");
        }
    }
    
    /*
    public static void onPreInit() {
        ScriptLoader loader = CraftTweakerAPI.tweaker.getOrCreateLoader(KemonoCraft.MODID + "_data");
        CraftTweakerAPI.tweaker.loadScript(false, loader);
    }
    */

}
