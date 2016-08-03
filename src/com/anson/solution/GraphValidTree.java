package com.anson.solution;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by chenzian on 6/17/16.
 */
public class GraphValidTree {

    private List<List<Integer>> adjacent = new ArrayList<List<Integer>>();

    public boolean validTree(int n, int[][] edges) {
        if (n <= 0 || edges == null || edges.length == 0 || edges[0].length == 0) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            adjacent.add(new ArrayList<Integer>());
        }
        // build adjacent list
        for (int j = 0; j < edges.length; j++) {
            int u = edges[j][0];
            int v = edges[j][1];
            adjacent.get(u).add(v);
            adjacent.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        // make sure graph has no cycle
        for (int k = 0; k < n; k++) {
            if (!visited[k]) {
                if (haveCycle(k, visited, -1)) {
                    return false;
                }
            }
        }
        // make sure all the vertex are connected with each other, how?

        return true;
    }

    public boolean haveCycle(int vertex, boolean[] visited, int parent) {
        visited[vertex] = true;
        Iterator<Integer> it = adjacent.get(vertex).iterator();
        while(it.hasNext()) {
            int v = it.next();
            if (!visited[v]) {
                if (haveCycle(v, visited, vertex)) {
                    return true;
                }
                // 注意这里千万不能返回false,因为这只是判断了vertex的一个邻接点,要整个while循环结束都没有返回true,才可以返回false
            } else if (v != parent) {
                return true;
            }
        }
        return false;
    }
}
