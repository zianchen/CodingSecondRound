package com.anson.test;

import com.anson.twosigma.StringChain;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chenzian on 6/18/16.
 */
public class StringChainTest {
    @Test
    public void longestChain() throws Exception {
        StringChain stringChain = new StringChain();
        String[] strArr = new String[]{"a", "abcd", "bcd", "abd", "cd","ad"};
        int result = stringChain.longestChain(strArr);
        System.out.println("longest chain length is : " + result);
    }

}