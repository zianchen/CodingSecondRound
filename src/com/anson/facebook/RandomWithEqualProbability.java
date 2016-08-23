package com.anson.facebook;

import java.util.Random;

/**
 * Created by chenzian on 8/23/16.
 */
public class RandomWithEqualProbability {

    public int myRand(int[] arr, int[] freq, Random random) {
        int[] sum = new int[freq.length];
        sum[0] = freq[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + freq[i];
        }
        //int r = (random.nextInt() % sum[sum.length - 1]) + 1;  这个写法只能保证random的生成1~sum[sum.length-1]的数字,而绝不能保证这个范围里数字的生成是等概率的
        int r = random.nextInt(sum[sum.length - 1]) + 1;
        int index = findCeil(sum, r);
        return arr[index];
    }

    //找到比r大的第一个上界,用binary search更快
    private int findCeil(int[] sum, int r) {
        int left = 0, right = sum.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (r > sum[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return sum[left] >= r ? left : -1;
    }
}
