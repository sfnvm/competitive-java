package edu.sfnvm.competitive.codility.lesson;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/">
 * Lession 4: Counting Elements - [M] MissingInteger
 * </a>
 */
public class L00004_4_CountingElements_MissingInteger {

  public static void main(String[] args) {
    test(new int[]{1, 3, 6, 4, 1, 2}, 5);
    test(new int[]{-1, -3, 6, 4, 1, 2}, 3);
  }

  public static void test(int[] a, int expected) {
    MissingInteger sol = new MissingInteger();
    var result = sol.solution(a);
    System.out.printf(
        "Result %s - Expected %s%n%n",
        result,
        expected
    );
  }

  public static class MissingInteger {

    public int solution(int[] a) {
      int rs = 1;
      Set<Integer> set = new HashSet<>();
      for (int n : a) {
        if (n > 0) {
          set.add(n);
        }
      }

      while (set.contains(rs)) {
        rs++;
      }

      return rs;
    }
  }
}
