package com.mlnguyen.mlnguyenrestaurant.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="add_on_category")
@Getter
@Setter
public class AddOnCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="category_name")
    private String categoryName;

    @Column(name="description")
    private String description;

    @Column(name="required")
    private boolean required;

    @Column(name="quantity_limit")
    private int quantityLimit;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<AddOnItem> addOnItems;

    @ManyToMany(mappedBy = "addOnCategories")
    private Set<MenuItem> menuItems;

    public AddOnCategory(String categoryName, String description, boolean required, int quantityLimit) {
        this.categoryName = categoryName;
        this.description = description;
        this.required = required;
        this.quantityLimit = quantityLimit;

        this.addOnItems = new HashSet<>();
        this.menuItems = new HashSet<>();
    }

    public void add(AddOnItem addOnItem) {
        if (this.addOnItems == null) {
            this.addOnItems = new HashSet<>();
        }

        if (addOnItem != null && !this.addOnItems.contains(addOnItem)) {
            this.addOnItems.add(addOnItem);
            addOnItem.setCategory(this);
        }
    }

    public void add(MenuItem menuItem) {
        if (this.menuItems == null){
            this.menuItems = new HashSet<>();
        }

        if (menuItem != null && !this.menuItems.contains(menuItem)){
            this.menuItems.add(menuItem);

            if (!menuItem.getAddOnCategories().contains(this)){
                menuItem.add(this);
            }
        }
    }

}
