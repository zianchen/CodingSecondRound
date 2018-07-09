package com.anson.brandnew;

/*
2D matrix, sorted in each row, first element of next row is larger(or equal) to
the last element of previous row, now giving a target number, returning the
position that the target locate within the matrix
 */

import com.anson.util.Print;

public class BinarySearchInSorted2DArray {
  public int[] bsInSorted2DArray(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return new int[]{-1, -1};
    }
    int row = matrix.length;
    int col = matrix[0].length;
    int start = 0;
    int end = row * col - 1;
    while (start < end) {
      int mid = start + (end - start) / 2;
      int mid_row = mid / col;
      int mid_col = mid % col;
      if (matrix[mid_row][mid_col] == target) {
        return new int[]{mid_row, mid_col};
      } else if (matrix[mid_row][mid_col] < target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    if (start < row * col - 1 && matrix[start / col][start % col] == target) {
      return new int[]{start / col, start % col};
    }
    return new int[]{-1,-1};
  }

  public static void main(String[] args) {
    BinarySearchInSorted2DArray sbis = new BinarySearchInSorted2DArray();
    int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    int target = 7;
    int[] res = sbis.bsInSorted2DArray(matrix, target);
    Print.printArray(res);
  }
}

/*
descending dimension, treat 2D array as 1-dimension sorted array.
but how?
convert start and end into absolute index in 1-dimension array. calculate mid,
then convert mid into mid-row and mid-col
mid-row = mid / col;
mid-col = mid % col;
 */
