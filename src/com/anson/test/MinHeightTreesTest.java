package com.anson.test;

import com.anson.solution.MinHeightTrees;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chenzian on 6/17/16.
 */
public class MinHeightTreesTest {

    MinHeightTrees mht = null;
    private int[][] edges = null;
    private int number = 0;

    @Before
    public void setUp() throws Exception {
        mht = new MinHeightTrees();
//        edges = new int[][] {{1,0},{1,2}, {1,3}};
//        number = 4;
        edges = new int[][] {};
        number = 1;

    }

    @Test
    public void findMinHeightTrees() throws Exception {
        mht.findMinHeightTrees(number, edges);
    }

    @Test
    public void bfs() throws Exception {
        boolean[] visited = new boolean[4];
        mht.bfs(0, visited);
    }

}