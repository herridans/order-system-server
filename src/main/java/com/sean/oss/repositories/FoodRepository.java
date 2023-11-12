package com.sean.oss.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sean.oss.entities.Food;

public interface FoodRepository extends MongoRepository<Food, String> {
	List<Food> findByFoodCategoryId(String categoryId);
}
