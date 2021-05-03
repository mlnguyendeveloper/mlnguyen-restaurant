package com.mlnguyen.mlnguyenrestaurant.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
}
