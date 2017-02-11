package com.huaan.jmeasure.echarts;

import com.huaan.jmeasure.core.MapMultilThreadAlgorithm;
import com.huaan.jmeasure.core.Result;
import org.junit.Test;

/**
 * Created by mai on 2017/2/11 0011.
 */
public class MapMultilThreadAlgorithmTest {
    @Test
    public void testRun()
    {
        MapMultilThreadAlgorithm alg = new MapMultilThreadAlgorithm();
        Result r = alg.run();
        System.out.println(r);
    }
}
