package edu.sfnvm.competitive.codility.lesson;

/**
 * <a href="https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/">
 * Lession 3: Time Complexity - PermMissingElem
 * </a>
 */
public class L00003_2_TimeComplexity_PermMissingElem {

  public static void main(String[] args) {
    test(new int[]{2, 3, 1, 5}, 4);
    test(new int[]{2, 3, 1, 4}, 5);
    test(new int[]{}, 1);
    test(new int[]{1}, 2);
  }

  public static void test(int[] input, int expected) {
    PermMissingElem s = new PermMissingElem();
    var result = s.solution(input);
    System.out.printf("Result %s - Expected %s%n", result, expected);
  }

  public static class PermMissingElem {

    public int solution(int[] a) {
      if (a.length == 0) {
        return 1;
      }

      int threshhold = 100000;
      int totalFactorial = 0;
      int total = 0;
      int idx = 0;
      while (idx < a.length) {
        totalFactorial += idx + 1;
        total += a[idx];
        if (totalFactorial > threshhold && total > threshhold) {
          totalFactorial -= threshhold;
          total -= threshhold;
        }
        idx++;
      }

      if (totalFactorial - total < 0) {
        totalFactorial = totalFactorial + idx + 1;
      }

      return totalFactorial - total == 0 ? idx + 1 : totalFactorial - total;
    }
  }
}
