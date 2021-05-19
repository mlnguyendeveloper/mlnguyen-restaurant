package com.mlnguyen.mlnguyenrestaurant.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "menu_item")
@Getter
@Setter
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private BigDecimal price;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name="active")
    private boolean active;

    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="category_id", nullable = false)
    private MenuCategory category;

    @Column(name="date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name="last_updated")
    @UpdateTimestamp
    private Date lastUpdated;

    @ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name="menu_add_ons",
            joinColumns = @JoinColumn(name="menu_item_id"),
            inverseJoinColumns = @JoinColumn(name="add_on_category_id"))
    private Set<AddOnCategory> addOnCategories;

    public MenuItem() {}

    public MenuItem(String name, String description, BigDecimal price, String imageUrl, boolean active, MenuCategory category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.active = active;
        this.setCategory(category);

        this.addOnCategories = new HashSet<>();
    }

    public void setCategory(MenuCategory menuCategory) {
        if (menuCategory != null) {
            this.category = menuCategory;

            menuCategory.add(this);
        }
    }

    public void add(AddOnCategory addOnCategory) {
        if (this.addOnCategories == null) {
            this.addOnCategories = new HashSet<>();
        }

        if (addOnCategory != null && !this.addOnCategories.contains(addOnCategory)){
            this.addOnCategories.add(addOnCategory);

            if (!addOnCategory.getMenuItems().contains(this)){
                addOnCategory.add(this);
            }
        }
    }
}
