package com.sean.os.services;

import java.util.List;

import com.sean.os.entities.FoodCategory;
import com.sean.os.models.CreateFoodCategoryModel;

public interface IFoodCategoryService {

	public FoodCategory createCategory(CreateFoodCategoryModel requestModel);
	public FoodCategory updateCategory(FoodCategory category);
	public List<FoodCategory> getAllCategories();
	public FoodCategory getCategory(long id);
	public void deleteCategory(long id);
}
