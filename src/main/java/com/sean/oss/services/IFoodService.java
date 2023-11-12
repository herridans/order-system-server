package com.sean.oss.services;

import java.util.List;

import com.sean.oss.entities.Food;
import com.sean.oss.models.CreateFoodModel;
import com.sean.oss.models.UpdateFoodModel;

public interface IFoodService {

	List<Food> getAllFoods();
	List<Food> getFoodsByCategory(String categoryId);
	Food getFood(String id);
	Food createFood(CreateFoodModel request);
	Food updateFood(UpdateFoodModel request);
	void deleteFood(String id);
}
