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
        for (int i = 0; i < 64; i++) {
            boolean d = compareGrey(pixels[i], pixels[i + 1]);

//            //如果没有做灰度化，可比较每个色彩的差值，会相对更准确
//            boolean largerThanNext = compareRGB(pixels[i], pixels[i + 1]);

            if (d) {
                stringBuilder.append("1");
            } else {
                stringBuilder.append("0");
            }
        }
        return stringBuilder.toString();
    }

    private static boolean compareGrey(int current, int next) {
        if (current > next) {
            return true;
        }
        return false;
    }

    private static boolean compareRGB(int current, int next) {
        int result = 0;
        byte aRed = (byte) (current >> 16 & 0xFF);
        byte aGreen = (byte) (current >> 8 & 0xFF);
        byte aBlue = (byte) (current & 0xFF);

        byte bRed = (byte) (next >> 16 & 0xFF);
        byte bGreen = (byte) (next >> 8 & 0xFF);
        byte bBlue = (byte) (next & 0xFF);

        if (Math.abs(Math.abs(aRed) - Math.abs(bRed)) > 5) {
            result = result + 1;
        }
        if (Math.abs(Math.abs(aGreen) - Math.abs(bGreen)) > 5) {
            result = result + 1;
        }
        if (Math.abs(Math.abs(aBlue) - Math.abs(bBlue)) > 5) {
            result = result + 1;
        }
        return result >= 2;
    }

}
