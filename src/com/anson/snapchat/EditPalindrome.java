package com.anson.snapchat;

/**
 * Created by chenzian on 6/27/16.
 */
public class EditPalindrome {
    public static int help(char[] letters, int size) {
        int[][] dp = new int[size][size];
        for (int k = 1; k < size; ++k) {
            for (int i = 0; i + k < size; ++i) {
                int j = i + k;
                if (letters[i] == letters[j]) {
                    dp[i][j] = k == 1 ? 0 : dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i + 1][j], dp[i][j - 1]), k == 1 ? 0 : dp[i + 1][j - 1]) + 1;
                }
            }
        }
        return dp[0][size - 1];
    }
}


