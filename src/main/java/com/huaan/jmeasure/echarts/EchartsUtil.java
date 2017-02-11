package com.huaan.jmeasure.echarts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by mai on 2017/2/11 0011.
 */
public class EchartsUtil {
    public static String OptionToJson(Option option)
    {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(option);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
