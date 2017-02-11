package com.huaan.jmeasure.core;

/**
 * Created by Administrator on 2017/2/11 0011.
 * 使用策略模式实现性能测量，封装算法
 */
public abstract class Measure {
    private IAlgorithm algorithm;
    protected Result result;
    public void setAlgorithm(IAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void run()
    {
        result = algorithm.run();
    }

    public abstract String show();

}
