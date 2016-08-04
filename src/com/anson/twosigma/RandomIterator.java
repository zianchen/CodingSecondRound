package com.anson.twosigma;

import java.util.LinkedList;

/**
 * Created by chenzian on 8/3/16.
 */
public class RandomIterator {

    private LinkedList<Integer> num;

    public RandomIterator() {
    }

    public RandomIterator(LinkedList<Integer> nums) {
        num = nums;
    }

    // Returns the next element in the iteration.
    public int next() throws Exception {
        if (hasNext()) {
            return num.poll();
        }
        throw new Exception("no more elements!");
    }

    // Returns true if the iteration has more elements.
    public boolean hasNext() throws Exception {
        return num.size() != 0;
    }

    public void remove() {
        num.poll();
    }
}
