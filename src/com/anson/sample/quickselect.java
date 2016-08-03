package com.anson.sample;

/**
 * Created by chenzian on 6/27/16.
 */

public class quickselect {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] =temp;
    }

    public static int partition(int[] arr, int lo, int hi) {
        int i = lo + 1, j = hi;
        int pivot = arr[lo];
        while(i <= j) {
            while (i <= j && arr[i] < pivot) {
                i++;
            }
            while (i <= j && arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(arr,i,j);
                i++;
                j--;
            }
        }

        swap(arr,lo,j);
        return j;
    }
    public static int quickselect(int[] arr, int k) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int j = partition(arr, lo, hi) + 1;
            if (j == k) {
                return arr[k];
            } else if (j < k) {
                lo = j+1;
            } else {
                hi = j - 1;
            }
        }
        return arr[k];
    }

    public static void main(String[] args) {
        int[] test = new int[]{7,9,2,3,5,1,4};
        int ret = quickselect(test,1);
        System.out.println(ret);
    }
}
