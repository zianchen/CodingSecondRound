package com.anson.twosigma;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenzian on 6/18/16.
 */
public class FibonacciCoding {

    private int len = 30;
    private int[] fib = new int[len];

    public String fibEncoding(int n) throws Exception {
        if (n < 0) {
            throw new Exception("n should be positive integer");
        }
        StringBuilder result = new StringBuilder();
        int index = findCloestFib(n);
        int[] fibCode = new int[index+1];
        fibCode[index] = 1;
        int remainder = n - fib[index];
        while (remainder > 0) {
            index = findCloestFib(remainder);
            fibCode[index] = 1;
            remainder -= fib[index];
        }
        int start = findStartIndex(fibCode);
        for (int i = start; i < fibCode.length; i++) {
            result.append(fibCode[i]);
        }
        return result.toString();
    }

    public int findStartIndex(int[] arr) {
        for (int i = 0 ; i < arr.length; i++) {
            if (arr[i] != 0) {
                return i;
            }
        }
        return arr.length - 1;
    }

    public int findCloestFib(int n) {
        fib[0] = 1;
        fib[1] = 2;
        int i = 2;
        for (; fib[i-1] <= n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return i-2;
    }
}
