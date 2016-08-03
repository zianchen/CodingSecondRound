package com.anson.test;

import com.anson.solution.WilcardMatching;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chenzian on 6/21/16.
 */
public class WilcardMatchingTest {
    @Test
    public void isMatch() throws Exception {
        WilcardMatching wilcardMatching = new WilcardMatching();
        String s = "aa";
        String p = "a";
        boolean ret = wilcardMatching.isMatch(s, p);
        assertEquals(ret, false);
    }

}