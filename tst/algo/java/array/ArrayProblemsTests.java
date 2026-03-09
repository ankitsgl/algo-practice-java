package algo.java.array;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import algo.java.utils.ArrayUtils;

import static org.junit.jupiter.api.Assertions.*;


public class ArrayProblemsTests {
    ArrayProblems sut = new ArrayProblems();

    @Test void mergeSortedArray() {
        System.out.println("Starting mergeSortedArray...");
        // Setup
        int[] arrayA = {1,2,3};
        int[] arrayB = {2,5,6};

        int[] expectedMergedArray = ArrayUtils.mergeArray(arrayA, arrayB);
        Arrays.sort(expectedMergedArray);

        // Test
        var mergedArray = sut.mergeSortedArray(arrayA, arrayB);

        // Assert
        System.out.println("Array A: :" + Arrays.toString(arrayA)); 
        System.out.println("Array B: :" + Arrays.toString(arrayB)); 
        System.out.println("Expected: :" + Arrays.toString(expectedMergedArray)); 
        System.out.println("Actual :" + Arrays.toString(mergedArray)); 

        assertEquals(expectedMergedArray.length, mergedArray.length);
        assertTrue(Arrays.equals(expectedMergedArray, mergedArray));
    }

    @Test void mergeSortedArray_test2() {
        System.out.println("Starting mergeSortedArray_test2...");
        // Setup
        int[] arrayA = {2,5,6};
        int[] arrayB = {1,2,3,4,8};

        int[] expectedMergedArray = ArrayUtils.mergeArray(arrayA, arrayB);
        Arrays.sort(expectedMergedArray);

        // Test
        var mergedArray = sut.mergeSortedArray(arrayA, arrayB);

        // Assert
        System.out.println("Array A: :" + Arrays.toString(arrayA)); 
        System.out.println("Array B: :" + Arrays.toString(arrayB)); 
        System.out.println("Expected: :" + Arrays.toString(expectedMergedArray)); 
        System.out.println("Actual :" + Arrays.toString(mergedArray)); 

        assertEquals(expectedMergedArray.length, mergedArray.length);
        assertTrue(Arrays.equals(expectedMergedArray, mergedArray));
    }

    @Test
    public void sumTwo_test() {
        int[] array = {1,2,4,7,15};
        int[] result = sut.sumTwo(array, 11);
        assertEquals(2, result.length);
        assertEquals(2, result[0]);
        assertEquals(3, result[1]);

        result = sut.sumTwo(array, 9);
        assertEquals(2, result.length);
        assertEquals(1, result[0]);
        assertEquals(3, result[1]);


        result = sut.sumTwo(array, 20);
        assertNull(result);
    }
}
