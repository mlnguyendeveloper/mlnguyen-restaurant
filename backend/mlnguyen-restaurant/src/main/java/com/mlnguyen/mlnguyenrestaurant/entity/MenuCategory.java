package com.mlnguyen.mlnguyenrestaurant.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="menu_category")
@Getter
@Setter
public class MenuCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="category_name")
    private String categoryName;

    @Column(name="description")
    private String description;

    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "category")
    private Set<MenuItem> menuItems;

    public MenuCategory(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;

        this.menuItems = new HashSet<>();
    }

    public void add(MenuItem menuItem) {
        if (this.menuItems == null) {
            this.menuItems = new HashSet<>();
        }

        if (menuItem != null && this.menuItems.contains(menuItem)){
            menuItems.add(menuItem);

            menuItem.setCategory(this);
        }
    }
}
