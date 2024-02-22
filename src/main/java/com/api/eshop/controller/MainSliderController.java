package com.api.eshop.controller;

import com.api.eshop.service.MainSliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("public/mainSlider")
public class MainSliderController {

    @Autowired
    private MainSliderService service;

    @GetMapping
    public ResponseEntity getAllSlides()
    {
        return new ResponseEntity(service.getImages() , HttpStatus.OK);
    }
}
