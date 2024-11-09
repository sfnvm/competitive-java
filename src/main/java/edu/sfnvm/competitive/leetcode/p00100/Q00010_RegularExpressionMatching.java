package edu.sfnvm.competitive.leetcode.p00100;

import java.util.HashMap;
import java.util.Map;

public class Q00010_RegularExpressionMatching {

  public static void main(String[] args) {
    test("aa", "a");
    test("aa", "a*");
    test("ab", ".*");
    test("aaaaaaaaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*");
  }

  public static void test(String s, String p) {
    RegularExpressionMatching sol = new RegularExpressionMatching();
    var result = sol.isMatch(s, p);
    System.out.println(result);
  }

  /**
   * Dynamic Programming: Decision Tree
   * Top-Down Memoization
   */
  public static class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
      Map<String, Boolean> cache = new HashMap<>();
      return dfs(0, 0, s, p, cache);
    }

    public boolean dfs(int si, int pi, String s, String p, Map<String, Boolean> cache) {
      if (cache.containsKey(si + "" + pi)) {
        return cache.get(si + "" + pi);
      }
      if (si >= s.length() && pi >= p.length()) {
        return true;
      }
      if (pi >= p.length()) {
        return false;
      }

      boolean match = si < s.length()
          && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.');
      if ((pi + 1) < p.length() && p.charAt(pi + 1) == '*') {
        cache.put(si + "" + pi, dfs(si, pi + 2, s, p, cache)
            || (match && dfs(si + 1, pi, s, p, cache)));
        return cache.get(si + "" + pi);
      }
      if (match) {
        cache.put(si + "" + pi, dfs(si + 1, pi + 1, s, p, cache));
        return cache.get(si + "" + pi);
      }

      cache.put(si + "" + pi, false);
      return false;
    }
  }
}
