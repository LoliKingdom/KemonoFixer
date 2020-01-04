package com.rong.kemonofixer;

import erx.kemonocraft.entity.EntityCaracal;
import erx.kemonocraft.entity.EntityFennec;
import erx.kemonocraft.entity.EntityKomodo;
import erx.kemonocraft.entity.EntityOtter;
import erx.kemonocraft.entity.EntityRaccoon;
import erx.kemonocraft.entity.EntityRedFox;
import erx.kemonocraft.entity.EntityServal;
import erx.kemonocraft.entity.EntitySilverFox;
import erx.kemonocraft.entity.EntityToki;
import net.minecraft.entity.EntityList;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ExtraMobEggs {
    
    public static final EntityList.EntityEggInfo Serval = EntityRegistry.getEntry(EntityServal.class).getEgg();
    public static final EntityList.EntityEggInfo Caracal = EntityRegistry.getEntry(EntityCaracal.class).getEgg();
    public static final EntityList.EntityEggInfo Fennec = EntityRegistry.getEntry(EntityFennec.class).getEgg();
    public static final EntityList.EntityEggInfo Raccoon = EntityRegistry.getEntry(EntityRaccoon.class).getEgg();
    public static final EntityList.EntityEggInfo Otter = EntityRegistry.getEntry(EntityOtter.class).getEgg();
    public static final EntityList.EntityEggInfo SilverFox = EntityRegistry.getEntry(EntitySilverFox.class).getEgg();
    public static final EntityList.EntityEggInfo RedFox = EntityRegistry.getEntry(EntityRedFox.class).getEgg();
    public static final EntityList.EntityEggInfo Toki = EntityRegistry.getEntry(EntityToki.class).getEgg();
    public static final EntityList.EntityEggInfo KomodoDragon = EntityRegistry.getEntry(EntityKomodo.class).getEgg();

}
