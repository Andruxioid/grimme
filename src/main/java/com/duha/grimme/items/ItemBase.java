package com.duha.grimme.items;

import com.duha.grimme.Grimme;
import com.duha.grimme.tabs.GrimmeTab;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemBase extends Item {

    protected String name;
    protected String tooltip;

    public ItemBase(String name) {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        this.setCreativeTab(Tabs.tab);
    }

    public static class Tabs {
        public static final CreativeTabs tab = new CreativeTabs("grimme") {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(ModItems.aegurRelic);
            }
        };
    }

    public ItemBase withTooltip(String tooltip) {
        this.tooltip = tooltip;

        return this;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(I18n.format(this.tooltip));
    }

    public void registerItemModel() {
        Grimme.proxy.registerItemRenderer(this, 0, name);
    }

    @Override
    public ItemBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

}