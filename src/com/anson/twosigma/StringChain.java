package com.anson.twosigma;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by chenzian on 6/18/16.
 */
public class StringChain {

    private Set<String> wordSet = new HashSet<>();
    // store the maxChainLen key can generate, key is str from dict or substring of str.
    private Map<String, Integer> map = new HashMap();

    public int longestChain(String[] dict) {
        if (dict == null || dict.length == 0) {
            return 0;
        }
        int maxChainLen = 0;
        for (String str : dict) {
            wordSet.add(str);
        }
        for (String str : dict) {
            if (str.length() <= maxChainLen) {
                continue;
            }
            int len = dfs(str) + 1;
            map.put(str, len);
            maxChainLen = Math.max(maxChainLen, len);
        }
        return maxChainLen;
    }

    public int dfs(String str) {
        int curLen = 0;
        for (int i = 0; i< str.length(); i++) {
            String sub = str.substring(0,i) + str.substring(i+1);
            if (wordSet.contains(sub)) {
                if (map.containsKey(sub)) {
                    curLen = Math.max(curLen, map.get(sub));
                } else {
                    curLen = Math.max(curLen, dfs(sub) + 1);
                    map.put(sub, dfs(sub) + 1);
                }
            }
        }
        return curLen;
    }
}
