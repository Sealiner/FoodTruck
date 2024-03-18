package com.example.foodtruck.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ExcelUtil{
    public static <T> List<T> readExcel(InputStream excelInputStream, Class<T> clazz){
        ExcelListener<T> excelListener = new ExcelListener<>();
        ExcelReader excelReader = EasyExcel.read(excelInputStream, clazz, excelListener).build();
        if (excelReader == null){
            return new ArrayList<T>();
        }
        List<ReadSheet> readSheetList = excelReader.excelExecutor().sheetList();
        for (ReadSheet readSheet : readSheetList) {
            excelReader.read(readSheet);
        }
        excelReader.finish();
        return excelListener.getDataList();
    }
}

