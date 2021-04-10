package com.duha.grimme.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

    public static ItemBase aegurRelic = new ItemBase("aegur_relic").setCreativeTab(CreativeTabs.MISC);

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                aegurRelic
        );
    }

    public static void registerModels() {
        aegurRelic.registerItemModel();
    }

}
