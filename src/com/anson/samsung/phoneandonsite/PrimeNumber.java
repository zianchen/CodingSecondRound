package com.anson.samsung.phoneandonsite;

import com.anson.util.Print;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenzian on 8/15/16.
 */
public class PrimeNumber {
    public static void main(String[] args) {
        PrimeNumber primeNumber = new PrimeNumber();
        int[] output = primeNumber.primeNumBetween(1, 200);
        Print.printArray(output);
    }

    public int[] primeNumBetween(int m, int n) {
        int[] origin = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            origin[i] = i;
        }
        List<Integer> primes1 = primeHelper(origin, m);
        List<Integer> primes2 = primeHelper(origin, n);
        primes1.retainAll(primes2);
        int[] result = new int[primes1.size()];
        for (int k = 0; k < primes1.size(); k++) {
            result[k] = primes1.get(k);
        }
        return result;
    }

    private List<Integer> primeHelper(int[] origin, int num) {
        List<Integer> res = new ArrayList<>();
        for (int p = 2; p <= num; p++) {
            if (origin[p] != -1) {
                for (int j = p * 2; j <= num; j += p) {
                    origin[j] = -1;
                }
            }
        }
        for (int item : origin) {
//            0, 1不是prime
            if (item != -1 && item != 0 && item != 1) {
                res.add(item);
            }
        }
        return res;
    }
}

// optimize
// 1. skip所有偶数
// 2. 还有就是外层for loop 只需要loop到 sqrt(n),而不需要弄到n. Goldbach Conjecture 哥德巴赫猜想