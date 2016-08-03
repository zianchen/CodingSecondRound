package com.anson.test;

import com.anson.twosigma.FriendCircle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chenzian on 6/18/16.
 */
public class FriendCircleTest {

    private FriendCircle friendCir = null;
    String[] friends = null;
    @Before
    public void setUp() throws Exception {
        //friendCir = new FriendCircle();
        friends = new String[] {"yynn","yyyn","nyyn","nnny"};
//        friends = new char[][]{{'y','y','n','n'},{'y','y','y','n'},{'n','y','y','n'},{'n','n','n','y'}};
    }

    @Test
    public void friendCirle() throws Exception {
        int numOfCircle = FriendCircle.friendCirle(friends);
        assertEquals(numOfCircle, 2);
    }

    @Test
    public void dfs() throws Exception {

    }

}