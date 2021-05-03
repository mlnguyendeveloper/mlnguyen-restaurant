package com.mlnguyen.mlnguyenrestaurant.dao;


import com.mlnguyen.mlnguyenrestaurant.entity.AddOnCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "addOnCategory", path="add-on-categories")
public interface AddOnCategoryRepository extends JpaRepository<AddOnCategory, Long> {
}
