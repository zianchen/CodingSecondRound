package com.anson.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chenzian on 6/17/16.
 */
public class BFSNumIslands {

    private int[] dx = new int[]{1,0,0,-1};
    private int[] dy = new int[]{0,1,-1,0};

    public int numOfIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0 ;i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    visited[i][j] = true;
                    int index = i * m + j;
                    bfs(index,grid,visited);
                }
            }
        }
        return count;
    }

    public void bfs(int index, char[][] grid, boolean[][] visited) {
        Queue<Integer> queue = new LinkedList();
        queue.offer(index);
        int m = grid.length;
        int n = grid[0].length;
        while(!queue.isEmpty()) {
            int current = queue.poll();
            int x = current / m;
            int y = current % m;
            for (int k = 0; k < dx.length; k++) {
                int newX = x + dx[k];
                int newY = y + dy[k];
                if (newX >= 0 && newX < m && newY >=0 && newY < n && grid[newX][newY] == '1' && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.offer(newX * m + newY);
                }
            }
        }
    }
}
