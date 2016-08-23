package com.anson.facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by chenzian on 8/22/16.
 */
public class RandomArray {

    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 2};
        RandomArray randomArray = new RandomArray();
        for (int i = 0; i < 10; i++) {
            System.out.println(randomArray.randomArray(arr, 4));
        }
    }

    public int randomArray(int[] arr, int N) {
        List<Integer> smaller = new ArrayList<>();
        for (int num : arr) {
            if (num < N) {
                smaller.add(num);
            }
        }
        int[] newArr = new int[smaller.size()];
        for (int i = 0; i < smaller.size(); i++) {
            newArr[i] = smaller.get(i);
        }
        Random r = new Random();
        return newArr[r.nextInt(newArr.length)];
    }
}
