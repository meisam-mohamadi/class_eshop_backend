package com.api.eshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("error500")
public class Error500Generator {

    @GetMapping
    @CrossOrigin("*")
    public ResponseEntity returnError500() throws Exception {
        throw  new Exception("this is a fake error , generated in server for test rest api !!!");
    }

}
