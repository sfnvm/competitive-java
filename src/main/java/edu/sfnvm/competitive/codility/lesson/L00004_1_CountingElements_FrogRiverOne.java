package edu.sfnvm.competitive.codility.lesson;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/">
 * Lession 4: Counting Elements - [E] FrogRiverOne
 * </a>
 */
public class L00004_1_CountingElements_FrogRiverOne {

  public static void main(String[] args) {
    test(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}, 6);
    test(5, new int[]{1, 3, 5}, -1);
    test(5, new int[]{5}, -1);
    test(1, new int[]{1}, 0);
  }

  public static void test(int x, int[] a, int expected) {
    FrogRiverOne sol = new FrogRiverOne();
    var result = sol.solution(x, a);
    System.out.printf("Result %s - Expected %s%n", result, expected);
  }

  public static class FrogRiverOne {

    public int solution(int x, int[] a) {
      // The frog is never able to jump to the other side of the river.
      int rs = -1;
      Set<Integer> steps = new HashSet<>();
      for (int i = 1; i <= x; i++) {
        steps.add(i);
      }
      for (int i = 0; i < a.length; i++) {
        steps.remove(a[i]);
        if (steps.isEmpty()) {
          return i;
        }
      }
      return rs;
    }
  }
}
