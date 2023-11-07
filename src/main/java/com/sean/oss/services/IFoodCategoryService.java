package com.sean.oss.services;

import java.util.List;

import com.sean.oss.entities.FoodCategory;
import com.sean.oss.models.CreateFoodCategoryModel;
import com.sean.oss.models.UpdateFoodCategoryModel;

public interface IFoodCategoryService {

	List<FoodCategory> getAllCategories();
	FoodCategory getCategory(String id);
	FoodCategory createCategory(CreateFoodCategoryModel request);
	FoodCategory updateCategory(UpdateFoodCategoryModel request);
	void deleteCategory(String id);
}
