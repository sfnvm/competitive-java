package edu.sfnvm.competitive.leetcode.p00100;

/**
 * <a href="https://leetcode.com/problems/reverse-integer">
 * Reverse Integer
 * </a>
 */
public class Q00007_ReverseInteger {

    public static void main(String[] args) {
        test(Integer.MAX_VALUE);
    }

    public static void test(int input) {
        Solution s = new Solution();
        var result = s.reverse(input);
        System.out.println(result);
    }

    public static class Solution {
        public int reverse(int x) {
            boolean neg = false;
            if (x < 0) {
                neg = true;
                x = -x;
            }

            int prevRevNum = 0;
            int revNum = 0;
            while (x != 0) {
                int curDigit = x % 10;
                revNum = (revNum * 10) + curDigit;

                // Check overflow
                if ((revNum - curDigit) / 10 != prevRevNum) {
                    return 0;
                }

                prevRevNum = revNum;
                x = x / 10;
            }

            return neg ? -revNum : revNum;
        }
    }
}
