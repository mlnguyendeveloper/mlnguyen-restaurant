package com.mlnguyen.mlnguyenrestaurant.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="add_on_item")
@Getter
@Setter
public class AddOnItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    private String name;

    @Column(name="price")
    private BigDecimal price;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "active")
    private boolean active;

    @ManyToOne
    @JoinColumn(name="add_on_category_id", nullable = false)
    private AddOnCategory category;

    public AddOnItem() {}

    public AddOnItem(String name, BigDecimal price, String imageUrl, boolean active) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.active = active;
    }

    public AddOnItem(String name, BigDecimal price, String imageUrl, boolean active, AddOnCategory category) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.active = active;
        this.setCategory(category);
    }

    public void setCategory(AddOnCategory addOnCategory) {
        this.category = addOnCategory;

        addOnCategory.add(this);
    }
}
