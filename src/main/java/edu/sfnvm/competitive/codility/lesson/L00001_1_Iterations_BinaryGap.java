package edu.sfnvm.competitive.codility.lesson;

/**
 * <a href="https://app.codility.com/programmers/lessons/1-iterations/binary_gap/">
 * Lession 1: Iterations - [E] BinaryGap
 * </a>
 */
public class L00001_1_Iterations_BinaryGap {

  public static void main(String[] args) {
    test(1162, 3);
    test(66561, 9);
    test(51712, 2);
    test(6291457, 20);
    test(805306373, 25);
    test(1610612737, 28);
  }

  public static void test(int input, int expected) {
    BinaryGap solution = new BinaryGap();
    int result = solution.solution(input);
    System.out.println("Result: " + result + ", Expected: " + expected);
  }

  public static void printArray(int[] array, int length) {
    StringBuilder sb = new StringBuilder();
    for (int i = length - 1; i >= 0; i--) {
      sb.append(array[i]);
    }
    System.out.println(sb);
  }

  public static class BinaryGap {

    public int solution(int n) {
      int[] binary = new int[35];
      int id = 0, binaryGap = 0, maxBinaryGap = 0;
      boolean counting = false;
      // Get bin array in reverse order
      while (n > 0) {
        int fraction = n % 2;
        binary[id++] = fraction;
        n /= 2;
      }

      printArray(binary, id);

      // Reverse loop
      for (int i = id - 1; i >= 0; i--) {
        if (binary[i] == 1 && !counting) {
          counting = true;
        } else if (binary[i] == 0 && counting) {
          binaryGap++;
        } else if (binary[i] == 1 && counting) {
          if (maxBinaryGap < binaryGap) {
            maxBinaryGap = binaryGap;
          }
          binaryGap = 0;
        }
      }
      return maxBinaryGap;
    }
  }
}
