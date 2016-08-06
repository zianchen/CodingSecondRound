package com.anson.samsung;

/**
 * Created by chenzian on 8/4/16.
 */
public class OneSwapSort {

    public static boolean oneSwapCanSort(int[] input) {
        if (input == null || input.length == 0) {
            return false;
        }
        int small = -1, big = -1;
        int len = input.length;
        int i = len - 1;
        while (i > 0) {
            if (input[i] < input[i - 1]) {
                small = i;
                break;
            }
            i--;
        }
        if (i == 0) {
            return true;
        }
        for (int j = 0; j < len - 1; j++) {
            if (input[j] > input[j + 1]) {
                big = j;
                break;
            }
        }
        if (small == -1 || big == -1) {
            return false;
        } else {
            swap(input, big, small);
        }
        for (int k = 0; k < len - 1; k++) {
            if (input[k] > input[k + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void swap(int[] input, int x, int y) {
        int temp = input[x];
        input[x] = input[y];
        input[y] = temp;
    }

    public static void main(String[] args) {
        int[] test = {1, 8, 3, 7, 5, 6};
        System.out.println(oneSwapCanSort(test));
    }
}
