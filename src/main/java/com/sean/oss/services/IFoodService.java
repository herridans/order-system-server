package com.sean.oss.services;

import java.util.List;

import com.sean.oss.entities.Food;

public interface IFoodService {

	List<Food> getAllFoods();
	Food getFood(long id);
	Food createFood();
	Food updateFood();
	void deleteFood(long id);
}
