package com.anson.test;

import com.anson.solution.RussianDollEnvelopes;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chenzian on 6/23/16.
 */
public class RussianDollEnvelopesTest {
    @Test
    public void maxEnvelopes() throws Exception {
        RussianDollEnvelopes russianDollEnvelopes = new RussianDollEnvelopes();
        int[][] envelopes = new int[][]{{2,3},{4,5},{6,7}};
        int ret = russianDollEnvelopes.maxEnvelopes(envelopes);
        assertEquals(ret, 3);
    }

}