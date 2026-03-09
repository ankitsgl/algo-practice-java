package algo.java.array;

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
}
