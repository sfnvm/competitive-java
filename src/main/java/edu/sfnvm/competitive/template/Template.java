package edu.sfnvm.competitive.template;

/**
 * <a href="">Problem Origin</a>
 */
public class Template {

  public static void main(String[] args) {
    test("Hello World!", "Hello World!");
  }

  public static void test(String input, String expected) {
    Solution sol = new Solution();
    var result = sol.resolveMethod(input);
    System.out.printf("Result %s - Expected %s%n", result, expected);
  }

  public static class Solution {

    public String resolveMethod(String input) {
      return input;
    }
  }
}
