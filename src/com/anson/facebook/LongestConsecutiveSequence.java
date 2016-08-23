package com.anson.facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenzian on 8/21/16.
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] input = {100, 4, 200, 1, 3, 2};
        LongestConsecutiveSequence log = new LongestConsecutiveSequence();
        int output = log.longestConsecutive(input);
        System.out.println(output);
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> seq = new HashMap<>();
        int globalMax = 0;
        for (int n : nums) {
            if (!seq.containsKey(n)) {
                int left = seq.containsKey(n - 1) ? seq.get(n - 1) : 0;
                int right = seq.containsKey(n + 1) ? seq.get(n + 1) : 0;
                int sum = left + 1 + right;
                globalMax = Math.max(globalMax, sum);
                seq.put(n, sum);

                seq.put(n - left, sum);
                seq.put(n + right, sum);
            }
        }
        return globalMax;
    }
}
