package com.sean.os.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sean.os.entities.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {

}
