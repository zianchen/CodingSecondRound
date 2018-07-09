package com.anson.util;

import java.util.List;
import java.util.Map;

/**
 * Created by chenzian on 6/17/16.
 */
public class Print {
    public static void printMatrix(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        for (int i = 0; i < m; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]+" ");
            }
        }
    }
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }

    public static void printArray(char[] arr) {
        for (char i : arr) {
            System.out.print(i + ", ");
        }
    }

    public static void printArray(Object[] arr) {
        for (Object i : arr) {
            System.out.print(i + ", ");
        }
    }
    public static void printOneDList(List<Integer> oList) {
        for (int i = 0; i < oList.size(); i++) {
            System.out.print(oList.get(i) + " ");
        }
        System.out.println();
    }
    public static void printOneDListStr(List<String> oList) {
        for (int i = 0; i < oList.size(); i++) {
            System.out.print(oList.get(i) + " ");
        }
        System.out.println();
    }
    public static void printtwoDList(List<List<Integer>> twoList) {
        for (int i = 0; i < twoList.size(); i++) {
            List<Integer> oneList = twoList.get(i);
            for (int j = 0; j < oneList.size(); j++) {
                System.out.print(oneList.get(j) + " ");
            }
            System.out.println();
        }
    }
    public static void printHashMap(Map<Integer, List<Integer>> map) {
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            printOneDList(list);
        }
    }
}
