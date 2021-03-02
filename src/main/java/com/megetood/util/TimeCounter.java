package com.megetood.util;

/**
 * 计时器
 *
 * @author chengdong.lei@hand-china.com 2020/08/22 20:43
 */
public class TimeCounter {
    private static final double NANO = 1000000000.0;

    private long startTime;
    private long endTime;
    private double time;

    // 记录开始时间
    public void start() {
        startTime = System.nanoTime();
    }

    // 记录结束时间
    public void end() {
        endTime = System.nanoTime();
    }

    // 计算时间差
    public TimeCounter between() {
        this.time = (endTime - startTime) / NANO;
        return this;
    }

    // 打印出时间差
    public void print() {
        System.out.println(getTime() + "s");
    }

    public void print(String str) {
        System.out.println(str + ": " + getTime() + "s");
    }

    // 获取时间差
    public double getTime() {
        return time;
    }
}
