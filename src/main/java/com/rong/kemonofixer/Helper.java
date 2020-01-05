package com.rong.kemonofixer;

import erx.kemonocraft.KemonoCraft;
import erx.kemonocraft.entity.EntityBigCellien;
import erx.kemonocraft.entity.EntityBigRedCellien;
import erx.kemonocraft.entity.EntityCaracal;
import erx.kemonocraft.entity.EntityCellien;
import erx.kemonocraft.entity.EntityEzoRedFox;
import erx.kemonocraft.entity.EntityFennec;
import erx.kemonocraft.entity.EntityKomodo;
import erx.kemonocraft.entity.EntityOtter;
import erx.kemonocraft.entity.EntityRaccoon;
import erx.kemonocraft.entity.EntityRedCellien;
import erx.kemonocraft.entity.EntityRedFox;
import erx.kemonocraft.entity.EntityServal;
import erx.kemonocraft.entity.EntitySilverFox;
import erx.kemonocraft.entity.EntityToki;
import erx.kemonocraft.init.KemonoMobEggInfo;
import erx.kemonocraft.utility.KemonoFunction;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class Helper {

    public static void registerEntities() {
        EntityRegistry.registerModEntity(KemonoFunction.getResourceLocation("serval"), EntityServal.class, "Serval", 0, KemonoCraft.instance, 54, 2, false, 16769280, 14722441);
        EntityRegistry.registerModEntity(KemonoFunction.getResourceLocation("caracal"), EntityCaracal.class, "Caracal", 1, KemonoCraft.instance, 54, 2, false, 0, 0);
        EntityRegistry.registerModEntity(KemonoFunction.getResourceLocation("fennec"), EntityFennec.class, "Fennec", 2, KemonoCraft.instance, 54, 2, false, 0, 0);
        EntityRegistry.registerModEntity(KemonoFunction.getResourceLocation("raccoon"), EntityRaccoon.class, "Raccoon", 3, KemonoCraft.instance, 54, 2, false, 0, 0);
        EntityRegistry.registerModEntity(KemonoFunction.getResourceLocation("otter"), EntityOtter.class, "Otter", 4, KemonoCraft.instance, 54, 2, false, 0, 0);
        EntityRegistry.registerModEntity(KemonoFunction.getResourceLocation("ezoredfox"), EntityEzoRedFox.class, "EzoRedFox", 5, KemonoCraft.instance, 54, 2, false, 0, 0);
        EntityRegistry.registerModEntity(KemonoFunction.getResourceLocation("silverfox"), EntitySilverFox.class, "SilverFox", 6, KemonoCraft.instance, 54, 2, false, 0, 0);
        EntityRegistry.registerModEntity(KemonoFunction.getResourceLocation("redfox"), EntityRedFox.class, "RedFox", 7, KemonoCraft.instance, 54, 2, false, 0, 0);
        EntityRegistry.registerModEntity(KemonoFunction.getResourceLocation("toki"), EntityToki.class, "Toki", 8, KemonoCraft.instance, 54, 2, false, 0, 0);
        EntityRegistry.registerModEntity(KemonoFunction.getResourceLocation("komodo"), EntityKomodo.class, "KomodoDragon", 9, KemonoCraft.instance, 54, 2, false, 0, 0);
        EntityRegistry.registerModEntity(KemonoFunction.getResourceLocation("cellien"), EntityCellien.class, "Cellien", 10, KemonoCraft.instance, 60, 2, false, 2179559, 8046335);
        EntityRegistry.registerModEntity(KemonoFunction.getResourceLocation("redcellien"), EntityRedCellien.class, "RedCellien", 11, KemonoCraft.instance, 60, 2, false, 10295577, 16735581);
        EntityRegistry.registerModEntity(KemonoFunction.getResourceLocation("bigcellien"), EntityBigCellien.class, "BigCellien", 12, KemonoCraft.instance, 60, 2, false, 1061095, 2162560);
        EntityRegistry.registerModEntity(KemonoFunction.getResourceLocation("bigredcellien"), EntityBigRedCellien.class, "BigRedCellien", 13, KemonoCraft.instance, 60, 2, false, 16711712, 2162560);
        new KemonoMobEggs();
    }

}
