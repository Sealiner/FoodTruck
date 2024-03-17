package com.example.foodtruck.service;

import com.example.foodtruck.model.dto.SearchDto;
import com.example.foodtruck.model.vo.DataVo;

import java.util.List;

public interface DataService {
    List<DataVo> readAllData();
    List<DataVo> searchFoodItem(String foodItem);
}
