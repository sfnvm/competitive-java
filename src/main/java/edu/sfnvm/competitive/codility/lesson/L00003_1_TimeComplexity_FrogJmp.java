package edu.sfnvm.competitive.codility.lesson;

/**
 * <a href="https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/">
 * Lession 3: Time Complexity - FrogJmp
 * </a>
 */
public class L00003_1_TimeComplexity_FrogJmp {

  public static void main(String[] args) {
    test(10, 85, 90, 1);
    test(10, 85, 30, 3);
  }

  public static void test(int x, int y, int d, int expected) {
    FrogJmp s = new FrogJmp();
    var result = s.solution(x, y, d);
    System.out.printf("Result %s - Expected %s%n", result, expected);
  }

  public static class FrogJmp {

    public int solution(int x, int y, int d) {
      if (x > y || x == y) {
        return 0;
      }
      int rs = (y - x) / d;
      return x + d * rs < y ? rs + 1 : rs;
    }
  }
}
