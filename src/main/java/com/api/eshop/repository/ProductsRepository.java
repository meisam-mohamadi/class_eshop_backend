package com.api.eshop.repository;

import com.api.eshop.domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products , Long> {
    List<Products> findByIncredibleOffersIsTrue();
    List<Products> findByDailySuggestIsTrue();
    List<Products> findByKharideSareMahIsTrue();
    List<Products> findByJameJahaniIsTrue();
    List<Products> findByPishnahadeRoozeMobileIsTrue();
    List<Products> findByForoosheOmdehIsTrue();
    List<Products> findByKharideAghsatiIsTrue();
    List<Products> findByHarajestoonIsTrue();
    List<Products> findByDigiJetIsTrue();
    List<Products> findByNameContains(String searchText);
    Products findByName(String name);
}

