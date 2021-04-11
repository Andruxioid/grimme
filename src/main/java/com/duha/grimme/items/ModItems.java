package com.duha.grimme.items;

import com.duha.grimme.tabs.GrimmeTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

    public static ItemBase aegurRelic = new ItemBase("aegur_relic").withTooltip("grimme.info.aegur_relic");
    public static ItemBase orutaRelic = new ItemBase("oruta_relic").withTooltip("grimme.info.oruta_relic");
    public static ItemBase gerretRelic = new ItemBase("gerret_relic").withTooltip("grimme.info.gerret_relic");
    public static ItemBase maganRelic = new ItemBase("magan_relic").withTooltip("grimme.info.magan_relic");
    public static ItemBase humatRelic = new ItemBase("humat_relic").withTooltip("grimme.info.humat_relic");

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                aegurRelic
        );
        registry.registerAll(
                orutaRelic
        );
        registry.registerAll(
                gerretRelic
        );
        registry.registerAll(
                maganRelic
        );
        registry.registerAll(
                humatRelic
        );
    }

    public static void registerModels() {
        aegurRelic.registerItemModel();
        orutaRelic.registerItemModel();
        gerretRelic.registerItemModel();
        maganRelic.registerItemModel();
        humatRelic.registerItemModel();
    }

}
