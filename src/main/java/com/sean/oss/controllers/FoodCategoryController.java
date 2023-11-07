package com.sean.oss.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sean.oss.entities.FoodCategory;
import com.sean.oss.models.CreateFoodCategoryModel;
import com.sean.oss.models.UpdateFoodCategoryModel;
import com.sean.oss.services.IFoodCategoryService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/category")
@Tag(name = "FoodCategoryController")
public class FoodCategoryController {

	@Autowired
	private IFoodCategoryService service;
	
	@GetMapping("/")
	public ResponseEntity<List<FoodCategory>> getAllCategories(){
		return new ResponseEntity<>(service.getAllCategories(), HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> createCategory(@RequestBody CreateFoodCategoryModel request) {
		service.createCategory(request);
		return new ResponseEntity<>("Category created", HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateCategory(@RequestBody UpdateFoodCategoryModel request) {
		service.updateCategory(request);
		return new ResponseEntity<>("Category updated", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteCategory(@RequestParam String id) {
		service.deleteCategory(id);
		return new ResponseEntity<>("Category deleted", HttpStatus.OK);
	}
}
