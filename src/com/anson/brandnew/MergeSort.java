package com.anson.brandnew;

import com.anson.util.Print;

public class MergeSort {

  public void mergeSort(int[] arr) {
    // sanity check
    if (arr == null || arr.length <= 1) {
      return;
    }

    int[] temp = new int[arr.length];

    sortHelper(arr, 0, arr.length-1, temp);
  }

  private void sortHelper(int[] arr, int start, int end, int[] temp) {
    if (start >= end) {
      return;
    }
    int mid = start + (end - start) / 2;
    sortHelper(arr, start, mid, temp);
    sortHelper(arr, mid + 1, end, temp);
    merge(arr, start, mid, end, temp);
  }

  public void merge(int[] arr, int s, int mid, int e, int[] temp) {
    for (int i = s; i <= e; i++) {
      temp[i] = arr[i];
    }
    int l = s;
    int r = mid + 1;
    int k = l;
    while (l <= mid && r <= e) {
      if (temp[l] < temp[r]) {
        arr[k++] = temp[l++];
      } else {
        arr[k++] = temp[r++];
      }
    }
    while (l <= mid) {
      arr[k++] = temp[l++];
    }
  }

  public static void main(String[] args) {
    MergeSort ms = new MergeSort();
    int[] input = {4,2,5,3,6};
    ms.mergeSort(input);
    Print.printArray(input);
  }
}

/*
algorithm: Recursion:
  base case: when array length is less or equal to 1 (no sort needed)
  recursive rule:  divide current part of array into left half and right half,
  assume mergeSort can sort the part, then merge two sorted array

  1. base case: if the part is only one ele, or start > end, return
  2. divide current part of array (need start, end) into two half
  3. function call itself, sort(left), sort(right)
  4. use merge() to merge two sorted array
 */
