package edu.sfnvm.competitive.leetcode.p00100;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/zigzag-conversion">Zigzag Conversion</a>
 */
public class Q00006_ZigzagConversion {

    public static void main(String[] args) {
        test("AB", 1);
        test("PAYPALISHIRING", 3);
        test("PAYPALISHIRING", 4);
        test("A", 1);
    }

    public static void test(String input, int numRows) {
        Solution s = new Solution();
        var result = s.diyConvert2(input, numRows);
        System.out.println(result);
    }

    public static class Solution {
        public String diyConvert(String s, int numRows) {
            String[] matrix = new String[numRows];
            Arrays.fill(matrix, "");
            int index = 0;
            int cycle = 0;
            char[] chars = s.toCharArray();
            while (index < s.length()) {
                for (int i = 0; i < numRows; i++) {
                    if ((index - i - cycle * (numRows - 2)) % numRows == 0) {
                        matrix[i] = matrix[i] + chars[index];
                        index++;
                        if (i == numRows - 1) {
                            cycle++;
                        }
                    } else {
                        // Add one element in "middle" rows.
                        int matrixIdx = numRows - (index - i - cycle * (numRows - 2)) % numRows;
                        matrix[matrixIdx] = matrix[matrixIdx] + chars[index];
                        index++;
                        break;
                    }
                    if (index > chars.length - 1) {
                        break;
                    }
                }
            }

            // Return result
            StringBuilder sb = new StringBuilder();
            for (String string : matrix) {
                sb.append(string);
            }
            return sb.toString();
        }

        public String diyConvert2(String s, int numRows) {
            String[] matrix = new String[numRows];
            Arrays.fill(matrix, "");
            int row = 0;
            boolean down = true;
            char[] chars = s.toCharArray();

            for (char c : chars) {
                matrix[row] += c;
                if (row == numRows - 1) {
                    down = false;
                } else if (row == 0) {
                    down = true;
                }
                if (down) {
                    row++;
                } else {
                    row = row == 0 ? 0 : row - 1;
                }
            }

            // Return result
            StringBuilder sb = new StringBuilder();
            for (String string : matrix) {
                sb.append(string);
            }
            return sb.toString();
        }
    }
}
