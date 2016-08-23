package com.anson.facebook;

import java.util.Random;

/**
 * Created by chenzian on 8/23/16.
 */
public class RandomWithEqualProbability {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        int[] freq = {2, 3, 1};
        RandomWithEqualProbability randomEqual = new RandomWithEqualProbability();
        for (int i = 0; i < 6; i++) {
            System.out.println(randomEqual.myRand(arr, freq));
        }
    }

    public int myRand(int[] arr, int[] freq) {
        int[] sum = new int[freq.length];
        sum[0] = freq[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + freq[i];
        }
        Random random = new Random();
        int r = (random.nextInt() % sum[sum.length - 1]) + 1;
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
