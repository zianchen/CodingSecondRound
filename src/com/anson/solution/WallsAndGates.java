package com.anson.solution;

import java.util.*;

/**
 * Created by chenzian on 6/17/16.
 */
public class WallsAndGates {

    private final int INF = 2147483647;
    private int[] dx = new int[]{1,0,0,-1};
    private int[] dy = new int[]{0,1,-1,0};
    private Map<Integer,Integer> tempDistance = new HashMap();

    public void wallsGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        int row = rooms.length, col = rooms[0].length;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0 && !visited[i][j]) {
                    int index = i * row + j;
                    visited[i][j] = true;
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(index);
                    bfs(queue, index, rooms, visited);
                }
            }
        }
        for (Integer key : tempDistance.keySet()) {
            int curX = key / row;
            int curY = key % row;
            rooms[curX][curY] = tempDistance.get(key);
        }
    }

    public void bfs(Queue<Integer> queue, int index, int[][] rooms, boolean[][] visited) {
        int m = rooms.length, n = rooms[0].length;
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int cur = queue.poll();
                distance++;
                int x = cur / m;
                int y = cur % m;
                for (int k = 0; k < dx.length; k++) {
                    int newX = x + dx[k];
                    int newY = y + dy[k];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && rooms[newX][newY] == INF && !visited[newX][newY]) {
                        int pos = newX * m + newY;
                        if (distance == 1) {
                            rooms[newX][newY] = distance;
                        } else {
                            if (tempDistance.containsKey(pos)) {
                                tempDistance.put(pos, Math.min(tempDistance.get(pos), distance));
                            } else {
                                tempDistance.put(pos, distance);
                            }
                        }
                        visited[newX][newY] = true;
                        queue.offer(pos);
                    }
                }
            }
        }
    }
}
