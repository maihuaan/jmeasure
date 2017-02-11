package com.huaan.jmeasure.echarts;

import static org.junit.Assert.*;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

public class EchartsUtilTest {
	@Test
	public void testOptionToJson() {
		Title title = new Title();
		title.setText("abc");
		XAxis xAxis = new XAxis();
		xAxis.setType("category");
		xAxis.setData(Arrays.asList("周一", "周二", "周三", "周四", "周五", "周六", "周日"));
        YAxis yAxis = new YAxis();
        yAxis.setType("value");

        Series series1 = new Series();
        series1.setType("line");
        series1.setName("成交");
        series1.setSmooth(true);
        //series1.setData(Arrays.asList(10, 12, 21, 54, 260, 830, 710));

		Option option = new Option();
		option.setTitle(title);
		option.setxAxis(xAxis);
		option.setyAxis(yAxis);
		option.setSeries(Arrays.asList(series1));

		System.out.println(EchartsUtil.OptionToJson(option));

	}

}
