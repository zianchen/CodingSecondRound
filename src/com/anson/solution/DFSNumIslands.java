package com.anson.solution;

/**
 * Created by chenzian on 6/17/16.
 */
public class DFSNumIslands {

    private static int count = 0;
    private int[] dx = new int[]{1,0,0,-1};
    private int[] dy = new int[]{0,1,-1,0};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0 ;i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    visited[i][j] = true;
                    dfs(i,j,grid,visited);
                }
            }
        }
        return count;
    }

    public void dfs(int x, int y, char[][] grid, boolean[][] visited) {
        if (grid[x][y] == 0) {
            return;
        }
        for (int k = 0; k < dx.length; k++) {
            int newX = x + dx[k];
            int newY = y + dy[k];
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == '1' && !visited[newX][newY]) {
                visited[newX][newY] = true;
                dfs(newX,newY,grid,visited);
            }
        }
    }
}
