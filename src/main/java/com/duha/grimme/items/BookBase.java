package com.duha.grimme.items;

import client.gui.GuiGrimme;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BookBase extends ItemBase {
    public BookBase(String name) {
        super(name);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
       if(!worldIn.isRemote){
           Minecraft.getMinecraft().displayGuiScreen(new GuiGrimme());
       }
        return EnumActionResult.SUCCESS;
    }
}
