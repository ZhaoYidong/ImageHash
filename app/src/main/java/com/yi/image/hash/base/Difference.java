package com.yi.image.hash.base;


/**
 * ---------------------------------------------------------------
 *
 * @author ZhaoYidong
 * ---------------------------------------------------------------
 * Create: 2019-08-12 16:10
 * ---------------------------------------------------------------
 * Describe:计算灰度差值
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 */
public class Difference {

    public static String handle(int[] pixels) {
        StringBuilder stringBuilder = new StringBuilder();
        //遍历9*8像素点，记录相邻像素之间的大小关系，产生8*8=64个对比
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boolean d = Utils.compareGrey(pixels[9 * j + i], pixels[9 * j + i + 1]);

//                //如果没有做灰度化，可比较每个色彩的差值，会相对更准确
//                boolean largerThanNext = Utils.compareRGB(pixels[i], pixels[i + 1]);

                if (d) {
                    stringBuilder.append("1");
                } else {
                    stringBuilder.append("0");
                }
            }
        }


        return stringBuilder.toString();
    }



}
