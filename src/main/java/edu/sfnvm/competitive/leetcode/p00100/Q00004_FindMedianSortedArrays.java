package edu.sfnvm.competitive.leetcode.p00100;

/**
 * <a href="https://leetcode.com/problems/median-of-two-sorted-arrays">[H] Median of Two Sorted Arrays</a>
 */
public class Q00004_FindMedianSortedArrays {

    public static void main(String[] args) {
        test(new int[]{1, 3, 5}, new int[]{2, 4}, 3);
        test(new int[]{2, 2, 4, 4}, new int[]{2, 2, 2, 4, 4}, 2);
        test(new int[]{1, 2}, new int[]{3, 4}, 2.5);
        test(new int[]{1, 3}, new int[]{2}, 2);
        test(new int[]{1}, new int[]{}, 1);
    }

    public static void test(int[] nums1, int[] nums2, double expected) {
        FindMedianSortedArrays s = new FindMedianSortedArrays();
        var result = s.findMedianSortedArrays2(nums1, nums2);
        System.out.println("result = " + result + ", expedted = " + expected);
    }

    public static class FindMedianSortedArrays {
        /**
         * BAD: Merge Sorted Arrays
         */
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int[] nums = new int[nums1.length + nums2.length];
            int idx = 0;
            int iMark = 0;
            int jMark = 0;
            while (iMark < nums1.length && jMark < nums2.length) {
                if (nums1[iMark] < nums2[jMark]) {
                    nums[idx++] = nums1[iMark++];
                } else {
                    nums[idx++] = nums2[jMark++];
                }
            }
            while (iMark < nums1.length) {
                nums[idx++] = nums1[iMark++];
            }
            while (jMark < nums2.length) {
                nums[idx++] = nums2[jMark++];
            }

            if (idx % 2 == 0) {
                return (nums[idx / 2] + nums[idx / 2 - 1]) / 2.0;
            } else {
                return nums[idx / 2];
            }
        }

        /**
         * Correct: Binary Search
         */
        public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
            // A nums1.length should always smaller than nums2.length
            if (nums1.length > nums2.length) {
                return findMedianSortedArrays2(nums2, nums1);
            }
            int totalLength = nums1.length + nums2.length;
            int half = totalLength / 2;

            int l = 0;
            int r = nums1.length - 1;
            while (true) {
                int i = (l + r) == -1 ? -1 : (l + r) / 2; // A
                int j = half - i - 2; // B

                int aLeft = i >= 0 ? nums1[i] : Integer.MIN_VALUE;
                int aRight = (i + 1) < nums1.length ? nums1[i + 1] : Integer.MAX_VALUE;
                int bLeft = j >= 0 ? nums2[j] : Integer.MIN_VALUE;
                int bRight = (j + 1) < nums2.length ? nums2[j + 1] : Integer.MAX_VALUE;

                if (aLeft <= bRight && bLeft <= aRight) {
                    if (totalLength % 2 == 0) {
                        return (double) (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2;
                    } else {
                        return Math.min(aRight, bRight);
                    }
                } else if (aLeft > bRight) {
                    r = i - 1;
                } else {
                    l = i + 1;
                }
            }
        }
    }
}
