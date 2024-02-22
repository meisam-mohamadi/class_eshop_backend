package com.api.eshop.repository;

import com.api.eshop.domain.SevenIcons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeveIconsRepository extends JpaRepository<SevenIcons , Integer> {
}
