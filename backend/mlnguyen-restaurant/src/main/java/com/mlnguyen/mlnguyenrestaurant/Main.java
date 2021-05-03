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
        MenuCategory appetizer = new MenuCategory("Appetizer", "Great starts, low prices!");
        MenuItem basicBurger = new MenuItem("basic burger 1", "description of basic burger", new BigDecimal(20.99), "assets/images/burger.jpg", true, appetizer);

        System.out.println("test123" + basicBurger.getCategory().getCategoryName());

        AddOnCategory addOnCategory = new AddOnCategory("spice level", "Choose your spice level", true, 1);
        AddOnItem mild = new AddOnItem("mild", new BigDecimal(0), "", true, addOnCategory);
        AddOnItem medium = new AddOnItem("medium", new BigDecimal(0), "", true, addOnCategory);
        AddOnItem hot = new AddOnItem("hot", new BigDecimal(0), "", true, addOnCategory);
        AddOnItem holymoly = new AddOnItem("holymoly", new BigDecimal(0), "", true, addOnCategory);

        basicBurger.add(addOnCategory);

        menuItemRepository.save(basicBurger);
    }
}
