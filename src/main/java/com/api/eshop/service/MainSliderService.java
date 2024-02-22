package com.api.eshop.service;

import com.api.eshop.domain.MainSlider;
import com.api.eshop.repository.MainSliderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainSliderService {

    @Autowired
    private MainSliderRepository repository;

    public List<MainSlider> getImages()
    {
        return repository.findAll();
    }
}
