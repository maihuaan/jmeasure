package com.huaan.jmeasure.echarts;

import java.util.List;

/**
 * Created by mai on 2017/2/11 0011.
 */
public class Series {
    private String name;
    private String type;
    private boolean smooth;
    private List<Double> data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isSmooth() {
        return smooth;
    }

    public void setSmooth(boolean smooth) {
        this.smooth = smooth;
    }

    public List<Double> getData() {
        return data;
    }

    public void setData(List<Double> data) {
        this.data = data;
    }
}
