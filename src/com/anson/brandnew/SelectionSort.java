package com.anson.brandnew;

import com.anson.util.Print;

public class SelectionSort {

  public void selectionSort(int[] arr) {
    // sanity check
    if (arr == null || arr.length <= 1) {
      return;
    }
    for (int i = 0; i < arr.length; i++) {
      int curMinIdx = i;
      for (int j = i + 1; j < arr.length; j++) {
        //if (arr[i] > arr[j]) {   not compare with i every time, compare with up-to-date curMinIdx
        if (arr[curMinIdx] > arr[j]) {
          curMinIdx = j;
        }
      }
      // swap
      int temp = arr[i];
      arr[i] = arr[curMinIdx];
      arr[curMinIdx] = temp;
    }
  }

  public static void main(String[] args) {
    int[] input = {3,1,4,2,5};
    SelectionSort ss = new SelectionSort();
    ss.selectionSort(input);
    Print.printArray(input);
  }
}


/*
steps:
1. iterate input array, each time find the smallest ele in remain part of array
2. in order to find the min, use inner iteration to loop every ele and compare
with the current iterative one in outer loop(first guy for this inner loop), use
temp min to locate the index of min in this inner iteration.
3. switch current min with current outer loop iterative ele

demo {3,1,4,2,5}
1. iterate 1st pos, select min within remain array {| 3,1,2,4,5} -> 1 -> {1,3,2,4,5}
2. iterate 2nd pos, select min within remain array {1 | 3,2,4,5} -> 2 -> {1,2,3,4,5}
3. iterate 3rd pos, select min
4. iterate 4th pos,
5. ...

 */