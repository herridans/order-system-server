package com.sean.os.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sean.os.entities.FoodCategory;
import com.sean.os.models.CreateFoodCategoryModel;
import com.sean.os.repositories.FoodCategoryRepository;

@Service
public class FoodCategoryService implements IFoodCategoryService{

	@Autowired
	private FoodCategoryRepository repository;
	
	@Override
	public FoodCategory createCategory(CreateFoodCategoryModel requestModel) {
		FoodCategory newCategory = new FoodCategory();
		newCategory.setName(requestModel.name);
		newCategory.setHidden(requestModel.isHidden);
		return repository.save(newCategory);
	}

	@Override
	public FoodCategory updateCategory(FoodCategory category) {
		FoodCategory existingCategory = repository.findById(category.getId()).get();
		if(existingCategory == null)
		{
			throw new RuntimeException("Category not found");
		}
		existingCategory.setName(category.getName());
		existingCategory.setHidden(category.isHidden());
		return repository.save(existingCategory);
	}

	@Override
	public List<FoodCategory> getAllCategories() {
		return repository.findAll();
	}

	@Override
	public FoodCategory getCategory(long id) {
		return repository.findById(id).get();
	}

	@Override
	public void deleteCategory(long id) {
		repository.deleteById(id);
	}

}
