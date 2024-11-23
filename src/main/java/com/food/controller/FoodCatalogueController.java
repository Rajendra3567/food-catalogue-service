package com.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.dto.FoodCataloguePage;
import com.food.dto.FoodItemDTO;
import com.food.service.FoodCatalogueService;

@RestController
@RequestMapping("/foodCatalogue")
public class FoodCatalogueController {
	
	@Autowired
	FoodCatalogueService foodCatalogueService;
	
	// create FoodItem
	@PostMapping("/addFoodItems")
	private ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO foodItemDTO){
		
	  FoodItemDTO foodItem = foodCatalogueService.addFoodItem(foodItemDTO);
	  return new ResponseEntity<>(foodItem, HttpStatus.CREATED);
	}
	
	// List all foodItems for a particular restaurant with restaurantId
	@GetMapping("/fetchRestaurantAndFoodItemsById/{restaurantId}")
	public ResponseEntity<FoodCataloguePage> fetchRestaurantDetailsWithFoodMenu(@PathVariable Integer restaurantId) {
		
			FoodCataloguePage foodCataloguePage = foodCatalogueService.fetchFoodCataloguePageDetails(restaurantId);
		return new ResponseEntity<>(foodCataloguePage, HttpStatus.OK);
	}

}
