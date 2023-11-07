package com.sean.oss.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sean.oss.entities.FoodCategory;

public interface FoodCategoryRepository extends MongoRepository<FoodCategory, String>{
	FoodCategory findTopByOrderByIdDesc();
}
