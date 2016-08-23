package com.anson.samsung.phoneandonsite;

/**
 * Created by chenzian on 8/15/16.
 */
public class GCDArray {

    public static void main(String[] args) {
        int[] arr = {3, 6, 9};
        GCDArray gcdArray = new GCDArray();
        int output = gcdArray.gcdofK(arr);
        System.out.println(output);
    }

    /*
     * 最大公约数的递归：
     * 1、若a可以整除b，则最大公约数是b
     * 2、如果1不成立，最大公约数便是b与a%b的最大公约数
     * 示例：求(140,21)
     * 140%21 = 14
     * 21%14 = 7
     * 14%7 = 0
     * 返回7
     *
     */
    public int gcdofK(int[] input) {
        if (input == null || input.length == 0) return -1;
        if (input.length == 1) return input[0];
        int result = input[0];
        for (int i = 1; i < input.length; i++) {
            result = gcdTwo(result, input[i]);
        }
        return result;
    }

    private int gcdTwo(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcdTwo(b, a % b);
    }
}
