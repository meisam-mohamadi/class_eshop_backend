package com.api.eshop.service;

import com.api.eshop.domain.SevenIcons;
import com.api.eshop.repository.SeveIconsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SevenIconsService {
    @Autowired
    private SeveIconsRepository repository;

    public List<SevenIcons> getAll()
    {
        return repository.findAll();
    }
}
