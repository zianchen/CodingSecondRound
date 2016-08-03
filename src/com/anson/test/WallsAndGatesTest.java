package com.anson.test;

import com.anson.solution.WallsAndGates;
import com.anson.util.Print;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chenzian on 6/17/16.
 */
public class WallsAndGatesTest {
    @Test
    public void wallsGates() throws Exception {
        WallsAndGates wag = new WallsAndGates();
        int[][] rooms = new int[][]{{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        wag.wallsGates(rooms);
        Print.printMatrix(rooms);
    }

}