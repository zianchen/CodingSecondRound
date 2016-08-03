package com.anson.sample;

import com.anson.util.Print;

import java.util.Random;

/**
 * Created by chenzian on 7/5/16.
 */
public class ShuffleArray {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void randomize ( int[] arr, int n )
    {
        // Use a different seed value so that we don't get same
        // result each time we run this program
        Random random = new Random();

        // Start from the last element and swap one by one. We don't
        // need to run for the first element that's why i > 0
        for (int i = n-1; i > 0; i--)
        {
            // Pick a random index from 0 to i
            int j = random.nextInt(i+1);

            // Swap arr[i] with the element at random index
            swap(arr, i, j);
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{0,1,2,3,4,5};
        randomize(arr, arr.length);
        Print.printArray(arr);
    }
}
