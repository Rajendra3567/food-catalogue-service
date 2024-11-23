package com.food.dto;

import java.util.List;

import com.food.entity.FoodItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodCataloguePage {

	private List<FoodItem> foodItemsList;
	private Restaurant restaurant;
	
	public List<FoodItem> getFoodItemsList() {
		return foodItemsList;
	}
	public void setFoodItemsList(List<FoodItem> foodItemsList) {
		this.foodItemsList = foodItemsList;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	
}
