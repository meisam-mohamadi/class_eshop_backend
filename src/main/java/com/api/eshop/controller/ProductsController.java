package com.api.eshop.controller;

import com.api.eshop.domain.Products;
import com.api.eshop.domain.ProductsCategories;
import com.api.eshop.repository.ProductsRepository;
import com.api.eshop.service.ProductsCategoriesService;
import com.api.eshop.service.ProductsService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductsController {


    @Autowired
    private ProductsService service;

    @Autowired
    private ProductsCategoriesService productsCategoriesService;
    @Autowired
    private ProductsRepository productsRepository;

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity save(@RequestParam String data, @RequestParam MultipartFile[] files) {

        Products product = new Gson().fromJson(data, Products.class);

        Products result = service.save(product, files[0]);
        return new ResponseEntity(result, HttpStatus.OK);


    }

    @GetMapping
    @CrossOrigin("*")
    public ResponseEntity getAll() {
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        List<Products> result = service.getAll();
        for (Products product : result) {
            product.getImages().size();
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("{id}")
    @CrossOrigin("*")
    public ResponseEntity getById(@PathVariable long id) {
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        Products result = service.getById(id);
        if (result != null) {
            result.getImages().size();
            return new ResponseEntity(result, HttpStatus.OK);
        } else
            return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
    }


    @GetMapping("name/{name}")
    @CrossOrigin("*")
    public ResponseEntity getById(@PathVariable String name) {
        Products result = service.getByName(name);
        if (result != null) {
            result.getImages().size();
            return new ResponseEntity(result, HttpStatus.OK);
        } else
            return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("incredibleOffers")
    @CrossOrigin("*")
    public ResponseEntity getAllIncredibleOffers() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity(service.getAllIncredibleOffers(), HttpStatus.OK);
    }

    @GetMapping("categories")
    @CrossOrigin("*")
    public ResponseEntity getAllCategories() {
        List<ProductsCategories> result = productsCategoriesService.getAll();
        for (ProductsCategories item : result) {
            item.getProducts().size();
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("dailySuggests")
    @CrossOrigin("*")
    public ResponseEntity getAllDailySuggests() {
        List<Products> result = service.getAllDailySuggests();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("search/{textToSearch}")
    @CrossOrigin("*")
    public ResponseEntity getAllDailySuggests(@PathVariable String textToSearch) {
        List<Products> result = service.searchProducts(textToSearch);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("category/{categoryName}")
    @CrossOrigin("*")
    public ResponseEntity getProductsByCategoryName(@PathVariable String categoryName) {

        ProductsCategories result = productsCategoriesService.getByName(categoryName);
        try {
            result.getProducts().size();
        } catch (Exception e) {

        }
        return new ResponseEntity(result, HttpStatus.OK);
    }


    @GetMapping("KharideSareMah")
    public ResponseEntity getKharideSareMahProducts() {
        return new ResponseEntity(service.getKharideSareMahProducts(), HttpStatus.OK);
    }

    @GetMapping("JameJahani")
    public ResponseEntity getJameJahaniProducts() {
        return new ResponseEntity(service.getJameJahaniProducts(), HttpStatus.OK);
    }

    @GetMapping("PishnahadeRoozeMobile")
    public ResponseEntity getPishnahadeRoozeMobileProducts() {
        return new ResponseEntity(service.getPishnahadeRoozeMobileProducts(), HttpStatus.OK);
    }

    @GetMapping("ForoosheOmdeh")
    public ResponseEntity getForoosheOmdehProducts() {
        return new ResponseEntity(service.getForoosheOmdehProducts(), HttpStatus.OK);
    }

    @GetMapping("KharideAghsati")
    public ResponseEntity getKharideAghsatiProducts() {
        return new ResponseEntity(service.getKharideAghsatiProducts(), HttpStatus.OK);
    }

    @GetMapping("Harajestoon")
    public ResponseEntity getHarajestoonProducts() {
        return new ResponseEntity(service.getHarajestoonProducts(), HttpStatus.OK);
    }

    @GetMapping("DigiJet")
    public ResponseEntity getDigiJetProducts() {
        return new ResponseEntity(service.getDigiJetProducts(), HttpStatus.OK);
    }
}
