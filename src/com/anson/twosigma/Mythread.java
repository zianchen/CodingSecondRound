package com.anson.twosigma;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by chenzian on 8/3/16.
 */
public class Mythread extends Thread {
    private LinkedList<Double> s;
    private LinkedList<Double> q1;
    private LinkedList<Double> q2;
    private List<Pair> res;

    Mythread(LinkedList<Double> stream, LinkedList<Double> q1, LinkedList<Double> q2, List<Pair> result) {
        s = stream;
        this.q1 = q1;
        this.q2 = q2;
        res = result;
    }

    @Override
    public void run() {
        while (true) {
            Double val = s.poll();
            synchronized (this) {
                calculate(q1, q2, val, res);
            }
        }
    }

    public void calculate(LinkedList<Double> q1, LinkedList<Double> q2, Double val, List<Pair> res) {
        q1.offer(val);
        while (!q2.isEmpty()) {
            while (!q2.isEmpty() && (val - q2.peek() >= 1)) {
                q2.poll();
            }
            for (double num : q2) {
                if (Math.abs(val - num) < 1) {
                    res.add(new Pair(val, num));
                } else {
                    break;
                }
            }
        }
    }
}
