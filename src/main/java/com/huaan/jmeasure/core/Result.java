package com.huaan.jmeasure.core;

import com.huaan.jmeasure.echarts.Legend;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by mai on 2017/2/11 0011.
 */
public class Result {
    private final String desc;

    /**
     * 所有的对比都是针对同一个横坐标的
     * map<Integer, String> 表示横坐标的值及其描述
     */
    private Map<Integer, String> xAxisMap = new TreeMap<Integer, String>();
    /**
     * 所有的对比结果，每一个series就是一个结果
     */
    private List<TesterData> testers = new ArrayList<TesterData>();

    public List<String> xAsisLabel()
    {
        List<String> labels = new ArrayList<String>();
        for (Map.Entry<Integer, String> entry : xAxisMap.entrySet())
        {
            labels.add(entry.getValue());
        }
        return labels;
    }
    public Result(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public List<TesterData> getTesters() {
        return testers;
    }

    public void setTesters(List<TesterData> testers) {
        this.testers = testers;
    }

    public Map<Integer, String> getxAxisMap() {
        return xAxisMap;
    }

    public void setxAxisMap(Map<Integer, String> xAxisMap) {
        this.xAxisMap = xAxisMap;
    }
}
