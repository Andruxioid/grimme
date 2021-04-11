package com.duha.grimme.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

    public static ItemBase aegurRelic = new ItemBase("aegur_relic").setCreativeTab(CreativeTabs.MISC);
    public static ItemBase orutaRelic = new ItemBase("oruta_relic").setCreativeTab(CreativeTabs.MISC);
    public static ItemBase gerretRelic = new ItemBase("gerret_relic").setCreativeTab(CreativeTabs.MISC);
    public static ItemBase maganRelic = new ItemBase("magan_relic").setCreativeTab(CreativeTabs.MISC);

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
    }

    public static void registerModels() {
        aegurRelic.registerItemModel();
        orutaRelic.registerItemModel();
        gerretRelic.registerItemModel();
        maganRelic.registerItemModel();
    }

}
