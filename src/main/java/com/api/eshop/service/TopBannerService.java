package com.api.eshop.service;

import com.api.eshop.domain.TopBanner;
import com.api.eshop.repository.TopBannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopBannerService {
    @Autowired
    private TopBannerRepository repository;
    public TopBanner get()
    {
        return repository.findAll().get(0);
    }
}
