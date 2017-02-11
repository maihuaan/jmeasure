package com.huaan.jmeasure.core;

import java.util.ArrayList;
import java.util.List;

/**
 * 每种测试者的结果数据（对应一种比较结果）
 * Created by mai on 2017/2/11 0011.
 */
public class TesterData {
    private final String name;
    private List<Double> yValue = new ArrayList<Double>();

    public TesterData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Double> getyValue() {
        return yValue;
    }

    public void setyValue(List<Double> yValue) {
        this.yValue = yValue;
    }
}