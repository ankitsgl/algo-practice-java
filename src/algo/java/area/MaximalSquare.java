package algo.java.area;

import java.util.Arrays;

import algo.java.utils.ArrayUtils;

public class MaximalSquare {

    /*
    Leetcode: https://leetcode.com/problems/maximal-square/description/
    g4g: https://www.geeksforgeeks.org/dsa/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/

    Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

    Key idea: 
    1. For each cell, caculate the size of filled blocks towards right, down and diagonal. 
    2. Take the minimum of all three directions and add 1. 
    3. Recursively calculate the size of blocks for right, down and diagonal directions.
    4. Store the maximum size of square in answer. 
    5. Return current size.
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

    public int maximalSquareOptimized(char[][] matrix) {
        // This is a bruitforce solution
        int[][] memory = new int[matrix.length][matrix[0].length];
        for(int[]row : memory) {
            Arrays.fill(row, -1);
        }

        int[] ans = new int[1];
        maximalSquareRecWithMemory(0, 0, matrix, memory, ans);
        return ans[0];
    }

    private int maximalSquareRecWithMemory(int row, int col, char[][] matrix, int[][] memory, int[] ans) {
        if (row < 0 || row == matrix.length || col < 0 || col == matrix[0].length) {
            return 0;
        }

        // Lookup in memory and return if already calculated
        if (memory[row][col] != -1) {
            return memory[row][col];
        }

        // calculate sides 
        int right = maximalSquareRecWithMemory(row + 1, col, matrix, memory, ans);
        int down = maximalSquareRecWithMemory(row, col + 1, matrix, memory,ans);
        int diag = maximalSquareRecWithMemory(row +1 , col + 1, matrix, memory, ans);

        if (matrix[row][col] != '1') {
            return 0;
        }

        int val = 1 + Math.min(right, Math.min(down, diag));
        ans[0] = Math.max(ans[0], val);
        memory[row][col] = val;
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
