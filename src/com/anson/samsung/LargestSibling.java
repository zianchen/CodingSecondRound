package com.anson.samsung;

/**
 * Created by chenzian on 8/4/16.
 */
public class LargestSibling {
    public static void main(String[] args) {
        LargestSibling largestSibling = new LargestSibling();
        int N = 23456712;
        System.out.println(largestSibling.findLargestSibling(N));
    }

    public int findLargestSibling(int N) {
        if (N < 0 || N > Integer.MAX_VALUE) {
            return -1;
        }
        String numStr = Integer.toString(N);
        int res = 0;
        int len = numStr.length();
        int[] count = new int[len];
        for (int i = 0; i < len; i++) {
            int idx = Character.getNumericValue(numStr.charAt(i));
            count[idx]++;
        }
        for (int i = len - 1; i >= 0; i--) {
            while (count[i] > 0) {
                res *= 10;
                res += i;
                if (res > 100000000) {
                    return -1;
                }
            }
        }
        return res;
    }
}
