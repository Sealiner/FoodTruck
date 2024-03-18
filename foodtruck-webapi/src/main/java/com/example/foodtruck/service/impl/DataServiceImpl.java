package com.example.foodtruck.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.example.foodtruck.model.vo.DataVo;
import com.example.foodtruck.service.DataService;
import com.example.foodtruck.utils.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DataServiceImpl implements DataService {
    @Override
    public List<DataVo> readAllData() {
        List<DataVo> result = new ArrayList<>();
        try {
            ClassPathResource classpathResource = new ClassPathResource("data/dataset.csv");
            InputStream inputStream = classpathResource.getInputStream();
            result = ExcelUtil.readExcel(inputStream, DataVo.class);
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            return result;
        }
    }

    @Override
    public List<DataVo> searchFoodItem(String foodItem) {
        List<DataVo> result = new ArrayList<>();
        try {
            ClassPathResource classpathResource = new ClassPathResource("data/dataset.csv");
            InputStream inputStream = classpathResource.getInputStream();
            List<DataVo> allData = ExcelUtil.readExcel(inputStream, DataVo.class);
            String foodItemLowerCase = foodItem.toLowerCase();
            result = allData.stream().filter(d -> d.getFoodItems() != null && d.getFoodItems().toLowerCase().contains(foodItemLowerCase)).collect(Collectors.toList());
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            return result;
        }
    }
}
