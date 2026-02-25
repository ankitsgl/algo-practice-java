package algo.java.array;

public class MergeSortedArray {

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
}
