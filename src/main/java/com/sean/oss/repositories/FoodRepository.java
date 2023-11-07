package com.sean.oss.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.sean.oss.entities.Food;

public interface FoodRepository extends MongoRepository<Food, ObjectId> {
	Food findTopByOrderByIdDesc();
}
