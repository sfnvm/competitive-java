package edu.sfnvm.competitive.codility.lesson;

/**
 * <a href="https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/">
 * Lession 3: Time Complexity - [E] TapeEquilibrium
 * </a>
 */
public class L00003_3_TimeComplexity_TapeEquilibrium {

  public static void main(String[] args) {
    test(new int[]{}, 0);
    test(new int[]{1}, 1);
    test(new int[]{1, 2}, 1);
    test(new int[]{3, 1, 2, 4, 3}, 1);
    test(new int[]{1, 1, 3}, 1);
    test(new int[]{-10, -20, -30, -40, 100}, 20);
  }

  public static void test(int[] input, int expected) {
    PermMissingElem s = new PermMissingElem();
    var result = s.solution2(input);
    System.out.printf("Result %s - Expected %s%n", result, expected);
  }

  @SuppressWarnings("DuplicatedCode")
  public static class PermMissingElem {

    public int solution(int[] a) {
      if (a.length == 0) {
        return 0;
      }
      if (a.length == 1) {
        return a[0];
      }
      if (a.length == 2) {
        return a[0] > a[1] ? a[0] - a[1] : a[1] - a[0];
      }

      int rs = Integer.MAX_VALUE;
      for (int i = 1; i < a.length; i++) {
        if (rs == 0) {
          break;
        }

        // Sum left part
        int sumL = 0;
        for (int l = 0; l < i; l++) {
          sumL += a[l];
        }

        // Sum right part
        int sumR = 0;
        for (int r = i; r < a.length; r++) {
          sumR += a[r];
        }

        int diff = sumL > sumR ? sumL - sumR : sumR - sumL;

        if (diff < rs) {
          rs = diff;
        }
      }

      return rs;
    }

    public int solution2(int[] a) {
      if (a.length == 0) {
        return 0;
      }
      if (a.length == 1) {
        return a[0];
      }
      if (a.length == 2) {
        return a[0] > a[1] ? a[0] - a[1] : a[1] - a[0];
      }

      int rs;
      int sumL = a[0];
      int sumR = 0;
      for (int i = 1; i < a.length; i++) {
        sumR += a[i];
      }

      rs = sumR > sumL ? sumR - sumL : sumL - sumR;

      for (int i = 1; i < a.length - 1; i++) {
        sumL += a[i];
        sumR -= a[i];
        int diff = sumR > sumL ? sumR - sumL : sumL - sumR;
        if (rs > diff) {
          rs = diff;
        }
      }

      return rs;
    }
  }
}
