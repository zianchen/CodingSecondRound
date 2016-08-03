package com.anson.twosigma;

/**
 * Created by chenzian on 6/18/16.
 */
public class FriendCircle {

    private static int[] dx = {1,0,0,-1};
    private static int[] dy = {0,1,-1,0};
    private static boolean[] person = null;

    public static int friendCirle (String[] friends) {
        if (friends == null || friends.length ==0) {
            return 0;
        }
        int n = friends.length;
        boolean[][] visited = new boolean[n][n];
        person = new boolean[n];
        int circle = 0;

        char[][] friendship = new char[n][n];
        for (int i = 0; i < friends.length; i++) {
            friendship[i] = friends[i].toCharArray();
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (friendship[i][j] == 'y' && !visited[i][j]) {
                    circle++;
                    visited[i][j] = true;
                    person[i] = true;
                    person[j] = true;
                    dfs(visited, friendship, i, j);
                }
            }
        }
        for (int i = 0; i < person.length; i++) {
            if(!person[i]) {
                circle++;
            }
        }
        return circle;
    }

    public static void dfs(boolean[][] visited, char[][] friendship, int x, int y) {
        for (int k = 0; k < dx.length; k++) {
            int newX = x + dx[k];
            int newY = y + dy[k];
            int n = friendship.length;
            if (newX >= 0 && newX < n && newY >= 0 && newY < n ) {
                if (friendship[newX][newY] == 'y' && !visited[newX][newY]){
                    visited[newX][newY] = true;
                    person[newX] = true;
                    person[newY] = true;
                    dfs(visited, friendship, newX, newY);
                }
            }
        }
    }
}
