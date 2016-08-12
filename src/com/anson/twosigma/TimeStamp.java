package com.anson.twosigma;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by chenzian on 8/2/16.
 */
public class TimeStamp {

    private static LinkedBlockingDeque<Double> qa = new LinkedBlockingDeque<>();
    private static LinkedBlockingDeque<Double> qb = new LinkedBlockingDeque<>();
    private static List<Pair> result = new LinkedList();

    public static void main(String[] args) {
        // incoming stream
        LinkedList<Double> s1 = new LinkedList<>();
        Double[] stream1 = {0.2, 1.4, 3.0};
        Collections.addAll(s1, stream1);

        LinkedList<Double> s2 = new LinkedList<>();
        Double[] stream2 = {1.0, 1.1, 3.5};
        Collections.addAll(s2, stream2);

        Mythread thread1 = new Mythread(s1, qa, qb, result, "1");
        thread1.start();
        Mythread thread2 = new Mythread(s2, qb, qa, result, "2");
        thread2.start();
    }
}
