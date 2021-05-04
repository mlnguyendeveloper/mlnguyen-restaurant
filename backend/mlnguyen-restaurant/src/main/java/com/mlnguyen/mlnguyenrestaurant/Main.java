package com.mlnguyen.mlnguyenrestaurant;

import com.mlnguyen.mlnguyenrestaurant.dao.AddOnCategoryRepository;
import com.mlnguyen.mlnguyenrestaurant.dao.AddOnItemRepository;
import com.mlnguyen.mlnguyenrestaurant.dao.MenuCategoryRepository;
import com.mlnguyen.mlnguyenrestaurant.dao.MenuItemRepository;
import com.mlnguyen.mlnguyenrestaurant.entity.AddOnCategory;
import com.mlnguyen.mlnguyenrestaurant.entity.AddOnItem;
import com.mlnguyen.mlnguyenrestaurant.entity.MenuCategory;
import com.mlnguyen.mlnguyenrestaurant.entity.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
public class Main implements CommandLineRunner {

    private final AddOnCategoryRepository addOnCategoryRepository;
    private final AddOnItemRepository addOnItemRepository;
    private final MenuCategoryRepository menuCategoryRepository;
    private final MenuItemRepository menuItemRepository;

    @Autowired
    Main(AddOnCategoryRepository addOnCategoryRepository,
         AddOnItemRepository addOnItemRepository,
         MenuCategoryRepository menuCategoryRepository,
         MenuItemRepository menuItemRepository){

        this.addOnCategoryRepository = addOnCategoryRepository;
        this.addOnItemRepository = addOnItemRepository;
        this.menuCategoryRepository = menuCategoryRepository;
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public void run(String... args) throws IOException {

        //categories
        MenuCategory appetizersCategory = new MenuCategory("Appetizers & Snacks", null);
        MenuCategory burgersCategory = new MenuCategory("Burgers", "Comes with a side of fries and a drink");
        MenuCategory pizzasCategory = new MenuCategory("Pizzas", "Contains dairy. Optional gluten free crust (+$1)");
        MenuCategory mainsCategory = new MenuCategory("Mains", null);
        MenuCategory dessertsCategory = new MenuCategory("Desserts", null);

        //menu items
        //--appetizers
        MenuItem crispyCalamariMenuItem = new MenuItem("Crispy Calamari",
                "Lightly spiced tempura calamari. Freshly slice of lemon, with a sweet and spicy dip.",
                new BigDecimal(8.99), "assets/images/menu-items/calamari.jpg", true, appetizersCategory);
        MenuItem nachosMenuItem = new MenuItem("BEEFY nachos", "Nach-yo typical nachos. Corn tortilla chips, melted cheddar, bell peppers, jalapenos, green onions, salsa and sour cream.",
                new BigDecimal(10.99), "assets/images/menu-items/nachos.jpg", true, appetizersCategory);
        MenuItem mandarinNoodleSalad = new MenuItem("Mandarin Noodle Salad", "Chow mien noodles, organic greens, mandarin oranges, toasted almonds and pistachios, with a soy-lime dressing.",
                new BigDecimal(6.99), "assets/images/menu-items/mandarinSalad.jpg", true, appetizersCategory);
        MenuItem poutine = new MenuItem("Poutine", "Thick cut fries, cheese curds, bacon and chicken gravy.",
                new BigDecimal(9.99), "assets/images/menu-items/poutine.jpg", true, appetizersCategory);

        //--burgers
        MenuItem mlnguyenBurger = new MenuItem("Mlnguyen Burger", "200% real beef burger patties, cheddar cheese, pickles, and mayo.",
                new BigDecimal(13.99), "assets/images/menu-items/burger.jpg", true, burgersCategory);
        MenuItem bisonBurger = new MenuItem("Bison burger", "0% real beef, cause it's 100% bison. Cheddar cheese, lettuce, pickles, caramelized onions, and bbq sauce.",
                new BigDecimal(15.99), "assets/images/menu-items/burger2.jpg", true, burgersCategory);
        MenuItem beyondBeliefBurger = new MenuItem("Beyond Belief burger", "Another 0% beef burger. Made with beyond meat patties, red cabbage, pickles, and honey mustard.",
                new BigDecimal(15.99), "assets/images/menu-items/beyondBurger.jpg", true, burgersCategory);
        MenuItem crispyChickenBurger = new MenuItem("Crispy chicken burger", "What? 0% beef again? Who'd guess? Crispy chicken topped with parmesan, and marinara sauce.",
                new BigDecimal(14.99), "assets/images/menu-items/chickenBurger.jpg", true, burgersCategory);

        //--pizzas
        MenuItem pepperoniPizza = new MenuItem("Pepperoni Pizza", "How you survived through college. Pepperoni cheese on a nice thick crust. What else could you ask for?",
                new BigDecimal(19.99), "assets/images/menu-items/pepperoniPizza.jpg", true, pizzasCategory);
        MenuItem threeCheesePizza = new MenuItem("Three cheese pizza", "The romance of the three cheeses. Parmesan, cheddar and mozzarella cheese.",
                new BigDecimal(19.99), "assets/images/menu-items/threeCheesePizzas.jpg", true, pizzasCategory);
        MenuItem californianPizza = new MenuItem("Californian pizza", "California-styled pizza with kale, egg, and bacon",
                new BigDecimal(22.99), "assets/images/menu-items/burger.jpg", true, pizzasCategory);
        MenuItem chicagoPizza = new MenuItem("Chicago deep dish pizza", "Haters call it a casserole. Thick deep crust, layered with mozzarella cheese, and pizza sauce.",
                new BigDecimal(23.99), "assets/images/menu-items/deepDishPizza.jpg", true, pizzasCategory);

        //--mains
        MenuItem cajunShrimpLinguine = new MenuItem("Cajun Shrimp Linguine", "Linguine noodles tossed in cajun cream sauce, juicy shrimp, leafy field greens. Topped with gremolata.",
                new BigDecimal(18.99), "assets/images/menu-items/cajunShrimpLinguine.jpg", true, mainsCategory);
        MenuItem redThaiCurry = new MenuItem("Red Thai curry", "Coconut milk with fresh squash, bell peppers and lime.",
                new BigDecimal(20.99), "assets/images/menu-items/redCurry.jpg", true, mainsCategory);
        MenuItem chickenTendies = new MenuItem("Chicken tendies", "Six pieces of breaded chicken tenders with your choice of sides and sauce.",
                new BigDecimal(17.99), "assets/images/menu-items/chickenTenders.jpg", true, mainsCategory);
        MenuItem chickenWings = new MenuItem("Chicken wings", "1lb of extra crispy chicken wings with your choice of side and sauce.",
                new BigDecimal(17.99), "assets/images/menu-items/chickenWings.jpg", true, mainsCategory);

        //--desserts
        MenuItem iceCreamAndCake = new MenuItem("Cream and cake", "A slice of cake with your choice of ice cream.",
                new BigDecimal(13.99), "assets/images/menu-items/iceCreamAndCake.jpg", true, dessertsCategory);
        MenuItem cheeseCake = new MenuItem("New Yorker's cheesecake", "New York styled cheesecake. Enjoy it plain or with chocolate or caramel sauce.",
                new BigDecimal(9.99), "assets/images/menu-items/burger.jpg", true, dessertsCategory);
        MenuItem iceCream = new MenuItem("Ice cream", "Sweet and cool. A single scoop of your choice of ice cream.",
                new BigDecimal(7.99), "assets/images/menu-items/iceCream.jpg", true, dessertsCategory);
        MenuItem flurryShake = new MenuItem("Flurry Shakes", "Extra thick ice cream shakes!",
                new BigDecimal(7.99), "assets/images/menu-items/milkshake.jpg", true, dessertsCategory);

        //Add Add-on categories and their add-ons
        AddOnCategory spicynessAddOnCategory = new AddOnCategory("Spice level", "Choose your spice level", true, 1);
        AddOnItem mild = new AddOnItem("mild", new BigDecimal(0), "", true, spicynessAddOnCategory);
        AddOnItem medium = new AddOnItem("medium", new BigDecimal(0), "", true, spicynessAddOnCategory);
        AddOnItem hot = new AddOnItem("hot", new BigDecimal(0), "", true, spicynessAddOnCategory);
        AddOnItem holymoly = new AddOnItem("holymoly", new BigDecimal(0), "", true, spicynessAddOnCategory);

        AddOnCategory softDrinksCategory = new AddOnCategory("Soft drinks", "Add a drink", false, 99);
        AddOnItem water = new AddOnItem("Bottled water", new BigDecimal(1.50), "", true, softDrinksCategory);
        AddOnItem coke = new AddOnItem("Coke", new BigDecimal(2.50), "", true, softDrinksCategory);
        AddOnItem nestea = new AddOnItem("Nestea", new BigDecimal(2.50), "", true, softDrinksCategory);
        AddOnItem sprite = new AddOnItem("Sprite", new BigDecimal(2.50), "", true, softDrinksCategory);
        AddOnItem gingerale = new AddOnItem("Gingerale", new BigDecimal(2.50), "", true, softDrinksCategory);

        AddOnCategory extraSaladToppings = new AddOnCategory("Additional Salad toppings", "Add additional toppings", false, 99);
        AddOnItem egg = new AddOnItem("Hard boiled egg", new BigDecimal(2.50), "", true, extraSaladToppings);
        AddOnItem carrots = new AddOnItem("Carrot slices", new BigDecimal(0.50), "", true, extraSaladToppings);
        AddOnItem mango = new AddOnItem("Mango pieces", new BigDecimal(0.50), "", true, extraSaladToppings);
        AddOnItem edamame = new AddOnItem("Edamame", new BigDecimal(0.50), "", true, extraSaladToppings);
        AddOnItem spinach = new AddOnItem("Hard boiled egg", new BigDecimal(0), "", true, extraSaladToppings);
        AddOnItem fieldGreens = new AddOnItem("Field greens", new BigDecimal(0), "", true, extraSaladToppings);

        AddOnCategory burgerBun = new AddOnCategory("Burger buns", "Choice of buns", true, 1);
        AddOnItem sesamePoppySeed = new AddOnItem("Sesame Poppy Seed bun", new BigDecimal(0), "", true, burgerBun);
        AddOnItem ciabatta = new AddOnItem("Ciabatta bun", new BigDecimal(1.00), "", true, burgerBun);
        AddOnItem multigrain = new AddOnItem("Multigrain bun", new BigDecimal(1.0), "", true, burgerBun);
        AddOnItem glutenFree = new AddOnItem("Gluten-Free bun", new BigDecimal(2.0), "", true, burgerBun);

        AddOnCategory burgerToppings = new AddOnCategory("Burger toppings", "Additional toppings", false, 99);
        AddOnItem extraPatty = new AddOnItem("Extra burger patty", new BigDecimal(4.00), "", true, burgerToppings);
        AddOnItem friedEgg = new AddOnItem("Fried Egg", new BigDecimal(2.50), "", true, burgerToppings);
        AddOnItem bacon = new AddOnItem("Bacon Strips", new BigDecimal(1.50), "", true, burgerToppings);
        AddOnItem sauteedOnions = new AddOnItem("Sauteed Onions", new BigDecimal(1.00), "", true, burgerToppings);
        AddOnItem crispyOnions = new AddOnItem("Crispy Onions", new BigDecimal(1.00), "", true, burgerToppings);
        AddOnItem gaucamole = new AddOnItem("Gaucamole", new BigDecimal(1.50), "", true, burgerToppings);

        AddOnCategory choiceOfSides = new AddOnCategory("Choice of sides", "Choice of sides", true, 1);
        AddOnItem fries = new AddOnItem("Fries", new BigDecimal(0), "", true, choiceOfSides);
        AddOnItem sweetPotatoFries = new AddOnItem("Sweet potato fries", new BigDecimal(1.00), "", true, choiceOfSides);
        AddOnItem onionRings = new AddOnItem("Onion rings", new BigDecimal(1.00), "", true, choiceOfSides);
        AddOnItem poutineSide = new AddOnItem("Poutine", new BigDecimal(3.00), "", true, choiceOfSides);
        AddOnItem kettleChips = new AddOnItem("", new BigDecimal(1.00), "", true, choiceOfSides);

        AddOnCategory chickenDippingSauces = new AddOnCategory("Chicken Dipping sauces", "Choice of dipping sauces", true, 1);
        AddOnItem ranchSauce = new AddOnItem("Ranch", new BigDecimal(0), "", true, chickenDippingSauces);
        AddOnItem creamyGarlicSauce = new AddOnItem("Creamy garlic", new BigDecimal(0), "", true, chickenDippingSauces);
        AddOnItem sweetAndSourSauce = new AddOnItem("Sweet and Sour", new BigDecimal(0), "", true, chickenDippingSauces);
        AddOnItem bbqSauce = new AddOnItem("BBQ", new BigDecimal(0), "", true, chickenDippingSauces);

        AddOnCategory wingSauce = new AddOnCategory("Chicken wing sauce", "Choice of sauces", true, 1);
        AddOnItem bbqWingSauce = new AddOnItem("BBQ sauce", new BigDecimal(0), "", true, wingSauce);
        AddOnItem mediumSauce = new AddOnItem("Medium sauce", new BigDecimal(0), "", true, wingSauce);
        AddOnItem hotSauce = new AddOnItem("Hot sauce", new BigDecimal(0), "", true, wingSauce);
        AddOnItem honeyGarlic = new AddOnItem("Honey garlic sauce", new BigDecimal(0), "", true, wingSauce);
        AddOnItem buffaloSauce = new AddOnItem("Buffalo sauce", new BigDecimal(0), "", true, wingSauce);

        AddOnCategory pizzaCrust = new AddOnCategory("Pizza Crust", "Choose your crust", true, 1);
        AddOnItem regular = new AddOnItem("Regular crust", new BigDecimal(0), "", true, pizzaCrust);
        AddOnItem cheeseStuffed = new AddOnItem("Cheese stuffed crust", new BigDecimal(2.00), "", true, pizzaCrust);
        AddOnItem glutenFreeCrust = new AddOnItem("Gluten-Free crust", new BigDecimal(1.00), "", true, pizzaCrust);

        AddOnCategory pizzaSauce = new AddOnCategory("Pizza Sauce", "Choose your pizza sauce", true, 1);
        AddOnItem regularTomatoBased = new AddOnItem("Regular tomato based sauce", new BigDecimal(0), "", true, pizzaSauce);
        AddOnItem bbqPizzaSauce = new AddOnItem("BBQ pizza base", new BigDecimal(2.00), "", true, pizzaSauce);

        AddOnCategory additionalToppings = new AddOnCategory("Additional toppings", "Additional toppings", false, 99);
        AddOnItem pepperoni = new AddOnItem("Pepperoni", new BigDecimal(1.00), "", true, additionalToppings);
        AddOnItem baconTopping = new AddOnItem("Bacon bits", new BigDecimal(1.00), "", true, additionalToppings);
        AddOnItem groundBeef = new AddOnItem("Ground beef", new BigDecimal(1.00), "", true, additionalToppings);
        AddOnItem chicken = new AddOnItem("Chicken", new BigDecimal(1.00), "", true, additionalToppings);
        AddOnItem onion = new AddOnItem("Onion", new BigDecimal(1.00), "", true, additionalToppings);
        AddOnItem greenPepper = new AddOnItem("Green Pepper", new BigDecimal(1.00), "", true, additionalToppings);
        AddOnItem tomato = new AddOnItem("Tomato slices", new BigDecimal(1.00), "", true, additionalToppings);
        AddOnItem mushroom = new AddOnItem("Mushroom", new BigDecimal(1.00), "", true, additionalToppings);
        AddOnItem blackOlive = new AddOnItem("Black olive", new BigDecimal(1.00), "", true, additionalToppings);

        AddOnCategory iceCreamFlavor = new AddOnCategory("Ice cream", "Choice of ice cream flavors", true, 1);
        AddOnItem vanilla = new AddOnItem("Vanilla", new BigDecimal(0.00), "", true, iceCreamFlavor);
        AddOnItem chocolate = new AddOnItem("Chocolate", new BigDecimal(0.00), "", true, iceCreamFlavor);
        AddOnItem matcha = new AddOnItem("Matcha", new BigDecimal(0.00), "", true, iceCreamFlavor);
        AddOnItem blackSesame = new AddOnItem("Black sesame", new BigDecimal(0.00), "", true, iceCreamFlavor);


        //crispyCalamariMenuItem, nachosMenuItem, mandarinNoodleSalad, poutine,
        //mlnguyenBurger, bisonBurger, beyondBeliefBurger, crispyChickenBurger
        //pepperoniPizza, threeCheesePizza, californianPizza, chicagoPizza
        //cajunShrimpLinguine, redThaiCurry, chickenTendies, chickenWings
        //iceCreamAndCake, cheeseCake, iceCream, flurryShake

        /*
        spicynessAddOnCategory
        softDrinksCategory
        extraSaladToppings
        burgerBun
        burgerToppings
        choiceOfSides
        chickenDippingSauces
        wingSauce
        pizzaCrust
        pizzaSauce
        additionalToppings
        iceCreamFlavor
         */

        //manage add on categories into menu items
        mandarinNoodleSalad.add(extraSaladToppings);

        mlnguyenBurger.add(burgerBun);
        mlnguyenBurger.add(burgerToppings);
        mlnguyenBurger.add(choiceOfSides);
        mlnguyenBurger.add(softDrinksCategory);

        bisonBurger.add(burgerBun);
        bisonBurger.add(burgerToppings);
        bisonBurger.add(choiceOfSides);
        bisonBurger.add(softDrinksCategory);

        beyondBeliefBurger.add(burgerBun);
        beyondBeliefBurger.add(burgerToppings);
        beyondBeliefBurger.add(choiceOfSides);
        beyondBeliefBurger.add(softDrinksCategory);

        crispyChickenBurger.add(burgerBun);
        crispyChickenBurger.add(choiceOfSides);
        crispyChickenBurger.add(softDrinksCategory);

        pepperoniPizza.add(pizzaCrust);
        pepperoniPizza.add(pizzaSauce);
        pepperoniPizza.add(additionalToppings);

        threeCheesePizza.add(pizzaCrust);
        threeCheesePizza.add(pizzaSauce);
        threeCheesePizza.add(additionalToppings);

        californianPizza.add(pizzaCrust);
        californianPizza.add(pizzaSauce);
        californianPizza.add(additionalToppings);

        chicagoPizza.add(pizzaCrust);
        chicagoPizza.add(additionalToppings);

        redThaiCurry.add(spicynessAddOnCategory);

        chickenTendies.add(chickenDippingSauces);
        chickenTendies.add(choiceOfSides);
        chickenTendies.add(softDrinksCategory);

        chickenWings.add(wingSauce);
        chickenWings.add(choiceOfSides);
        chickenWings.add(softDrinksCategory);

        iceCreamAndCake.add(iceCreamFlavor);

        iceCream.add(iceCreamFlavor);

        flurryShake.add(iceCreamFlavor);

        //crispyCalamariMenuItem, nachosMenuItem, mandarinNoodleSalad, poutine,
        //mlnguyenBurger, bisonBurger, beyondBeliefBurger, crispyChickenBurger
        //pepperoniPizza, threeCheesePizza, californianPizza, chicagoPizza
        //cajunShrimpLinguine, redThaiCurry, chickenTendies, chickenWings
        //iceCreamAndCake, cheeseCake, iceCream, flurryShake
        //add all menu items to repository\
        List<MenuItem> menuItems = Arrays.asList(
                crispyCalamariMenuItem, nachosMenuItem, mandarinNoodleSalad, poutine,
                mlnguyenBurger, bisonBurger, beyondBeliefBurger, crispyChickenBurger,
                pepperoniPizza, threeCheesePizza, californianPizza, chicagoPizza,
                cajunShrimpLinguine, redThaiCurry, chickenTendies, chickenWings,
                iceCreamAndCake, cheeseCake, iceCream, flurryShake);
        //menuItemRepository.saveAll(menuItems);
    }
}
