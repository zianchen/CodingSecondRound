package com.anson.brandnew;

import com.anson.util.Print;

public class Sample {

  // you can also use imports, for example:
  // import java.util.*;

  // you can write to stdout for debugging purposes, e.g.
  // System.out.println("this is a debug message");


    public int Sample(int N) {
      // write your code in Java SE 8
      if (N <= 0) {
        return 0;
      }
      char[] binary = getBinaryRepresent(N);
      int l = 0;
      int r = 1;
      int max = 0;
      while (r < binary.length) {
        if (binary[l] == '1') {
          // find next 1 for r, and calculate gap
          while (binary[r] != '1') {
            r++;
          }
          if (r != l + 1) {
            max = Math.max(max, r - l + 1);
          }
          l = r;
        } else {
          // find next 1 for l
          while (l < binary.length && binary[l] != '1') {
            l++;
          }
        }
        r = l + 1;
      }
      return max;
    }

    private char[] getBinaryRepresent(int N) {
      StringBuilder sb = new StringBuilder();
      while (N / 2 != 0 && N != 1) {
        char c = N % 2 != 0 ? '1' : '0';
        sb.append(c);
        N /= 2;
      }
      if (N == 1) {
        sb.append('1');
      }
      return sb.reverse().toString().toCharArray();
    }


  public static void main(String[] args) {
    int N = 1041;
    System.out.println("baqi: " + Integer.toBinaryString(N));
    Sample s = new Sample();
    char[] res = s.getBinaryRepresent(N);
    Print.printArray(res);

    String str = "10001001";
    str.split("1");
  }
}
