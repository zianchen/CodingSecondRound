package com.anson.test;

import com.anson.twosigma.ModFiveIterator;
import com.anson.twosigma.RandomIterator;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by chenzian on 8/3/16.
 */
public class ModFiveIteratorTest {

    private RandomIterator rit;
    private ModFiveIterator modFiveIterator;

    @Before
    public void setUp() throws Exception {
        LinkedList<Integer> input = new LinkedList<>();
        Integer[] stream1 = {1, 3, 5, 7, 10, 15, 20, 34, 35};
        Collections.addAll(input, stream1);
        RandomIterator randomIterator = new RandomIterator(input);
        rit = randomIterator;
    }

    @Test
    public void hasNext() throws Exception {
        modFiveIterator = new ModFiveIterator(rit);
        modFiveIterator.hasNext();
    }

    @Test
    public void next() throws Exception {
        modFiveIterator.next();
    }

}