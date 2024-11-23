package com.food.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.food.dto.FoodItemDTO;
import com.food.entity.FoodItem;

@Mapper
public interface FoodItemMapper {
	
	FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);
	
	FoodItem mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO);
	
	FoodItemDTO mapFoodItemToFoodItemDTO(FoodItem foodItem);

}
