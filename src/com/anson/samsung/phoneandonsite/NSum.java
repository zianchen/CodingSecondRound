package com.anson.samsung.phoneandonsite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenzian on 8/15/16.
 */

class Pair {
    int first;
    int second;

    public Pair(int f, int s) {
        first = f;
        second = s;
    }
}

public class NSum {
    public static void main(String[] args) {
        int[] input = {2, 3, 4, 1, 7, 10};
        NSum nSum = new NSum();
//        List<List<Integer>> result = nSum.twoSum(input,11);
        List<List<Integer>> result = nSum.threeSum(input, 14);
        for (List<Integer> pair : result) {
            System.out.println(pair.get(0) + ", " + pair.get(1));
        }
    }

    public List<List<Integer>> twoSum(int[] input, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // hha
        if (input == null || input.length < 2) {
            return res;
        }
        Arrays.sort(input);
        int left = 0, right = input.length - 1;

        while (left < right) {
            int sum = input[left] + input[right];
            if (sum == target) {
                res.add(Arrays.asList(input[left], input[right]));
                left++;
                right--;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] input, int target) {
        List<List<Integer>> res = new ArrayList();
        if (input == null || input.length < 3) {
            return res;
        }
        Arrays.sort(input);
        for (int item : input) {
            List<List<Integer>> temp = twoSum(input, target - item);
            if (temp.size() != 0) {
                for (List<Integer> pair : temp) {
                    pair.add(0, item);
                }
                res.addAll(temp);
            }
        }
        return res;
    }
}
