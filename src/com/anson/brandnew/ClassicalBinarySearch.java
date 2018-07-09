package com.anson.brandnew;

/*
Given a target integer T and an integer array A sorted in ascending order, find the index i such that A[i] == T or return -1 if there is no such index.

Assumptions

There can be duplicate elements in the array, and you can return any of the indices i such that A[i] == T.
Examples

A = {1, 2, 3, 4, 5}, T = 3, return 2
A = {1, 2, 3, 4, 5}, T = 6, return -1
A = {1, 2, 2, 2, 3, 4}, T = 2, return 1 or 2 or 3

corner case:
just sanity check
 */

public class ClassicalBinarySearch {

  public int classicalBinarySearch(int[] arr, int target) {
    if (arr == null || arr.length == 0) {
      return -1;
    }
    int l = 0;
    int r = arr.length - 1;
    while (l < r) {
      int mid = l + (r - l) / 2;
      if (arr[mid] == target) {
        return mid;
      } else if (arr[mid] < target) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    if (l < arr.length) {
      return arr[l] == target ? l : -1;
    }
    return -1;
  }

  public static void main(String[] args) {
    ClassicalBinarySearch cbs = new ClassicalBinarySearch();
//    int[] input = {1,2,2,2,3,4};
//    int target = 2;
    int[] input = {2};
    int target = 1;
    int res = cbs.classicalBinarySearch(input, target);
    System.out.println(res);
  }
}
