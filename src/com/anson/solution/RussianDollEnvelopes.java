package com.anson.solution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by chenzian on 6/23/16.
 */
public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        /*
        1. use compare to sort the array
        2. use find longest increasing sequence
        */
        // sannity check
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }
        if (envelopes.length == 1) {
            return 1;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];  // becaue we want to calculate logest increasing sequence on right index, it will mess up if we still sort elements in acending order when left index are equal.
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        System.out.println("after sorting");
        for (int i = 0; i < envelopes.length; i++) {
            System.out.println(envelopes[i][0] + ", " + envelopes[i][1]);
        }

        // since left index is strictly increasing, we only need to consider right index.
        int start = 0, maxLen = 0;
        for (int i = 1; i < envelopes.length; i++) {
            if (envelopes[i][1] > envelopes[i-1][1]) {
//                System.out.println("the " + i + " round is :" + i);
                continue;
            } else {
                maxLen = Math.max(maxLen, i - start);
                start = i;
            }
        }
        maxLen = Math.max(maxLen, envelopes.length - start);
        return maxLen;
    }
}
