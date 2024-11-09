package edu.sfnvm.competitive.leetcode.p00100;

/**
 * <a href="https://leetcode.com/problems/string-to-integer-atoi">
 * String to Integer (atoi)
 * </a>
 */
public class Q00008_StringToIntegerAtoi {

  public static void main(String[] args) {
    test("abbaasd");
    test("  00001111");
    test("111111");
    test("111111  ");
    test("0-1");
    test("1337c0d3");
    test("words and 987");
    test("   -042");
    test(" -042");
    test("-91283472332");
    test("");
    test(" ");
    test("2147483648");
  }

  public static void test(String input) {
    StringToIntegerAtoi s = new StringToIntegerAtoi();
    var result = s.myAtoi(input);
    System.out.println(result);
  }

  public static class StringToIntegerAtoi {

    public int myAtoi(String s) {
      int rs = 0;
      int idx = 0;
      boolean negative = false;

      while (idx < s.length() && s.charAt(idx) == ' ') {
        idx++;
      }

      if (idx < s.length() && (s.charAt(idx) == '-' || s.charAt(idx) == '+')) {
        if (s.charAt(idx++) == '-') {
          negative = true;
        }
      }

      while (idx < s.length() && s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
        // Overflow/Underflow
        if (rs > Integer.MAX_VALUE / 10
            || (rs == Integer.MAX_VALUE / 10 && s.charAt(idx) - '0' > 7)) {
          return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        rs = rs * 10 + s.charAt(idx++) - '0';
      }

      return negative ? -rs : rs;
    }
  }
}
