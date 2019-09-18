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

    public static String handle(int[] pixels) {
        int average = average(pixels);
        String result = binaryzation(pixels, average);
        return result;
    }

    public static int average(int[] pixels) {
        int sum = 0;
        for (int i = 0; i < pixels.length; i++) {
            sum += pixels[i];
        }
        int average = (Math.round(sum / pixels.length));
        return average;
    }

    private static String binaryzation(int[] pixels, int average) {
        StringBuilder stringBuilder = new StringBuilder();
        //遍历8*8像素点，记录与均值的大小关系，产生8*8=64个对比
        for (int i = 0; i < pixels.length; i++) {
            boolean d = Utils.compareGrey(pixels[i], average);

//            //如果没有做灰度化，可比较每个色彩的差值，会相对更准确
//            boolean largerThanNext = Utils.compareRGB(pixels[i], pixels[i + 1]);

            if (d) {
                stringBuilder.append("1");
            } else {
                stringBuilder.append("0");
            }
        }
        return stringBuilder.toString();
    }

}