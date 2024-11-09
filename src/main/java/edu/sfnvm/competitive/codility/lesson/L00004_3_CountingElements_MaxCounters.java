package edu.sfnvm.competitive.codility.lesson;

import java.util.Arrays;

/**
 * <a href="https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/">
 * Lession 4: Counting Elements - [M] MaxCounters
 * </a>
 */
public class L00004_3_CountingElements_MaxCounters {

  public static void main(String[] args) {
    test(5, new int[]{3, 4, 4, 6, 6, 1, 4, 4}, new int[]{3, 2, 2, 4, 2});
  }

  public static void test(int n, int[] a, int[] expected) {
    MaxCounters sol = new MaxCounters();
    var result = sol.solution(n, a);
    System.out.printf(
        "Result %s - Expected %s%n%n",
        Arrays.toString(result),
        Arrays.toString(expected)
    );
  }

  public static class MaxCounters {

    public int[] solution(int n, int[] a) {
      int[] rs = new int[n];
      int max = 0;
      int lastSync = 0;
      for (int j : a) {
        if (1 <= j && j <= rs.length) {
          rs[j - 1] = Math.max(rs[j - 1], lastSync);
          rs[j - 1]++;
          max = Math.max(rs[j - 1], max);
        }
        if ((j == rs.length + 1)) {
          lastSync = max;
        }
      }

      for (int i = 0; i < rs.length; i++) {
        rs[i] = Math.max(rs[i], lastSync);
      }
      return rs;
    }
  }
}
