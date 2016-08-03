package com.anson.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chenzian on 7/27/16.
 */
public class KSum {

    private List<List<Integer>> res= new LinkedList<>();
    private int len = 0;

    public List<List<Integer>> KSum (int[] input, int target, int k) {
        if (input == null || input.length == 0) {
            return res;
        }
        Arrays.sort(input);
        return KSumHelper(input, k, target, 0);
    }

    public List<List<Integer>> KSumHelper(int[] input, int k, int target, int idx) {
        if (idx >= len) {
            return res;
        }
        if (k == 2) {
            int l = idx, r = len - 1;
            int sum = input[l] + input[r];
            while (l < r) {
                if (sum == target) {
                    List<Integer> tmp = new LinkedList();
                    tmp.add(input[l]);
                    tmp.add(input[r]);
                    res.add(tmp);
                    while (l < r && input[l] == input[l + 1]) {
                        l++;
                    }
                    while (idx < r && input[r] == input[r - 1]) {
                        r--;
                    }
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        } else {
            for (int j = idx; j < len - k + 1; j++) {
                List<List<Integer>> temp = KSumHelper(input, k - 1, target - input[j], idx + 1);
                if (temp.size() > 0) {
                    for (List<Integer> t : temp) {
                        t.add(0, input[j]);
                    }
                    res.addAll(temp);
                }
                while (j < len - 1 && input[j] == input[j+1]) {
                    j++;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
