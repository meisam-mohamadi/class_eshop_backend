package com.api.eshop.controller;

import com.api.eshop.service.TopBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topBanner")
public class TopBannerController {
    @Autowired
    private TopBannerService service;

    @GetMapping
    @CrossOrigin("*")
    public ResponseEntity get()
    {
        return new ResponseEntity(service.get() , HttpStatus.OK);
    }
}
