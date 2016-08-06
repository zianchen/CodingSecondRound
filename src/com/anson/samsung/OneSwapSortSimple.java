package com.anson.samsung;

import java.util.Arrays;

/**
 * Created by chenzian on 8/4/16.
 */
public class OneSwapSortSimple {

    public static void main(String[] args) {
        int[] test = {1, 3, 5};
        OneSwapSortSimple os = new OneSwapSortSimple();
        System.out.println(os.oneSwapSortSimple(test));
    }

    public boolean oneSwapSortSimple(int[] arr) {
        int[] newArr = Arrays.copyOfRange(arr, 0, arr.length);
        Arrays.sort(newArr);
        int count = 0;
        for (int i = 0; i < newArr.length; i++) {
            if (newArr[i] != arr[i]) {
                count++;
            }
        }
        return (count == 0 || count == 2);
    }
}
