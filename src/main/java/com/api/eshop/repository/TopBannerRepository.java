package com.api.eshop.repository;

import com.api.eshop.domain.TopBanner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopBannerRepository extends JpaRepository<TopBanner, Integer> {
}
