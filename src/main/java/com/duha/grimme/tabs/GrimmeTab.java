package com.duha.grimme.tabs;

import com.duha.grimme.Grimme;
import com.duha.grimme.items.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GrimmeTab extends CreativeTabs
{
    public static CreativeTabs GrimmeTab;

    public GrimmeTab()
    {
        super("grimme");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack getTabIconItem()
    {
        return new ItemStack(ModItems.aegurRelic);
    }
}
