package com.api.eshop.service;

import com.api.eshop.domain.Products;
import com.api.eshop.domain.utilities.FileUploadResponse;
import com.api.eshop.repository.ProductsRepository;
import com.api.eshop.service.utilities.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository repository;

    @Autowired
    private FileStorageService fileStorageService;

    public List<Products> getAll() {
        return repository.findAll();
    }


    public List<Products> getAllIncredibleOffers() {
        return repository.findByIncredibleOffersIsTrue();
    }

    public List<Products> getAllDailySuggests() {
        return repository.findByDailySuggestIsTrue();
    }

    public Products getById(long id) {
        return repository.findById(id).get();

    }

    public List<Products> searchProducts(String textToSearch) {
        return repository.findByNameContains(textToSearch);
    }

    public  Products getByName(String name)
    {
        return repository.findByName(name);
    }

    public List<Products> getKharideSareMahProducts() {
        return repository.findByKharideSareMahIsTrue();
    }

    public List<Products> getJameJahaniProducts() {
        return repository.findByJameJahaniIsTrue();
    }

    public List<Products>  getPishnahadeRoozeMobileProducts() {
        return repository.findByPishnahadeRoozeMobileIsTrue();
    }

    public List<Products> getForoosheOmdehProducts() {
        return repository.findByForoosheOmdehIsTrue();

    }

    public List<Products> getKharideAghsatiProducts() {
        return repository.findByKharideAghsatiIsTrue();

    }

    public  List<Products> getHarajestoonProducts() {
        return repository.findByHarajestoonIsTrue();

    }

    public  List<Products> getDigiJetProducts() {
        return repository.findByDigiJetIsTrue();
    }

    public Products save(Products product, MultipartFile file) {

        FileUploadResponse fileUploadResponse = fileStorageService.storeFile(file);


        try {
            product.setIndexImageUrl("http://localhost:9090"+fileUploadResponse.getUrl());
            return repository.save(product);
        } catch (Exception e) {

            System.out.println(e.getMessage());
            return null;
        }
    }
}
