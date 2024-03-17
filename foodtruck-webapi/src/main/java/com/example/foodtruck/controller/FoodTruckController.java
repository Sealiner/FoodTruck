package com.example.foodtruck.controller;

import com.example.foodtruck.model.dto.SearchDto;
import com.example.foodtruck.model.vo.DataVo;
import com.example.foodtruck.model.vo.base.BaseVoWrapMapper;
import com.example.foodtruck.model.vo.base.BaseVoWrapper;
import com.example.foodtruck.service.DataService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/foodtruck")
public class FoodTruckController extends BaseController {
    @Autowired
    DataService dataService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @Operation(summary = "Get ALL food trucks data")
    public BaseVoWrapper<List<DataVo>> company() {
        return BaseVoWrapMapper.success(dataService.readAllData());
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @Operation(summary = "search food item")
    public BaseVoWrapper<List<DataVo>> search(@Valid @RequestBody SearchDto searchDto){
        if (searchDto.getFoodItem().equals("")) {
            return BaseVoWrapMapper.success(dataService.readAllData());
        }
        return BaseVoWrapMapper.success(dataService.searchFoodItem(searchDto.getFoodItem()));
    }
}
