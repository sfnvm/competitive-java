package edu.sfnvm.competitive.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/two-sum/">[E] Problem: Two Sum</a>
 */
public class Q0001_TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        Solution s = new Solution();
        int[] result = s.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }

    public static class Solution {

        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return new int[]{0};
        }
    }
}
