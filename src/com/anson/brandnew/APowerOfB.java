package com.anson.brandnew;

import java.math.BigInteger;
import java.sql.SQLOutput;

/*
Evaluate a to the power of b, assuming both a and b are integers and b is non-negative.

Examples

power(2, 0) = 1
power(2, 3) = 8
power(0, 10) = 0
power(-2, 5) = -32

corner case
1. b = 0 return 1
2. a = 0 return 0
3. a is negative, determine signal based on even or odd

 */

public class APowerOfB {

  public BigInteger aPowerOfB (int a, int b) {
    if (a == 0) {
      return BigInteger.ZERO;
    }
    if (b == 0) {
      return BigInteger.ONE;
    }
    int signal = b % 2 == 0 ? 1 : -1;
    return aPowerOfBHelper(Math.abs(a), b).multiply(BigInteger.valueOf(signal));
  }

  private BigInteger aPowerOfBHelper(int a, int b) {
    if (b == 1) {
      return BigInteger.valueOf(a);
    }
    BigInteger temp = aPowerOfBHelper(a, b/2).multiply(aPowerOfBHelper(a, b/2));
    if (b % 2 != 0) {
      temp =  temp.multiply(BigInteger.valueOf(a));
    }
    return temp;
  }

  public static void main(String[] args) {
    APowerOfB ap = new APowerOfB();
    int a = -2;
    int b= 5;
    BigInteger tes = BigInteger.valueOf(2);
    System.out.println("first: " + tes);
    BigInteger res = ap.aPowerOfB(a, b);
    System.out.println(res);
  }
}

/*

use recursion: use helper cause signal should not be part of recursion func
  base case: if b == 0, return
  recursive rule:
    if b is even: half * half
    if b is odd: half * half * a
 */
