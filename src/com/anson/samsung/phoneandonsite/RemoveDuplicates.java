package com.anson.samsung.phoneandonsite;

import com.anson.util.Print;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenzian on 8/15/16.
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] input = {2, 2, 3, 4, 6, 1, 4, 1};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] hah = removeDuplicates.removeDup(input);
        Print.printArray(hah);
    }

    public int[] removeDup(int[] arr) {
        List<Integer> res = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            if (arr[Math.abs(arr[i])] > 0) {
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
                res.add(arr[i]);
            }
        }
        int[] result = new int[res.size()];
        for (int j = 0; j < res.size(); j++) {
            result[j] = Math.abs(res.get(j));
        }
        return result;
    }
}
