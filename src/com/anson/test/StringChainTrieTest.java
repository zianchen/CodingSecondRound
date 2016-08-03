package com.anson.test;

import com.anson.twosigma.StringChainTrie;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chenzian on 6/19/16.
 */
public class StringChainTrieTest {
    @Test
    public void stringChain() throws Exception {
        StringChainTrie stringChain = new StringChainTrie();
        String[] strArr = new String[]{"a", "abcd", "bcd", "abd", "cd","ad"};
        int result = stringChain.stringChain(strArr);
        System.out.println("longest chain length is : " + result);
    }

}