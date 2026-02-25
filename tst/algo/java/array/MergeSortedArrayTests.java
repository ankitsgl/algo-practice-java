package algo.java.array;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import algo.java.utils.ArrayUtils;


public class MergeSortedArrayTests {
    MergeSortedArray sut = new MergeSortedArray();

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
}
