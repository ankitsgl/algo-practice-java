package algo.java.area;

import algo.java.utils.ArrayUtils;

public class MaximalSquare {

    /*
    Leetcode: https://leetcode.com/problems/maximal-square/description/
    g4g: https://www.geeksforgeeks.org/dsa/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/

    Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
    */
    public int maximalSquare(char[][] matrix) {
        // This is a bruitforce solution
        int[] ans = new int[1];
        maximalSquareRec(0, 0, matrix, ans);
        return ans[0];
    }

    private int maximalSquareRec(int row, int col, char[][] matrix, int[] ans) {
        if (row < 0 || row == matrix.length || col < 0 || col == matrix[0].length) {
            return 0;
        }

        // calculate sides 
        int right = maximalSquareRec(row + 1, col, matrix, ans);
        int down = maximalSquareRec(row, col + 1, matrix, ans);
        int diag = maximalSquareRec(row +1 , col + 1, matrix, ans);

        if (matrix[row][col] != '1') {
            return 0;
        }

        int val = 1 + Math.min(right, Math.min(down, diag));
        ans[0] = Math.max(ans[0], val);
        return val;
    }

    public static void main(String[] args) {
        char[][] metrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };

        ArrayUtils.printArray(metrix);
        int result = new MaximalSquare().maximalSquare(metrix);
        System.out.println("Max square size is: %s x %s".formatted(result, result));
    }
}
