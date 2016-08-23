package com.anson.facebook;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by chenzian on 8/23/16.
 */
public class RandomWithEqualProbabilityTest {
    @Test
    public void myRand() throws Exception {
        int[] arr = {10, 20, 30};
        int[] freq = {2, 3, 1};
        RandomWithEqualProbability randomWithEqualProbability = new RandomWithEqualProbability();
        Map<Integer, Integer> count = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            int res = randomWithEqualProbability.myRand(arr, freq, random);
            if (count.containsKey(res)) {
                count.put(res, count.get(res) + 1);
            } else {
                count.put(res, 1);
            }
        }
        System.out.println(count.toString());
    }

}