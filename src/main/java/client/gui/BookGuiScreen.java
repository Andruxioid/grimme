package client.gui;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.io.IOUtils;
import org.lwjgl.opengl.GL11;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;


public class BookGuiScreen extends GuiScreen {
    private static final int pageShiftX = 15;
    private static final int pageShiftY = 15;
    public static ResourceLocation locationTexture;
    public static ResourceLocation locationText;
    public GuiButton buttonNext;
    private static final int countShiftY = 6;
    public int Page = 0;
    public GuiButton buttonBack;
    public static int WIDTH = 147;
    private static final int countShiftX = WIDTH / 2;
    private static final int wrapWidth = WIDTH - 25;
    public static int HEIGHT = 181;
    public static int MaxPage;
    public ArrayList<String> BookText = new ArrayList<String>();
    private float angel = 0;
    private boolean showCount = false;
    private int countColor = 1;

    public BookGuiScreen() {
        BookGuiScreen.locationTexture = locationTexture;
        BookGuiScreen.locationText = locationText;
        Parsing();
    }

    public BookGuiScreen(ResourceLocation locationTexture, ResourceLocation locationText, boolean showCount, float angel, int countColor) {
        BookGuiScreen.locationTexture = locationTexture;
        BookGuiScreen.locationText = locationText;
        this.angel = angel;
        this.countColor = countColor;
        this.showCount = showCount;
        Parsing();

    }

    private static ArrayList<String> JsonParsing(IResourceManager resourceManager) throws IOException {
        ArrayList<String> pages = new ArrayList<String>();
        IResource resource = resourceManager.getResource(locationText);
        JsonArray JSONArray = new JsonParser().parse(IOUtils.toString(resource.getInputStream(), Charset.defaultCharset())).getAsJsonObject().get("pages").getAsJsonArray();
        MaxPage = JSONArray.size();
        MaxPage -= 1;
        for (int j = 0; j < JSONArray.size(); j++) {
            pages.add(JSONArray.get(j).getAsString());
        }
        return pages;
    }

    private void Parsing() {
        try {
            BookText = JsonParsing(Minecraft.getMinecraft().getResourceManager());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateButtons() {
        buttonBack.enabled = true;
        buttonNext.enabled = true;
        buttonBack.visible = true;
        buttonNext.visible = true;
        if (Page == MaxPage) {
            buttonNext.enabled = false;
            buttonNext.visible = false;
        }
        if (Page == 0) {
            buttonBack.enabled = false;
            buttonBack.visible = false;
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        GL11.glColor4f(1, 1, 1, 1);
        this.drawDefaultBackground();
        int centerX = (width - WIDTH) / 2;
        int centerY = (height - HEIGHT) / 2;
        mc.renderEngine.bindTexture(locationTexture);
        drawTexturedModalRect(centerX, centerY, 0, 0, WIDTH, HEIGHT);
        if (showCount)
            fontRenderer.drawString(this.getCurrentPage() + "/" + this.getMaxPage(), centerX + countShiftX, centerY + countShiftY, countColor);
        GlStateManager.pushMatrix();
        GlStateManager.translate(centerX + pageShiftX, centerY + pageShiftY, 0);
        GlStateManager.rotate(angel, 0, 0, 1);
        fontRenderer.drawSplitString(BookText.get(this.Page), 0, 0, wrapWidth, 1);
        GlStateManager.popMatrix();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
    }

    private int getCurrentPage() {
        int number;
        number = Page;
        number++;
        return number;
    }

    private int getMaxPage() {
        int number;
        number = MaxPage;
        number++;
        return number;
    }

    @Override
    public void initGui() {
        this.buttonNext = this.addButton(new NextButton(0, (width - WIDTH) / 2 + WIDTH, (height - HEIGHT) / 2 + HEIGHT, "", true));
        this.buttonBack = this.addButton(new NextButton(1, (width - WIDTH) / 2, (height - HEIGHT) / 2 + HEIGHT, "", false));
        this.updateButtons();
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    public boolean handleComponentClick(ITextComponent component) {
        return true;
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.enabled) {
            if (button.id == 0) {
                this.Page += 1;
            } else if (button.id == 1) {
                this.Page -= 1;
            }
        }
        this.updateButtons();
    }

    @SideOnly(Side.CLIENT)
    private static class NextButton extends GuiButton {
        private final boolean isForward;

        public NextButton(int buttonId, int x, int y, String buttonText, boolean isForward) {
            super(buttonId, x, y, "");
            this.isForward = isForward;
            this.height = 10;
            this.width = 18;
        }


        @Override
        public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
            boolean flag = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
            if (this.visible) {
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                mc.getTextureManager().bindTexture(BookGuiScreen.locationTexture);
                int i = 151;
                int j = 10;
                if (!this.isForward) {
                    j += 13;
                }
                if (flag) {
                    i += 23;
                }
                this.drawTexturedModalRect(x, y, i, j, 18, 10);
            }

        }
    }
}