package com.anson.twosigma;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by chenzian on 8/2/16.
 */
public class TimeStamp {

    private LinkedList<Double> qa;
    private LinkedList<Double> qb;
    private List<Pair> result = new LinkedList();

//    public static void main(String[] args) {
//        // incoming stream
//        List<Double> s1 = new LinkedList<>();
//        Double[] stream1 = {0.2, 1.4, 3.0};
//        Collections.addAll(s1, stream1);
//
//        List<Double> s2 = new LinkedList<>();
//        Double[] stream2 = {2.0, 2.1, 4.5};
//        Collections.addAll(s2, stream2);
//
//
//        Mythread thread1 = new Mythread(s1, q1, q2);
//        Mythread thread2 = new Mythread(s2, q2, q1);
//    }

    private class Pair {
        double e1;
        double e2;

        public Pair(double e1, double e2) {
            this.e1 = e1;
            this.e2 = e2;
        }
    }
    private class Mythread extends Thread {

        private LinkedList<Double> s;
        private LinkedList<Double> q1;
        private LinkedList<Double> q2;

        Mythread(LinkedList<Double> stream, LinkedList<Double> q1, LinkedList<Double> q2) {
            s = stream;
            this.q1 = q1;
            this.q2 = q2;
        }
        @Override
        public void run(){
            while(true) {
                Double val = s.poll();
                synchronized (this) {
                    calculate(q1, q2, val);
                }
            }
        }
    }

    public void calculate(LinkedList<Double> q1, LinkedList<Double> q2, Double val) {
        q1.offer(val);
        while (!q2.isEmpty()) {
            while (!q2.isEmpty() && (val - q2.peek() >= 1)) {
                q2.poll();
            }
            for (double num : q2) {
                if (Math.abs(val - num) < 1) {
                    result.add(new Pair(val, num));
                }
            }
        }
    }
}
