package com.anson.test;

import com.anson.twosigma.FibonacciCoding;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chenzian on 6/18/16.
 */
public class FibonacciCodingTest {

    private FibonacciCoding fibonacciCoding = null;
    private int n = 0;

    @Before
    public void SetUp() {
        fibonacciCoding = new FibonacciCoding();
        n = 11;
    }

    @Test
    public void fibEncoding() throws Exception {
        String fibStr = fibonacciCoding.fibEncoding(n);
        System.out.println("fibStr is: " + fibStr);
    }

    @Test
    public void findCloestFib() throws Exception {
        int cloest = fibonacciCoding.findCloestFib(n);
//        System.out.println("cloest is : " + cloest);
    }

}