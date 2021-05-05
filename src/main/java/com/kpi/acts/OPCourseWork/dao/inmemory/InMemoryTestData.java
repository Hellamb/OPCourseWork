package com.kpi.acts.OPCourseWork.dao.inmemory;

import com.kpi.acts.OPCourseWork.model.Menu;
import com.kpi.acts.OPCourseWork.model.MenuElement;

public class InMemoryTestData {
    public static void generateTestData(InMemoryDatabase database)
    {
        database.menu.clear();
        database.order.clear();

        MenuElement pizza = new MenuElement("Pizza",
                "https://media.dominos.ua/__sized__/menu/product_osg_image_category/2020/12/28/Vetchina_i_griby_-thumbnail-960x960-70.jpg",
                5,
                "Pizza is a national Italian dish, which is a round open flatbread topped with melted cheese (usually mozzarella) and tomatoes. Cheese is by far the main ingredient in pizza. The rest of the ingredients differ depending on the type of pizza. Today, pizza is one of the most popular dishes in the world."
        );
        MenuElement potato = new MenuElement("Potato",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSiOh-exQ8yWBtkDCv0MTjTbHboqkRDwJOtnQ&usqp=CAU",
                3,
                "Delicious fried potatoes are an incredibly popular recipe. And this is more true than ever, because the recipe for fried potatoes is simple, always delicious and infinitely varied. Fried potatoes with onions and fried potatoes with bacon, fried young potatoes with garlic, fried potatoes with an egg and fried potatoes with stew are recipes familiar and loved from childhood, when fried potatoes appeared on the table so often. A recipe with a photo will remind you of the options for its preparation and offer new ones, no less tasty."
        );
        MenuElement soup = new MenuElement("Soup",
                "https://www.fifteenspatulas.com/wp-content/uploads/2016/02/Chicken-Noodle-Soup-Fifteen-Spatulas-3-640x427.jpg",
                4,
                "This quick Chicken Noodle Soup recipe is perfect when you want a hot bowl of comfort but don’t want to slave over the stove for hours. It has the simple, clean flavors you expect from this classic soup."
        );
        MenuElement water = new MenuElement("Water",
                "https://www.aces.edu/wp-content/uploads/2020/06/A-Glass-of-water-on-white-background-1161576130_5760x3840-scaled-e1593446976432.jpeg",
                1,
                "Mineral water, water that contains a large quantity of dissolved minerals or gases. Mineral water from natural springs commonly has a high content of calcium carbonate, magnesium sulfate, potassium, and sodium sulfate. It may also be impregnated with such gases as carbon dioxide or hydrogen sulfide. Mineral water is produced artificially by adding salts to distilled water or aerating it with carbon dioxide. The mineral content of both natural and artificial mineral water varies greatly, and in some cases it may be less than that of ordinary tap water."
        );
        MenuElement lemonade = new MenuElement("Lemonade",
                "https://specials-images.forbesimg.com/imageserve/5edfae954fa9b60007795fd6/960x0.jpg?fit=scale",
                2,
                "Lemonade is always the perfect drink for any summer get together or midday lunchtime treat! It’s bright and flavorful and always so satisfying. Plus it’s kid friendly so the whole family can enjoy it."
        );
        MenuElement iceCream = new MenuElement("Ice cream",
                "https://images.cookforyourlife.org/wp-content/uploads/2020/06/Chocolate-Whipped-Ice-Cream-shutterstock_1010248351.jpg",
                3,
                "ce cream is sweet, and is usually flavored with fruit, spices, or candy- the flavor often influences the color (that is, chocolate ice cream is brown, strawberry and cherry flavors are pink, pistachio is green). Good ice cream has a smooth texture. Your ice cream should be cold, unless you like ice cream soup."
        );
        MenuElement cake = new MenuElement("Cake",
                "https://www.biggerbolderbaking.com/wp-content/uploads/2019/06/Easy-Chocolate-Cake-Made-in-the-Microwave-thumbnail.png",
                3,
                "A bloom of summer strawberries and cream adorned plate, she called it her Wimbledon cake, and said it was made from \"all-love.\""
        );

        Menu dishes = new Menu(1,"Dishes");
        Menu drinks = new Menu(2,"Drinks");
        Menu desserts = new Menu(3, "Desserts");

        dishes.addMenuElement(pizza);
        dishes.addMenuElement(potato);
        dishes.addMenuElement(soup);
        drinks.addMenuElement(water);
        drinks.addMenuElement(lemonade);
        desserts.addMenuElement(iceCream);
        desserts.addMenuElement(cake);

        database.menu.put(dishes.getMenuId(), dishes);
        database.menu.put(drinks.getMenuId(), drinks);
        database.menu.put(desserts.getMenuId(), desserts);

    }
}
