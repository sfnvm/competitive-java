package edu.sfnvm.competitive.codility.lesson;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/">
 * Lession 4: Counting Elements - [E] PermCheck
 * </a>
 */
public class L00004_2_CountingElements_PermCheck {

  public static void main(String[] args) {
    test(new int[]{4, 1, 3, 2}, 1);
    test(new int[]{4, 1, 3}, 0);
    test(new int[]{2, 4, 3}, 0);
    test(new int[]{2, 4, 5}, 0);
    test(new int[]{}, 0);
    test(new int[]{9}, 0);
    test(new int[]{8, 9}, 1);
    test(new int[]{8, 10}, 0);
    test(new int[]{Integer.MAX_VALUE}, 0);
    test(new int[]{1}, 1);
  }

  public static void test(int[] x, int expected) {
    PermCheck sol = new PermCheck();
    var result = sol.solution(x);
    System.out.printf(
        "Input %s%nResult %s - Expected %s%n%n",
        Arrays.toString(x),
        result,
        expected
    );
  }

  public static class PermCheck {

    public int solution(int[] x) {
      if (x.length == 0) {
        return 0;
      }
      if (x.length == 1) {
        return x[0] == 1 ? 1 : 0;
      }

      Set<Integer> set = new HashSet<>();

      // Not a permutation array.
      int max = 0;

      // Create a set of unique elements.
      for (int j : x) {
        if (set.contains(j)) {
          return 0;
        }
        set.add(j);
        if (j > max) {
          max = j;
        }
      }

      // This fucker should start from 1
      if (max >= x.length + 1) {
        return 0;
      }

      // Check backward.
      for (int i = 0; i < x.length; i++) {
        if (!set.contains(max - i)) {
          return 0;
        }
      }

      return 1;
    }
  }
}
