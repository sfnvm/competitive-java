package edu.sfnvm.competitive.codility.lesson;

import java.util.Arrays;

/**
 * <a href="https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/">
 * Lession 2: Arrays - [E] CyclicRotation
 * </a>
 */
public class L00002_1_Arrays_CyclicRotation {

  public static void main(String[] args) {
    test(new int[]{3, 8, 9, 7, 6}, 3, new int[]{9, 7, 6, 3, 8});
    test(new int[]{1, 2, 3, 4}, 4, new int[]{1, 2, 3, 4});
    test(new int[]{}, 4, new int[]{});
    test(new int[]{1}, 4, new int[]{1});
    test(new int[]{1, 2}, 4, new int[]{1, 2});
  }

  public static void test(int[] input, int rotation, int[] expected) {
    CyclicRotation solution = new CyclicRotation();
    int[] result = solution.solution(input, rotation);
    System.out.println("Result: " + Arrays.toString(result)
        + ", Expected: " + Arrays.toString(expected)
    );
  }

  public static class CyclicRotation {

    public int[] solution(int[] n, int k) {
      if (n.length <= 1) {
        return n;
      }
      int[] rs = new int[n.length];
      k = k % n.length;
      for (int i = 0; i < n.length; i++) {
        int tmpIdx = i + k + 1 > n.length ? i + k + 1 - n.length : i + k + 1;
        rs[tmpIdx - 1] = n[i];
      }
      return rs;
    }
  }
}
