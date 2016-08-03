package com.anson.solution;

import com.anson.util.Print;

import java.util.*;

/**
 * Created by chenzian on 6/17/16.
 */
public class MinHeightTrees {
    // assume all the vertex are connected by edges.
    private List<List<Integer>> graph = new ArrayList();
    private Map<Integer, List<Integer>> heightMap = new HashMap();
    private int minHeight = Integer.MAX_VALUE;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList();
        if (n <= 0 || edges == null || edges.length == 0 || edges[0].length == 0) {
            if (n == 1 && edges.length == 0) {
                return new ArrayList<Integer>(Arrays.asList(0));
            }
            return result;
        }
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int j = 0; j < edges.length; j++) {
            int u = edges[j][0];
            int v = edges[j][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

//        Print.printtwoDList(graph);

        for (int k = 0; k < n; k++) {
            boolean[] visited = new boolean[n];
            bfs(k, visited);
        }
        System.out.println("heightMap size is :" + heightMap.size());
        Print.printHashMap(heightMap);
        result = heightMap.get(minHeight);
        return result;
    }

    public void bfs(int vertex, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vertex);
        visited[vertex] = true;
        int height = 0;
        while(!queue.isEmpty()) {
            height++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                List<Integer> adj = graph.get(cur);

//                Print.printOneDList(adj);

                for (Integer v : adj) {
                    if (!visited[v]) {
                        visited[v] = true;
                        queue.offer(v);
                    }
                }
            }
        }
        minHeight = Math.min(minHeight, height);
//        System.out.println("minHeight is : " + minHeight);
//        System.out.println("height is : " + height);
       /*
       * 这一段代码用怎样的简化写法比较专业?
       * */
        if (heightMap.containsKey(height)) {
            List<Integer> rootList = heightMap.get(height);
            rootList.add(vertex);
            heightMap.put(height, rootList);
        } else {
            List<Integer> temp = new ArrayList<>();
            temp.add(vertex);
            heightMap.put(height, temp);
        }
    }
}
