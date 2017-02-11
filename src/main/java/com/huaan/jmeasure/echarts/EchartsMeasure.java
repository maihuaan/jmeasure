package com.huaan.jmeasure.echarts;

import com.huaan.jmeasure.core.Measure;
import com.huaan.jmeasure.core.TesterData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mai on 2017/2/11 0011.
 * Echarts 测量显示类
 */
public class EchartsMeasure extends Measure {
    public String show()
    {
        return buildEchartsOption();
    }

    private String buildEchartsOption() {
        Title title = new Title();
        title.setText(result.getDesc());
        XAxis xAxis = new XAxis();
        xAxis.setType("category");
        // 横坐标的label
        xAxis.setData(result.xAsisLabel());

        YAxis yAxis = new YAxis();
        yAxis.setType("value");

        List<TesterData> testers = result.getTesters();
        List<Series> series = new ArrayList<Series>();
        List<String> legendNames = new ArrayList<String>();
        // 每一个测试者的纵坐标
        for (TesterData td : testers)
        {
            Series s = new Series();
            s.setType("line");
            s.setName(td.getName());
            s.setSmooth(true);
            s.setData(td.getyValue());
            series.add(s);
            legendNames.add(td.getName());
        }
        Legend legend = new Legend();
        legend.setData(legendNames);

        Option option = new Option();
        option.setTitle(title);
        option.setxAxis(xAxis);
        option.setyAxis(yAxis);
        option.setSeries(series);
        option.setLegend(legend);
        return EchartsUtil.OptionToJson(option);

    }
}
