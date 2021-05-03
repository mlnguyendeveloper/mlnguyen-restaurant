package com.mlnguyen.mlnguyenrestaurant.dao;

import com.mlnguyen.mlnguyenrestaurant.entity.AddOnItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AddOnItemRepository extends JpaRepository<AddOnItem, Long> {
}
