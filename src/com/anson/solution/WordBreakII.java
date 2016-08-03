package com.anson.solution;

import java.util.*;

/**
 * Created by chenzian on 6/21/16.
 */
public class WordBreakII {

    private Map<String, List<String>> strBreakMap = new HashMap();
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> ret = new ArrayList();
        if (s == null || wordDict == null) {
            return ret;
        }
        ret = dfs(s, wordDict);
        return ret;
    }
    public List<String> dfs(String s, Set<String> wordDict) {
        if (strBreakMap.containsKey(s)) {
            return strBreakMap.get(s);
        }
        if (s.length() == 0) {}
//        for (int i = 1; i <= s.length(); i++) {
//            if (wordDict.contains(s.substring(0,i))) {
//                List<String> temp = dfs(s.substring(i), wordDict);
//                if (temp.size() )
//            }
//        }
        return null;
    }
}
