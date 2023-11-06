package com.sean.os.services;

import java.util.List;

import com.sean.os.entities.Food;

public interface IFoodService {

	public Food createFood(Food food);
	public Food updateFood(Food food);
	public List<Food> getAllFood();
	public List<Food> getFoodByCategoryId();
	public Food getFood(long id);
	public void deleteFood(long id);
}
