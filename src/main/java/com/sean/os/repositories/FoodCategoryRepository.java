package com.sean.os.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sean.os.entities.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {

}
