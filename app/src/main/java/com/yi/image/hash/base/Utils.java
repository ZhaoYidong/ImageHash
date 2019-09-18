package com.yi.image.hash.base;

import android.graphics.Bitmap;

/**
 * ---------------------------------------------------------------
 *
 * @author ZhaoYidong
 * ---------------------------------------------------------------
 * Create: 2019-08-12 16:02
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 */
public class Utils {

    public static int[] bitmap2intArray(Bitmap bitmap) {
        //获取位图的宽
        int width = bitmap.getWidth();
        //获取位图的高
        int height = bitmap.getHeight();
        //通过位图的大小创建像素点数组
        int[] pixels = new int[width * height];
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height);
        return pixels;
    }

    public static Bitmap intArray2bitmap(int[] pixels, int width, int height) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        return bitmap;
    }

    /**
     * 汉明距离
     */
    public static int hammingDistance(String s1, String s2) {
        int counter = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                counter++;
            }
        }
        return counter;
    }

    public static boolean compareGrey(int current, int next) {
        if (current > next) {
            return true;
        }
        return false;
    }

    public static boolean compareRGB(int current, int next) {
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
