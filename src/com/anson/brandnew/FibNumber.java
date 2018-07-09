package com.anson.brandnew;

/*
Get the Kth number in the Fibonacci Sequence. (K is 0-indexed, the 0th Fibonacci number is 0 and the 1st Fibonacci number is 1).

Examples

0th fibonacci number is 0
1st fibonacci number is 1
2nd fibonacci number is 1
3rd fibonacci number is 2
6th fibonacci number is 8

corner case
1. 1st fib is 0
2. 2nd fib is 1
&&&&& what if k < 0? we should always return 0.
3. if k is very large, we need to use long or BigInteger

 */

import java.math.BigInteger;

public class FibNumber {

  public BigInteger fibonacci (int k) {
    if (k <= 0) {
      return BigInteger.ZERO;
    }
    if (k == 1) {
      return BigInteger.ONE;
    }
    return fibonacci(k-2).add(fibonacci(k-1));
  }

  public static void main(String[] args) {
    int num = 6;
    FibNumber fn = new FibNumber();
    BigInteger res = fn.fibonacci(num);
    System.out.println(res);
  }
}
