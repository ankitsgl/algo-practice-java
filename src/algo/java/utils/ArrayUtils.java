package algo.java.utils;

import java.util.Arrays;

public class ArrayUtils {
    public static void printArray(int[] array){
        System.out.print(Arrays.toString(array)); 
    }

    public static int[] mergeArray(int[] arrayA, int[] arrayB){
        int[] expectedMergedArray = new int[arrayA.length + arrayB.length];
        System.arraycopy(arrayA, 0, expectedMergedArray, 0, arrayA.length);
        System.arraycopy(arrayB, 0, expectedMergedArray, arrayA.length, arrayB.length);
        return expectedMergedArray;
    }

    public static void printArray(char[][] grid){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + ",");
            }
            System.out.println();  
        }
    }

    public static void printArray(int[][] grid){
        for (int i = 0; i < grid.length; i++) {
            System.out.print("%s: [".formatted(i));
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + ",");
            }
            System.out.print("]");
            System.out.println();
        }
    }
}
