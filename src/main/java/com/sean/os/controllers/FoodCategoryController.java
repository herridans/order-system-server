package com.sean.os.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sean.os.entities.FoodCategory;
import com.sean.os.models.CreateFoodCategoryModel;
import com.sean.os.services.IFoodCategoryService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/category")
@Tag(name = "FoodCategoryController")
public class FoodCategoryController {

	@Autowired
	private IFoodCategoryService foodService;
	
	@GetMapping
	public ResponseEntity<List<FoodCategory>> getAllCategories() {
		return new ResponseEntity<List<FoodCategory>>(foodService.getAllCategories(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<FoodCategory> createCategory(@RequestBody CreateFoodCategoryModel requestModel) {
		FoodCategory newCategory = foodService.createCategory(requestModel);
		return new ResponseEntity<FoodCategory>(newCategory, HttpStatus.OK);
	}
}
