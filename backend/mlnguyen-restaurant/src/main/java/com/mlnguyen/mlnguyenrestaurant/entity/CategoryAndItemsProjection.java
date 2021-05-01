package com.mlnguyen.mlnguyenrestaurant.entity;

import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

@Projection(name="CategoryWithAllItems", types = {MenuCategory.class, MenuItem.class})
public interface CategoryAndItemsProjection {

    Long getId();
    String getCategoryName();
    String getDescription();
    Set<MenuItem> getMenuItems();
}
