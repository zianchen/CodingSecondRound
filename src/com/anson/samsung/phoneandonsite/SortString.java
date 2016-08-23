package com.anson.samsung.phoneandonsite;

import com.anson.util.Print;

/**
 * Created by chenzian on 8/16/16.
 */
public class SortString {

    public static void main(String[] args) {
        String[] str = {"abcd", "abc", "bdd"};
        SortString sortString = new SortString();
        sortString.SortStr(str);
        Print.printArray(str);
    }

    public void SortStr(String[] input) {
        if (input == null || input.length == 0) {
            return;
        }
        quickSort(input, 0, input.length - 1);
    }

    private void quickSort(String[] input, int low, int high) {
        if (low < high) {
            int pi = partition(input, low, high);
            quickSort(input, low, pi - 1);
            quickSort(input, pi + 1, high);
        }
    }

    private int partition(String[] input, int low, int high) {
        String pivot = input[high];
        int boundary = low;
        for (int i = low; i < high; i++) {
            if (smallerThan(input[i], pivot)) {
                swap(input, i, boundary);
                boundary++;
            }
        }
        swap(input, high, boundary);
        return boundary;
    }

    private void swap(String[] input, int a, int b) {
        String temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }

    public boolean smallerThan(String str1, String str2) {
        int loopLen = Math.min(str1.length(), str2.length());
        for (int i = 0; i < loopLen; i++) {
            if (str1.charAt(i) > str2.charAt(i)) {
                return false;
            } else if (str1.charAt(i) < str2.charAt(i)) {
                return true;
            }
        }
        return str1.length() <= str2.length();
    }
}
