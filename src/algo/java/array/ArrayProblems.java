package algo.java.array;

import java.util.Arrays;
import java.util.HashMap;

public class ArrayProblems {

    public int[] mergeSortedArray(int[] arrayA, int[]arrayB) {
        int[] result = new int[arrayA.length + arrayB.length];
        int i = 0, j = 0, k = 0;         

        // Merge comparable index
        while(i < arrayA.length && j < arrayB.length){
            if(arrayA[i] < arrayB[j]){
                result[k++] = arrayA[i++];
            } else {
                result[k++] = arrayB[j++];
            }
        }

        // Merge remaining from arrayA
        while(i < arrayA.length){
            result[k++] = arrayA[i++];
        }

        // Merge remaining from arrayB
        while(j < arrayB.length){
            result[k++] = arrayB[j++];
        }

        return result;
    }

    /*
    Leet coed: https://leetcode.com/problems/two-sum/description/

    Submission: https://leetcode.com/problems/two-sum/submissions/1942377229/
     */
    public int[] sumTwo(int[] nums, int target) {
        HashMap<Integer, Integer> memory = new HashMap<>();
        for(int index = 0; index < nums.length; index++) {
            Integer difference = target - nums[index];
            if(memory.containsKey(difference)) {
                return new int[]{memory.get(target - nums[index]), index};
            }
            memory.put(nums[index], index);
        }
        return null;
    }

    /*
    Leetcode: https://leetcode.com/problems/largest-number/
    Submission: https://leetcode.com/problems/largest-number/submissions/1945512331/
    Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
    Since the result may be very large, so you need to return a string instead of an integer.
    Example 1:
        Input: nums = [10,2]
        Output: "210"
        Example 2:

        Input: nums = [3,30,34,5,9]
        Output: "9534330"
     */
    public int largestNumber(int[] nums) {
        String[] strArray = new String[nums.length];
        for(int index = 0; index < nums.length; index++) {
            strArray[index] = String.valueOf(nums[index]);
        }
        // Custom sort to compare concatenated string
        Arrays.sort(strArray, (a, b) -> (b + a).compareTo(a + b));
        if ("0".equals(strArray[0])) {
            return 0;
        }

        return Integer.parseInt(String.join("", strArray));
    }
}
