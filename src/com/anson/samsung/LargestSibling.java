package com.anson.samsung;

/**
 * Created by chenzian on 8/4/16.
 */
public class LargestSibling {
    public static void main(String[] args) {
        LargestSibling largestSibling = new LargestSibling();
        int N = 213;
        System.out.println(largestSibling.findLargestSibling(N));
    }

    public int findLargestSibling(int N) {
        if (N < 0 || N > Integer.MAX_VALUE) {
            return -1;
        }
        String numStr = Integer.toString(N);
        int res = 0, digitLen = 10;
        int len = numStr.length();
        int[] count = new int[digitLen];
        for (int i = 0; i < len; i++) {
            int idx = Character.getNumericValue(numStr.charAt(i));
            System.out.println(i + " " + idx);
            count[idx]++;
        }
        for (int i = digitLen - 1; i >= 0; i--) {
            while (count[i] > 0) {
                res *= 10;
                res += i;
                if (res > 100000000) {
                    return -1;
                }
                count[i]--;
            }
        }
        return res;
    }
}
