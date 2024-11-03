package edu.sfnvm.competitive.leetcode.p00100;

import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters">
 * [M] Longest Substring Without Repeating Characters
 * </a>
 */
public class Q00003_LengthOfLongestSubstring {

    public static void main(String[] args) {
        Solution s = new Solution();

        // Test 01
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));

        // Test 02
        System.out.println(s.lengthOfLongestSubstring(null));

        // Test 03
        System.out.println(s.lengthOfLongestSubstring(""));
    }

    /**
     * Sliding Windows Problem
     */
    public static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }
            if (s.length() == 1) {
                return 1;
            }

            HashSet<Character> hset = new HashSet<>();
            int iPointer = 0;
            int jPointer = 0;
            int max = 0;
            while (jPointer < s.length()) {
                if (!hset.contains(s.charAt(jPointer))) {
                    hset.add(s.charAt(jPointer));
                    jPointer++;
                    max = Math.max(hset.size(), max);
                } else {
                    hset.remove(s.charAt(iPointer));
                    iPointer++;
                }
            }
            return max;
        }
    }
}
