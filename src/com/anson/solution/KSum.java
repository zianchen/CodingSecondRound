package com.anson.solution;

import com.anson.util.Print;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chenzian on 7/27/16.
 */
public class KSum {

    //http://blog.csdn.net/github_27609763/article/details/47728809  这个答案的思路跟本代码类似,但没时间深究是否有bug
    private List<List<Integer>> res= new LinkedList<>();
    private int len = 0;

    public static void main(String[] args) {
        KSum kSum = new KSum();
        int[] input = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> enen = kSum.KSum(input, 0, 4);
//        System.out.println(enen.size());
        Print.printtwoDList(enen);
    }

    public List<List<Integer>> KSum (int[] input, int target, int k) {
        if (input == null || input.length == 0) {
            return res;
        }
        Arrays.sort(input);
        len = input.length;
        return KSumHelper(input, k, target, 0);
    }

    public List<List<Integer>> KSumHelper(int[] input, int k, int target, int idx) {
        if (idx >= len) {
            return res;
        }
        if (k == 2) {
            int l = idx, r = len - 1;
            List<List<Integer>> twoSumResult = new LinkedList();
            while (l < r) {
                int sum = input[l] + input[r];
                if (sum == target) {
                    List<Integer> tmp = new LinkedList();
                    tmp.add(input[l]);
                    tmp.add(input[r]);
                    twoSumResult.add(tmp);
                    l++;
                    r--;
                    while (l < r && input[l] == input[l + 1]) {
                        l++;
                    }
                    while (l < r && input[r] == input[r - 1]) {
                        r--;
                    }
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
            return twoSumResult;
        } else {
            for (int j = idx; j < len - k + 1; j++) {
                List<List<Integer>> temp = KSumHelper(input, k - 1, target - input[j], j + 1);
                if (temp.size() > 0) {
//                    System.out.println(temp.size());
                    for (List<Integer> t : temp) {
                        t.add(0, input[j]);
                    }
                    res.addAll(temp);
                }
                while (j < len - 1 && input[j] == input[j+1]) {
                    j++;
                }
            }
            return res;
        }
    }
}
