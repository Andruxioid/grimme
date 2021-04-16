package com.duha.grimme.items;

import client.gui.BookGuiScreen;
import com.duha.grimme.Grimme;
import com.duha.grimme.utils.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CustomBook extends ItemBase {
    String textName = "";
    ResourceLocation texture;
    public boolean showCount;
    public int angel;
    public int countColor;

    public CustomBook(String name, String textName, ResourceLocation texture, boolean showCount, int angel, int countColor) {
        super(name);
        this.textName = textName;
        this.texture = texture;
        this.angel = angel;
        this.showCount = showCount;
        this.countColor = countColor;
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            Grimme.logger.info("BOOK IS ACTIVE");

        } else {
            this.openBook();
        }
        return EnumActionResult.SUCCESS;
    }

    public void registerItemModel() {
        Grimme.proxy.registerItemRenderer(this, 0, name);
    }

    @SideOnly(Side.CLIENT)
    private void openBook() {
        String lang = "";
        if (Minecraft.getMinecraft().getLanguageManager().getCurrentLanguage().getLanguageCode().equalsIgnoreCase("en_us")) {
            lang = "en";
        }
        if (Minecraft.getMinecraft().getLanguageManager().getCurrentLanguage().getLanguageCode().equalsIgnoreCase("ru_ru")) {
            lang = "ru";
        }
        ResourceLocation text = new ResourceLocation(Reference.MODID, "information/" + lang + "/" + textName + ".json");
        Minecraft.getMinecraft().displayGuiScreen(new BookGuiScreen(texture, text, showCount, angel, countColor));
    }
}
