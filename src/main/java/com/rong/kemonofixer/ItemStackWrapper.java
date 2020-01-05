package com.rong.kemonofixer;

import net.minecraft.item.ItemStack;

/**
 * @author Muramasa
 * - Taken from GregTech Intergalactical
 */
public class ItemStackWrapper {

    public ItemStack item;
    private boolean count, nbt;
    private int hash;
    
    public ItemStackWrapper(ItemStack item) {
        this.item = item;
        count = item.getCount() > 1;
        nbt = item.hasTagCompound();
        long tempHash = 1; //long hash used to handle many inputs with nbt hashes
        tempHash = 31 * tempHash + item.getItem().getRegistryName().toString().hashCode();
        if (item.getItemDamage() > 0) tempHash = 31 * tempHash + item.getItemDamage();
        if (nbt) tempHash = 31 * tempHash + item.getTagCompound().hashCode();
        hash = (int) (tempHash ^ (tempHash >>> 32)); //int version of the hash for the actual comparision
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ItemStackWrapper))
            return false;
        ItemStackWrapper other = (ItemStackWrapper) obj;
        if ((count && other.item.getCount() < item.getCount()) || (nbt && !ItemStack.areItemStackTagsEqual(other.item, item))) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return hash;
    }

}
