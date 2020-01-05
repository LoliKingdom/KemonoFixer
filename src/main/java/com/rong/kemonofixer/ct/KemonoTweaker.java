package com.rong.kemonofixer.ct;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.entity.IEntity;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.runtime.ScriptLoader;
import erx.kemonocraft.entity.EntityIsFriends;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.kemonocraft")
public class KemonoTweaker {
    
    public static final Int2ObjectOpenHashMap<Set<Item>> MINOR_FOODS = new Int2ObjectOpenHashMap<>();
    public static final Int2ObjectOpenHashMap<Set<Item>> LOVE_FOODS = new Int2ObjectOpenHashMap<>();
    public static final Int2ObjectOpenHashMap<Set<Item>> SPECIAL_ITEMS = new Int2ObjectOpenHashMap<>();
    
    @ZenMethod
    public static void addMinorFood(IEntity entity, IItemStack... ctStack) {
        if (!isFriend(entity)) {
            throw new IllegalArgumentException("addMinorFood does not allow any non-friend entities.");
        }
        MINOR_FOODS.put(entity.getID(), Arrays.stream(ctStack).filter(stack -> isFood(stack, entity, "Minor Foods")).map(s -> getItem(s)).collect(Collectors.toSet()));
    }
    
    @ZenMethod
    public static void addLoveFood(IEntity entity, IItemStack... ctStack) {
        if (!isFriend(entity)) {
            throw new IllegalArgumentException("addLoveFood does not allow any non-friend entities.");
        }
        LOVE_FOODS.put(entity.getID(), Arrays.stream(ctStack).filter(stack -> isFood(stack, entity, "Love Foods")).map(s -> getItem(s)).collect(Collectors.toSet()));
    }
    
    @ZenMethod
    public static void addSpecialItem(IEntity entity, IItemStack... ctStack) {
        if (!isFriend(entity)) {
            throw new IllegalArgumentException("addSpecialItem does not allow any non-friend entities.");
        }
        Set<Item> set = new HashSet<>();
        for (IItemStack stack : ctStack) {
            CraftTweakerAPI.logInfo(String.format("%s was added to %s's Special Items", stack.getDisplayName(), entity.getDisplayName()));
            set.add(getItem(stack));
        }
        SPECIAL_ITEMS.put(entity.getID(), set);    
    }
    
    public static void onPreInit() {
        ScriptLoader loader = CraftTweakerAPI.tweaker.getOrCreateLoader("kemonofixer");
        CraftTweakerAPI.tweaker.loadScript(false, loader);
    }
    
    private static Item getItem(IItemStack stack) {
        return CraftTweakerMC.getItemStack(stack).getItem();
    }
    
    private static boolean isFriend(IEntity entity) {
        return CraftTweakerMC.getEntity(entity) instanceof EntityIsFriends;
    }
    
    private static boolean isFood(IItemStack stack, IEntity entity, String identifier) {
        if (!stack.isFood()) {
            CraftTweakerAPI.logWarning(String.format("%s wasn't added to %s's %s", stack.getDisplayName(), entity.getDisplayName(), identifier));
            return false;
        }
        CraftTweakerAPI.logInfo(String.format("%s was added to %s's %s", stack.getDisplayName(), entity.getDisplayName(), identifier));
        return true;
    }

}
