package com.anson.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by chenzian on 6/21/16.
 */
public class WordBreak {

    private Map<String, Boolean> wordMap = new HashMap();
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return false;
        }
        boolean ret = dfs(s, wordDict);
        return ret;
    }

    public boolean dfs(String s, Set<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }
        boolean canBreak = false;
        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0,i);
            if (wordDict.contains(sub)) {
                String remain = s.substring(i);
                if (wordMap.containsKey(remain)) {
                    return wordMap.get(remain);
                } else {
                    boolean remainBreak = dfs(remain, wordDict);
                    wordMap.put(remain, remainBreak);
                    canBreak |= remainBreak;
                }
            }
        }
        wordMap.put(s, canBreak);
        return canBreak;
    }
}
