package edu.sfnvm.competitive.codility.lesson;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/">
 * Lession 2: Arrays - [E] OddOccurrencesInArray
 * </a>
 */
public class L00002_2_Arrays_OddOccurrencesInArray {

  public static void main(String[] args) {
    test(new int[]{0}, 0);
    test(new int[]{9}, 9);
    test(new int[]{9, 3, 9}, 3);
    test(new int[]{9, 3, 9, 3, 9, 7, 9}, 7);
    test(new int[]{2, 2, 3, 3, 4}, 4);
  }

  public static void test(int[] input, int expected) {
    OddOccurrencesInArray solution = new OddOccurrencesInArray();
    int result = solution.solution(input);
    System.out.println("Result: " + result + ", Expected: " + expected);
  }

  public static class OddOccurrencesInArray {

    @SuppressWarnings("ExtractMethodRecommender")
    public int solution(int[] n) {
      if (n.length == 0) {
        return 0;
      }
      if (n.length == 1) {
        return n[0];
      }
      if (n.length % 2 == 0) {
        return 0;
      }

      int half = n.length / 2;
      Set<Integer> cDup = new HashSet<>();
      cDup.add(n[half]);
      for (int i = 0; i < half; i++) {
        int l = half - i - 1;
        int r = half + i + 1;
        if (cDup.contains(n[l])) {
          cDup.remove(n[l]);
        } else {
          cDup.add(n[l]);
        }
        if (cDup.contains(n[r])) {
          cDup.remove(n[r]);
        } else {
          cDup.add(n[r]);
        }
      }
      if (cDup.size() > 1) {
        return 0;
      }

      return cDup.isEmpty() ? 0 : cDup.iterator().next();
    }
  }
}
