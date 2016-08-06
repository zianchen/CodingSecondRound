package com.anson.samsung;

/**
 * Created by chenzian on 8/4/16.
 * Algorithm: The idea is to use counting sort. we could follow below steps to do the counting sort;
 * 1) Take a count array to store the count of each unique object.
 * 2) Modify the count array such that each element at each index stores the sum of previous counts.
 * The modified count array indicates the position of each object in the output sequence.
 * 3) Output each object from the input sequence followed by decreasing its count by 1.
 * <p>
 * Time Complexity: Since the range of digits is from 0 to 9, and the input integer is no larger than
 * Integer.MAX_VALUE (2^31 -1), so the parameter n which is the length of the array representing the
 * input integer is a constant value. so the overall time complexity is O(1).
 */
public class LargestDigits {
    public static void main(String args[]) {
        LargestDigits ob = new LargestDigits();
        int num = 123;
        int[] arr = ob.int2Array(num);

        ob.countingSort(arr);

        int result = ob.array2Int(arr);

        System.out.println(result);
    }

    public void countingSort(int arr[]) {
        int n = arr.length;
        int digitLen = 10;

        // The output character array that will have sorted arr
        int[] output = new int[n];

        // Create a count array to store count of inidividul
        // characters and initialize count array as 0
        int count[] = new int[digitLen];
        for (int i = 0; i < digitLen; i++) {
            count[i] = 0;
        }
        // store count of each character
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }
        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i = 1; i < digitLen; i++) {
            count[i] += count[i - 1];
        }
        // Build the output character array
        for (int i = 0; i < n; i++) {
            int idx = count[arr[i]] - 1;
            output[n - 1 - idx] = arr[i];
            count[arr[i]]--;
//            output[count[arr[i]]-1] = arr[i];
//            --count[arr[i]];
        }

        // Copy the output array to arr, so that arr now
        // contains sorted characters
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public int[] int2Array(int num) {
        String temp = Integer.toString(num);
        int[] nums = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            nums[i] = temp.charAt(i) - '0';
        }
        return nums;
    }

    public int array2Int(int[] arr) {
        StringBuilder strNum = new StringBuilder();
        for (int num : arr) {
            strNum.append(num);
        }
        int finalInt = Integer.parseInt(strNum.toString());
        return finalInt;
    }
}
