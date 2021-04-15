package com.duha.grimme.tabs;

import com.duha.grimme.items.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GrimmeTab {
    public static final CreativeTabs grimme = new CreativeTabs("grimme") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.aegurRelic);
        }
    };
}