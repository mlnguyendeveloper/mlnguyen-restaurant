package com.mlnguyen.mlnguyenrestaurant.dao;

import com.mlnguyen.mlnguyenrestaurant.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
