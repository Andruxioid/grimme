package com.duha.grimme.items;

import client.gui.BookGuiScreen;
import com.duha.grimme.Grimme;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BookBase extends ItemBase {
    public BookBase(String name) {
        super(name);
    }

    public void registerItemModel() {
        Grimme.proxy.registerItemRenderer(this, 0, name);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
       if(worldIn.isRemote){
           Minecraft.getMinecraft().displayGuiScreen(new BookGuiScreen());
       }
        return EnumActionResult.SUCCESS;
    }
}
