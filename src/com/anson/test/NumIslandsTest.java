package com.anson.test;

import com.anson.solution.BFSNumIslands;
import com.anson.solution.DFSNumIslands;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chenzian on 6/17/16.
 */
public class NumIslandsTest {
    @Test(timeout = 1000)
    public void testNumIslands() {
        char[][] grid1 = {};
        char[][] grid2 = {{'1','1','0','0'},{'1','1','1','0'},{'0','0','1','0'}};
        char[][] grid3 = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};

        DFSNumIslands numIslandsdfs = new DFSNumIslands();
        BFSNumIslands numIslandsbfs = new BFSNumIslands();

        int count1Dfs  = numIslandsdfs.numIslands(grid1);
        assertEquals(count1Dfs,0);
//        int count1Bfs  = numIslandsbfs.numOfIslands(grid1);
//        assertEquals(count1Bfs,0);
        int count2Dfs  = numIslandsdfs.numIslands(grid2);
        assertEquals(count2Dfs,1);
//        int count2Bfs  = numIslandsbfs.numOfIslands(grid2);
//        assertEquals(count2Bfs,1);
        int count3Dfs  = numIslandsdfs.numIslands(grid3);
        assertEquals(count3Dfs,3);
//        int count3Bfs  = numIslandsbfs.numOfIslands(grid3);
//        assertEquals(count3Bfs,3);

    }
}