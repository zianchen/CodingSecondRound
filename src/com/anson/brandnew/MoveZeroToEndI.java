package com.anson.brandnew;

/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */

import com.anson.util.Print;

public class MoveZeroToEndI {

  public void moveZeroToEnd1(int[] arr) {
    if (arr == null || arr.length <= 1) {
      return;
    }
    int i = 0;
    int j = 0;
    while (j < arr.length) {
      if (arr[j] != 0) {
        swap(arr, i, j);
        i++;
        while (j < i) {
          j++;
        }
      } else {
        j++;
      }
    }
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    MoveZeroToEndI mz = new MoveZeroToEndI();
    int[] input = {0, 1, 0, 3, 12};
    mz.moveZeroToEnd1(input);
    Print.printArray(input);
  }
}

/*
This is exactly the same logic with quicksort logic, use two index i and j.
1. ele locate in left of i (not include i) is non-zero element
2. ele locate between [i, j) is zero
 */
