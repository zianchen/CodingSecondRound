package com.anson.brandnew;

import com.anson.util.Print;

public class QuickSort {

  public void quickSort(int[] arr) {
    // sanity check
    if (arr == null || arr.length <= 1) {
      return;
    }
    quickSortHelper(arr, 0, arr.length-1);
  }

  private void quickSortHelper(int[] arr, int s, int e) {
    if (s >= e) {
      return;
    }
    int pivot = e;
    int i = s;
    int j = s;
    while (j < e) {
      if (arr[j] <= arr[pivot]) {
        swap(arr, i, j);
        i++;
        while (j < i) {
          j++;
        }
      } else {
        j++;
      }
    }
    swap(arr, i, pivot);
    quickSortHelper(arr, s, i-1);
    quickSortHelper(arr, i+1, e);
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    QuickSort qs = new QuickSort();
    int[] input = {4,2,1,3,5};
    qs.quickSort(input);
    Print.printArray(input);
  }
}

/*
  Algorithm: recursion: 
    base case: when array length is less or equal to 1 (no sort needed)
    recursive rule: find pivot, split ele into left part(all smaller or equal to
     pivot) and right part(all bigger than pivot), then put pivot into correct place.
    
    1. base case: if the part is only one ele, or start > end, return
    2. pick right most ele as pivot, use two index i,j to track right boundary(
    not include i and j) of left part and right part, while j not reach to right bound, compare ele 
    in j with pivot
      if arr[j] <= pivot, swap arr[i] and arr[j], then i ->, j ->
      if arr[j] > pivot, j -> 
    3. swap arr[i] with pivot 
    4. recursively do these for left part and right part
 */
