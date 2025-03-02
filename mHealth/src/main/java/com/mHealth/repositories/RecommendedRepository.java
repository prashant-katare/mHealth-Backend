package com.mHealth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mHealth.entities.Recommended;

public interface RecommendedRepository extends JpaRepository<Recommended, Long> {

}
