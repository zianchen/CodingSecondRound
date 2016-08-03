package com.anson.twosigma;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chenzian on 8/2/16.
 */
public class TimeStamp {

    private static LinkedList<Double> qa;
    private static LinkedList<Double> qb;
    private static List<Pair> result = new LinkedList();

    public static void main(String[] args) {
        // incoming stream
        LinkedList<Double> s1 = new LinkedList<>();
        Double[] stream1 = {0.2, 1.4, 3.0};
        Collections.addAll(s1, stream1);

        LinkedList<Double> s2 = new LinkedList<>();
        Double[] stream2 = {2.0, 2.1, 4.5};
        Collections.addAll(s2, stream2);

        Mythread thread1 = new Mythread(s1, qa, qb, result);
        Mythread thread2 = new Mythread(s2, qb, qa, result);

        for (Pair pair : result) {
            System.out.println(pair.e1 + " , " + pair.e2);
        }
    }
}
