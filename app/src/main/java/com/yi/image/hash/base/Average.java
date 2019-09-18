package com.yi.image.hash.base;

/**
 * ---------------------------------------------------------------
 *
 * @author ZhaoYidong
 * ---------------------------------------------------------------
 * Create: 2019-09-18 10:09
 * ---------------------------------------------------------------
 * Describe:计算平均值
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 */
public class Average {

    public static int handle(int[] pixels) {
        long sum = 0;
        // 将数组元素转为无符号整数
        for (int i = 0; i < pixels.length; i++) {
            sum += (long) pixels[i] & 0xff;
        }
        int average = (Math.round(sum / pixels.length));
        return average;
    }

}