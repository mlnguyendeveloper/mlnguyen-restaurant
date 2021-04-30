package com.mlnguyen.mlnguyenrestaurant.dao;

import com.mlnguyen.mlnguyenrestaurant.entity.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "menuCategory", path="menu-categories")
public interface MenuCategoryRepository extends JpaRepository<MenuCategory, Long> {
}
