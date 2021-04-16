package com.duha.grimme.items;


import net.minecraft.item.Item;
import com.duha.grimme.utils.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

    public static ItemBase aegurRelic = new ItemBase("aegur_relic").withTooltip("grimme.info.aegur_relic");
    public static ItemBase orutaRelic = new ItemBase("oruta_relic").withTooltip("grimme.info.oruta_relic");
    public static ItemBase gerretRelic = new ItemBase("gerret_relic").withTooltip("grimme.info.gerret_relic");
    public static ItemBase maganRelic = new ItemBase("magan_relic").withTooltip("grimme.info.magan_relic");
    public static ItemBase humatRelic = new ItemBase("humat_relic").withTooltip("grimme.info.humat_relic");
    //Books
    public static final Item motherBook = new CustomBook("mother_book", "mother", new ResourceLocation(Reference.MODID, "textures/gui/list_mother.png"), true, 0, 1).withTooltip("info.mother_book");

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
        registry.registerAll(
                humatRelic
        );
        //Books registry
        registry.registerAll(
                motherBook
        );
    }

    public static void registerModels() {
        //Тут проблема какова - когдая я пытаюсь записать в категорию регистрации модели motherBook.registerItemModel();
        //Всё ломается к херам (error: cannot find symbol) и что делать я без особого понятия; в логах загрузки нету
        //Ни одного сообщения, которое бы могло указать на то, куда и где делась текстура; самый сок в том,
        //Что ЖСОН-файл как бы парсится, но из-за отстутсвия регистрации модели он ничего не делает. Прямо как я.
        aegurRelic.registerItemModel();
        orutaRelic.registerItemModel();
        gerretRelic.registerItemModel();
        maganRelic.registerItemModel();
        humatRelic.registerItemModel();
    }

}
