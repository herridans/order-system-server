package com.sean.os.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sean.os.entities.Food;
import com.sean.os.repositories.FoodRepository;

@Service
public class FoodService implements IFoodService{

	@Autowired
	private FoodRepository repository;
	
	@Override
	public Food createFood(Food food) {
		return repository.save(food);
	}

	@Override
	public Food updateFood(Food food) {
		Food existingFood = repository.findById(food.getId()).get();
		if(existingFood == null)
		{
			throw new RuntimeException("Food not found");
		}
		existingFood.setName(food.getName());
		existingFood.setPrice(food.getPrice());
		existingFood.setDescription(food.getDescription());
		existingFood.setHidden(food.isHidden());
		existingFood.setFoodCategory(food.getFoodCategory());
		existingFood.setDisabledDescription(food.getDisabledDescription());
		existingFood.setDisabled(food.isDisabled());
		return repository.save(existingFood);
	}

	@Override
	public List<Food> getAllFood() {
		return repository.findAll();
	}

	@Override
	public List<Food> getFoodByCategoryId() {
		return null;
	}

	@Override
	public Food getFood(long id) {
		return repository.findById(id).get();
	}

	@Override
	public void deleteFood(long id) {
		repository.deleteById(id);
	}

}
