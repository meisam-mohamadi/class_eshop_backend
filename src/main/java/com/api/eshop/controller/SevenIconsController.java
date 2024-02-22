package com.api.eshop.controller;

import com.api.eshop.service.SevenIconsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("SevenIcons")
public class SevenIconsController {

    @Autowired
    private SevenIconsService service;


    @GetMapping
    @CrossOrigin("*")
    public ResponseEntity getAll()
    {
        return new ResponseEntity(service.getAll(), HttpStatus.OK);
    }


}
