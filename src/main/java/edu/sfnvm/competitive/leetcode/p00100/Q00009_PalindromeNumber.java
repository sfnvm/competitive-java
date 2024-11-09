package edu.sfnvm.competitive.leetcode.p00100;

/**
 * <a href="https://leetcode.com/problems/palindrome-number">Palindrome Number</a>
 */
public class Q00009_PalindromeNumber {

  public static void main(String[] args) {
    test(123);
    test(121);
    test(1221);
    test(10);
    test(1000021);
    test(1410110141);
  }

  public static void test(int input) {
    PalindromeNumber s = new PalindromeNumber();
    var result = s.isPalindrome(input);
    System.out.println(result);
  }

  @SuppressWarnings("unused")
  public static class PalindromeNumber {

    public boolean naiveIsPalindrome(int x) {
      if (x < 0) {
        return false;
      } else if (x < 10) {
        return true;
      }

      StringBuilder strRs = new StringBuilder();
      while (x / 10 != 0) {
        strRs.append(x % 10);
        x = x / 10;
      }
      strRs.append(x);

      boolean rs = true;
      for (int i = 0; i < strRs.length() / 2; i++) {
        if (strRs.charAt(i) != strRs.charAt(strRs.length() - 1 - i)) {
          rs = false;
          break;
        }
      }

      return rs;
    }

    public boolean isPalindrome(int x) {
      if (x < 0) {
        return false;
      } else if (x < 10) {
        return true;
      }

      int div = 1;
      int divB = 1;
      // Detect devider
      while (x >= (10 * div)) {
        if (div >= 1000000000) {
          break;
        } else {
          div *= 10;
        }
      }

      while (true) {
        if (x == 0 || div == 0) {
          return true;
        }
        if (x / div != x % 10) {
          return false;
        }
        x = x % div / 10;
        div = div / 100;
      }
    }
  }
}
