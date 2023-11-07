package com.sean.oss.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sean.oss.entities.FoodCategory;
import com.sean.oss.models.CreateFoodCategoryModel;
import com.sean.oss.models.UpdateFoodCategoryModel;
import com.sean.oss.repositories.FoodCategoryRepository;

@Service
public class FoodCategoryService implements IFoodCategoryService {

	@Autowired
	private FoodCategoryRepository repository;
	
	@Override
	public List<FoodCategory> getAllCategories() {
		return repository.findAll();
	}

	@Override
	public FoodCategory getCategory(String id) {
		return repository.findById(id).get();
	}

	@Override
	public FoodCategory createCategory(CreateFoodCategoryModel request) {
		FoodCategory newCategory = new FoodCategory();
		newCategory.setName(request.name);
		newCategory.setDescription(request.description);
		newCategory.setHidden(request.isHidden);
		return repository.save(newCategory);
	}

	@Override
	public FoodCategory updateCategory(UpdateFoodCategoryModel request) {
		FoodCategory existingCategory = repository.findById(request.id).get();
		if(existingCategory == null)
		{
			return null;
		}
		existingCategory.setName(request.name);
		existingCategory.setDescription(request.description);
		existingCategory.setHidden(request.isHidden);
		return repository.save(existingCategory);
	}

	@Override
	public void deleteCategory(String id) {
		FoodCategory existingCategory = repository.findById(id).get();
		if(existingCategory == null)
		{
			throw new RuntimeException("Category not found");
		}
		repository.deleteById(id);
	}

}
