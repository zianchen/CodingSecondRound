package com.anson.solution;

import java.util.Arrays;

/**
 * Created by chenzian on 6/20/16.
 */
public class LongestIncreasingPath {

    private static int[] dx = {1,0,0,-1};
    private static int[] dy = {0,1,-1,0};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] maxPath = new int[m][n];
        for (int i = 0; i < maxPath.length; i++) {
            Arrays.fill(maxPath[i], 1);
        }
        int longestPath = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curLongestPath = dfs(maxPath, matrix, i, j);
                longestPath = Math.max(curLongestPath, longestPath);
            }
        }
        return longestPath;
    }

    public int dfs(int[][] maxPath, int[][] matrix, int i, int j) {
        if (maxPath[i][j] > 1) {
            return maxPath[i][j];
        }
        int tempMax = 1;
        for (int k = 0; k < dx.length; k++) {
            int newX = i + dx[k];
            int newY = j + dy[k];
            if(isValid(newX, newY, matrix) && matrix[newX][newY] < matrix[i][j]) {
                tempMax = Math.max(tempMax, dfs(maxPath, matrix, newX, newY) + 1);
            }
        }
        maxPath[i][j] = tempMax;
        return tempMax;
    }

    public boolean isValid(int x, int y, int[][]matrix) {
        if (x < 0 || x >= matrix.length) {
            return false;
        }
        if (y < 0 || y >= matrix[0].length) {
            return false;
        }
        return true;
    }
}
