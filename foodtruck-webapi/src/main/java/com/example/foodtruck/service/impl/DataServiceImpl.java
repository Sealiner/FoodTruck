package com.example.foodtruck.service.impl;

import com.alibaba.excel.EasyExcel;
import com.example.foodtruck.model.vo.DataVo;
import com.example.foodtruck.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DataServiceImpl implements DataService {


    @Override
    public List<DataVo> readAllData() {
        String fileName = this.getClass().getClassLoader().getResource("data/dataset.csv").getPath();
        List<DataVo> list = EasyExcel.read(fileName).head(DataVo.class).sheet().doReadSync();
        return list;
    }

    @Override
    public List<DataVo> searchFoodItem(String foodItem) {
        String fileName = this.getClass().getClassLoader().getResource("data/dataset.csv").getPath();
        List<DataVo> allData = EasyExcel.read(fileName).head(DataVo.class).sheet().doReadSync();
        String foodItemLowerCase = foodItem.toLowerCase();
        List<DataVo> result = allData.stream().filter(d->d.getFoodItems()!=null && d.getFoodItems().toLowerCase().contains(foodItemLowerCase)).collect(Collectors.toList());
        return result;
    }
}
