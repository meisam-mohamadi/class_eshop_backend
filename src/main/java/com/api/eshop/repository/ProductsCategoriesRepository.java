package com.api.eshop.repository;

import com.api.eshop.domain.ProductsCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsCategoriesRepository extends JpaRepository<ProductsCategories, Integer> {
    ProductsCategories findByName(String categoryName);
}
