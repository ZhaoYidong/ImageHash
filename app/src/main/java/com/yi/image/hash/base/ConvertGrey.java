package com.yi.image.hash.base;


/**
 * ---------------------------------------------------------------
 *
 * @author ZhaoYidong
 * ---------------------------------------------------------------
 * Create: 2019-08-12 15:22
 * ---------------------------------------------------------------
 * Describe:灰度化
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 */
public class ConvertGrey {

    public static int[] handle(int[] pixels, int width, int height) {
        int[] result = new int[pixels.length];
        int alpha = 0xFF << 24;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int grey = pixels[width * i + j];

                int red = ((grey & 0x00FF0000) >> 16);
                int green = ((grey & 0x0000FF00) >> 8);
                int blue = (grey & 0x000000FF);

                grey = (int) (red * 0.3 + green * 0.59 + blue * 0.11);
                grey = alpha | (grey << 16) | (grey << 8) | grey;
                result[width * i + j] = grey;
            }
        }
        return result;
    }

}
