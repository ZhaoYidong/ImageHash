package com.yi.image.hash;

import android.graphics.Bitmap;

import com.yi.image.hash.base.ConvertGrey;
import com.yi.image.hash.base.Difference;
import com.yi.image.hash.base.Resize;
import com.yi.image.hash.base.Utils;

/**
 * ---------------------------------------------------------------
 *
 * @author ZhaoYidong
 * ---------------------------------------------------------------
 * Create: 2019-08-12 16:06
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 */
public class Handler {

    public static int calculateByDHash(Bitmap bitmap1, Bitmap bitmap2) {
        String hash1 = getDHashByCommon(bitmap1);
        String hash2 = getDHashByCommon(bitmap2);
        int result = Utils.hammingDistance(hash1, hash2);
        return result;
    }

    private static String getDHashByCommon(Bitmap bitmap) {
        //获取图片数组
        int[] p = Utils.bitmap2intArray(bitmap);
        //缩小尺寸
        p = Resize.handleByCommon(p, bitmap.getWidth(), bitmap.getHeight(), 9, 8);
        //灰度化
        p = ConvertGrey.handle(p, 9, 8);
        //计算灰度差值
        String result = Difference.handle(p);
        return result;
    }

    private static String getDHashByAndroid(Bitmap bitmap) {
        Bitmap b = Resize.handleByAndroid(bitmap, 9, 8);
        int[] p = Utils.bitmap2intArray(b);
        p = ConvertGrey.handle(p, 9, 8);
        String result = Difference.handle(p);
        return result;
    }

}
