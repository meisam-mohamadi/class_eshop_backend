package com.api.eshop.repository;

import com.api.eshop.domain.MainSlider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainSliderRepository extends JpaRepository<MainSlider , Long> {
}
