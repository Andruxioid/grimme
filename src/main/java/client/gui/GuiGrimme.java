package client.gui;

import com.duha.grimme.Grimme;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;

public class GuiGrimme extends GuiScreen {

    final ResourceLocation texture = new ResourceLocation(Grimme.MODID, "textures/gui/book.png");
    int guiWidth = 200;
    int guiHeight = 180;

    GuiButton button_n;

    final int BUTTON_N = 0;
    String title = "Tutorial";

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        int centerX = (width / 2) - guiWidth / 2;
        int centerY = (height / 2) - guiHeight / 2;
        drawTexturedModalRect(centerX,centerY,0,0, guiWidth, guiHeight);
        drawString(fontRenderer, title, (width / 2) - fontRenderer.getStringWidth(title) / 2, centerY + 10, 0x6028ff);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void initGui() {
        buttonList.clear();
        buttonList.add(button_n = new GuiButton(BUTTON_N, 0, 0, 100, 20, "Button"));
        super.initGui();
    }

    public void updateButtons() {
        if (title.equals("Tutorial"))  {
            button_n.enabled = true;
        } else {
            button_n.enabled = false;
        }
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        switch (button.id) {
            case BUTTON_N:
                title = "Clicked";
                break;
        }
        updateButtons();
        super.actionPerformed(button);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        super.keyTyped(typedChar, keyCode);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
    }
}
