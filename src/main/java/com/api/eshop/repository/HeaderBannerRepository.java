package com.api.eshop.repository;

import com.api.eshop.domain.HeaderBanner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeaderBannerRepository extends JpaRepository<HeaderBanner, Integer> {
}
