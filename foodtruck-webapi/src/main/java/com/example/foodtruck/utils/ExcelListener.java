package com.example.foodtruck.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ExcelListener<T> extends AnalysisEventListener<T> {
    private List<T> dataList = new ArrayList<>();

    @Override
    public void invoke(T data, AnalysisContext context) {
        dataList.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
    }

    public List<T> getDataList() {
        return dataList;
    }
}
