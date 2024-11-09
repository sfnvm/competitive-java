package edu.sfnvm.competitive.leetcode.p00100;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-substring">Longest Palindromic
 * Substring</a>
 */
public class Q00005_LongestPalindrome {

  public static void main(String[] args) {
    test("abbaasd");
  }

  public static void test(String input) {
    LongestPalindrome s = new LongestPalindrome();
    var result = s.longestPalindrome(input);
    System.out.println(result);
  }

  /**
   * Dynamic Programming: Using Expansion from center
   */
  public static class LongestPalindrome {

    public String longestPalindrome(String s) {
      int start = 0, maxLen = 1;
      char[] chars = s.toCharArray();

      for (int i = 0; i < chars.length - 1; i++) {
        for (int j = 0; j <= 1; j++) {
          int l = i;
          int r = i + j;
          while (l >= 0 && r < chars.length && chars[l] == chars[r]) {
            if ((r - l + 1) > maxLen) {
              start = l;
              maxLen = r - l + 1;
            }
            l--;
            r++;
          }
        }
      }
      return s.substring(start, start + maxLen);
    }
  }
}
