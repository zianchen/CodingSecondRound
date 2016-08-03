package com.anson.test;

import com.anson.solution.LongestIcreasingSubSequence;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chenzian on 6/23/16.
 */
public class LongestIcreasingSubSequenceTest {
    @Test
    public void lengthOfLIS() throws Exception {
        LongestIcreasingSubSequence longestIcreasingSubSequence = new LongestIcreasingSubSequence();
        int[] test = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int ret = longestIcreasingSubSequence.lengthOfLIS(test);
        assertEquals(ret, 4);
    }
}