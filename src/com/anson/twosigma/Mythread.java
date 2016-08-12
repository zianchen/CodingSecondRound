package com.anson.twosigma;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;


/**
 * Created by chenzian on 8/3/16.
 */
public class Mythread extends Thread {
    Logic logic = new Logic();
    private LinkedList<Double> s;
    private LinkedBlockingDeque<Double> q1;
    private LinkedBlockingDeque<Double> q2;
    private List<Pair> res;
    private String stringName;
    private Thread t;

    Mythread(LinkedList<Double> stream, LinkedBlockingDeque<Double> q1, LinkedBlockingDeque<Double> q2, List<Pair> result, String stringName) {
        s = stream;
        this.q1 = q1;
        this.q2 = q2;
        res = result;
        this.stringName = stringName;
    }

    @Override
    public void start() {
        if (t == null) {
            t = new Thread(this, stringName);
            t.start();
        }
    }

    @Override
    public void run() {
        while (!s.isEmpty()) {
            Double val = s.poll();
            synchronized (logic) {
                logic.calculate(q1, q2, val, res, stringName);
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

class Logic {
    public void calculate(LinkedBlockingDeque<Double> q1, LinkedBlockingDeque<Double> q2, Double val, List<Pair> res, String stringName) {
        q1.offer(val);
//        System.out.println("thread : " + stringName + " q1 size : " + q1.size() + " q2 size:" + q2.size());
        while (!q2.isEmpty() && (Math.abs(val - q2.peek()) >= 1)) {
            q2.poll();
        }
        Iterator<Double> it = q2.iterator();
        while (it.hasNext()) {
            double num = it.next();
            if (Math.abs(val - num) < 1) {
                System.out.println(stringName + " " + val + ", " + num);
                res.add(new Pair(val, num));
            } else {
                break;
            }
        }
    }
}