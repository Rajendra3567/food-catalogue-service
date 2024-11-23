package com.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.food.dto.FoodCataloguePage;
import com.food.dto.FoodItemDTO;
import com.food.dto.Restaurant;
import com.food.entity.FoodItem;
import com.food.mapper.FoodItemMapper;
import com.food.repo.FoodItemRepo;

@Service
public class FoodCatalogueService {

	@Autowired
	FoodItemRepo foodItemRepo;

	@Autowired
	RestTemplate restTemplate;

	public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {

		FoodItem savedFoodItem = foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO));
		return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDTO(savedFoodItem);
	}

	public FoodCataloguePage fetchFoodCataloguePageDetails(Integer restaurantId) {
		List<FoodItem> foodItemList = fetchFoodItemList(restaurantId);
		Restaurant restaurant = fetchRestaurantDetailsFromRestaurantMS(restaurantId);
		return createFoodCataloguePage(foodItemList, restaurant);
	}

	private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {
		FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
		foodCataloguePage.setFoodItemsList(foodItemList);
		foodCataloguePage.setRestaurant(restaurant);
		return foodCataloguePage;
	}

	private Restaurant fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId) {
		return restTemplate.getForObject("http://RESTAURANTSERVICE/restaurant/fetchById/"+restaurantId, Restaurant.class);
	}

	private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
		return foodItemRepo.findByRestaurantId(restaurantId);
	}

}
