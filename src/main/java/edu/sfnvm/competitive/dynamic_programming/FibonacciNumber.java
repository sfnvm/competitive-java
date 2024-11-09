package edu.sfnvm.competitive.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {

  public static void main(String[] args) {
    Map<Long, Long> memoization = new HashMap<>();
    // This shjt rly slow without memoization
    System.out.println(fibonacciNumber(50, memoization));
    memoization = new HashMap<>();
    System.out.println(bottomUpFibonacciNumber(50, memoization));
  }

  public static long fibonacciNumber(long n, Map<Long, Long> memoization) {
    if (memoization.containsKey(n)) {
      return memoization.get(n);
    }

    long result;
    if (n <= 2) {
      result = 1L;
    } else {
      result = fibonacciNumber(n - 1, memoization) + fibonacciNumber(n - 2, memoization);
    }

    memoization.put(n, result);
    return memoization.get(n);
  }

  public static long bottomUpFibonacciNumber(long n, Map<Long, Long> memoization) {
    long result = 0;
    for (long i = 1; i <= n; i++) {
      if (i <= 2) {
        result = 1L;
      } else {
        result = memoization.get(i - 1) + memoization.get(i - 2);
      }
      memoization.put(i, result);
    }
    return result;
  }
}
