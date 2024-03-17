package com.example.foodtruck.model.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class DataVo {
    @ExcelProperty("locationid")
    private String locationId;

    @ExcelProperty("Applicant")
    private String applicant;

    @ExcelProperty("FacilityType")
    private String facilityType;

    @ExcelProperty("LocationDescription")
    private String locationDescription;

    @ExcelProperty("Address")
    private String address;

    @ExcelProperty("Status")
    private String status;

    @ExcelProperty("FoodItems")
    private String foodItems;

    @ExcelProperty("Latitude")
    private Double latitude;

    @ExcelProperty("Longitude")
    private Double longitude;

    @ExcelProperty("daysHours")
    private String daysHours;

    @ExcelProperty("ExpirationDate")
    private String expirationDate;
}
