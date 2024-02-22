package com.api.eshop.service;

import com.api.eshop.domain.HeaderBanner;
import com.api.eshop.repository.HeaderBannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeaderBannerService {
    @Autowired
    private HeaderBannerRepository repository;

    public HeaderBanner getBanner()
    {
        return repository.findById(1).get();
    }
}
