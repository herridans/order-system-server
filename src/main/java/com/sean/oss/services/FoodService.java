package com.sean.oss.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sean.oss.entities.Food;
import com.sean.oss.entities.FoodCategory;
import com.sean.oss.models.CreateFoodModel;
import com.sean.oss.models.UpdateFoodModel;
import com.sean.oss.repositories.FoodRepository;

@Service
public class FoodService implements IFoodService {
	
	@Autowired
	private FoodRepository repository;
	
	@Autowired
	private IFoodCategoryService foodCategoryService;

	@Override
	public List<Food> getAllFoods() {
		return repository.findAll();
	}

	@Override
	public List<Food> getFoodsByCategory(String categoryId) {
		return repository.findByFoodCategoryId(categoryId);
	}

	@Override
	public Food getFood(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Food createFood(CreateFoodModel request) {
		FoodCategory existingCategory = foodCategoryService.getCategory(request.categoryId);
		
		if(existingCategory == null)
		{
			throw new RuntimeException("Category not found");
		}
		
		Food newFood = new Food();
		newFood.setName(request.name);
		newFood.setDescription(request.description);
		newFood.setPrice(request.price);
		newFood.setHidden(request.isHidden);
		newFood.setDisabled(request.isDisabled);
		newFood.setDisabledDescription(request.disabledDescription);
		newFood.setFoodCategory(existingCategory);
		return repository.save(newFood);
	}

	@Override
	public Food updateFood(UpdateFoodModel request) {
		Food existingFood = repository.findById(request.id).get();
		if(existingFood == null)
		{
			throw new RuntimeException("Food not found");
		}
		
		FoodCategory existingCategory = foodCategoryService.getCategory(request.categoryId);
		if(existingCategory == null)
		{
			throw new RuntimeException("Food category not found");
		}
		
		existingFood.setName(request.name);
		existingFood.setDescription(request.description);
		existingFood.setPrice(request.price);
		existingFood.setHidden(request.isHidden);
		existingFood.setDisabled(request.isDisabled);
		existingFood.setDisabledDescription(request.disabledDescription);
		existingFood.setFoodCategory(existingCategory);
		return repository.save(existingFood);
	}

	@Override
	public void deleteFood(String id) {
		repository.deleteById(id);
	}

}
