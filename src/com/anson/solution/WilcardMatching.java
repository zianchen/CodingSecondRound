package com.anson.solution;

/**
 * Created by chenzian on 6/21/16.
 */
public class WilcardMatching {
    public boolean isMatch(String s, String p) {
        //sanity check 就是一个比较蛋疼的问题
        //? 为什么答案都没有考虑s == null 或者 p == null的情况呢额。。。
        if (s == null || p == null || p.length() == 0) {
            if ((s == null && p == null) || (s.length() == 0 && p.length() == 0)) {
                return true;
            }
            return false;
        }
        // 为了避免dp[i][j]表示 s[0..i-1] 到p[0..j-1]的尴尬,调整一下s和p
        s = " " + s;
        p = " " + p;
        // dp[i][j] represent if s[1..i] matches p[1..j]
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        for (int i = 1; i < m; i++) {
            dp[i][0] = false;
        }
        for (int j = 1; j < n; j++) {
            if (p.charAt(j) == '*') {
                dp[0][j] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (p.charAt(j) != '*') {
                    dp[i][j] = dp[i-1][j-1] && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?');
                } else {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
