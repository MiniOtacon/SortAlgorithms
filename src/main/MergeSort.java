package main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Austin on 2/24/17.
 */
public class MergeSort extends SortAlgorithm {

    public void sort(int[] array) throws Exception{
        try{
            mergeSort(array);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void runningTime(int numArrays, int arraySize) {

        // Declare list of arrays of type int
        ArrayList<int[]> list = new ArrayList<int[]>();
        long [] durationArray = new long[numArrays];
        long totalDuration = 0;
        long avgDuration = 0;

        // Alloc array and fill with random integers
        // Then add array to ArrayList.
        for (int i = 0; i < numArrays; ++i) {
            int[] array = new int[arraySize];
            for (int j = 0; j < array.length; ++j) {
                Random r = new Random();
                int randomNum = r.nextInt();
                array[j] = randomNum;
            }
            list.add(i, array);
        }

        // Iterate through list, using system time to determine how long shellSort algorithm takes.
        for(int i = 0; i < list.size(); ++i) {
            long startTime = System.nanoTime();
            mergeSort(list.get(i));
            long endTime = System.nanoTime();
            long duration = ((endTime - startTime)/1000000);  //divide by 1000000 to get milliseconds
            durationArray[i] = duration;
            totalDuration += duration;
        }
        // Display duration stats.
        avgDuration = totalDuration/list.size();
        System.out.print("Array Size: " + arraySize + ", ");
        //System.out.println("Sort Times: " + Arrays.toString(durationArray));
        System.out.println("Average Merge Sort time: " + avgDuration + " milliseconds.");
    }

    public int[] mergeSort(int[] array) {
        if(array != null){
            // Base case, one or zero elements remaining in array
            if (array.length <= 1) {
                return array;
            }
            // Make local arrays to store each half of original array
            int[] left = new int[array.length / 2];
            int[] right = new int[array.length - left.length];

            // Copy first half of integers into left
            System.arraycopy(array, 0, left, 0, left.length);

            // Copy second half of integers into right
            System.arraycopy(array, left.length, right, 0, right.length);

            // recursive call on first half
            mergeSort(left);

            // recursive call on second half
            mergeSort(right);

            // combine sorted
            merge(left, right, array);
            return array;
        }
        return null;
    }

    public void merge(int[] left, int[] right, int[] result) {
        int i = 0;
        int j = 0;
        int k = 0;

        int i1 = left[i];
        int i2 = right[j];

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k] = left[i];
                ++i;
            } else {
                result[k] = right[j];
                ++j;
            }
            ++k;
        }
        System.arraycopy(left, i, result, k, left.length - i);
        System.arraycopy(right, j, result, k, right.length - j);
    }

    public static void main(String[] args) {

        int numArraysToSort = 10;
        int arraySize = 1000;

        MergeSort obj = new MergeSort();

        System.out.println("-- Merge Sort Stats -- ");
        for(int i = 0; i < 5; ++i) {
            obj.runningTime(numArraysToSort, arraySize);
            arraySize *= 10;
        }
    }
}
