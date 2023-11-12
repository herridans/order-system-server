package com.sean.oss.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sean.oss.entities.Food;
import com.sean.oss.models.CreateFoodModel;
import com.sean.oss.models.UpdateFoodModel;
import com.sean.oss.services.IFoodService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/food")
@Tag(name = "FoodController")
public class FoodController {

	@Autowired
	private IFoodService service;
	
	@GetMapping("/")
	public ResponseEntity<List<Food>> getAllFood(){
		return new ResponseEntity<>(service.getAllFoods(), HttpStatus.OK);
	}
	
	@GetMapping("/category/{id}")
	public ResponseEntity<List<Food>> getFoodByCategoryId(@PathVariable("id") String categoryId) {
		return new ResponseEntity<>(service.getFoodsByCategory(categoryId), HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Food> CreateFood(@RequestBody CreateFoodModel request) {
		return new ResponseEntity<>(service.createFood(request), HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<Food> UpdateFood(@RequestBody UpdateFoodModel request) {
		return new ResponseEntity<>(service.updateFood(request), HttpStatus.OK);
	}
	
	@DeleteMapping("/")
	public ResponseEntity<String> UpdateFood(@RequestParam String id) {
		service.deleteFood(id);
		return new ResponseEntity<>("Food deleted", HttpStatus.OK);
	}
}
