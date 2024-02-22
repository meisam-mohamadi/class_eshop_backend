package com.api.eshop.service;

import com.api.eshop.domain.ProductsCategories;
import com.api.eshop.repository.ProductsCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsCategoriesService {
    @Autowired
    private ProductsCategoriesRepository repository;
    public List<ProductsCategories> getAll()
    {
        return repository.findAll();
    }
    public ProductsCategories getByName(String categoryName)
    {
        return repository.findByName(categoryName);
    }
}
