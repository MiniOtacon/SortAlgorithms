package main;

/**
 * Created by Austin on 2/24/17.
 */
public abstract class SortAlgorithm {
    public abstract void sort(int [] array) throws Exception;
    public abstract void runningTime(int numArrays, int arraySize);
    public boolean isSorted(int[] array){
        for(int i = 0; i < array.length -1; ++i){
            if (array[i] > array[i+1]) {
                return false; // Not sorted
            }
        }
        return true;
    }

    //25,600,000
    public static void main(String [] args){
        // number of arrays to shellSort is the number of times the algorithm will
        // run on an array. The array size is the size of the array to be sorted.
        int numArraysToSort = 10;
        int arraySize = 50000;
        int numScales = 10;

        SortAlgorithm mergeSort = new MergeSort();
        SortAlgorithm shellSort = new ShellSort();

        System.out.println("-- Merge Sort Stats -- ");
        for(int i = 0; i < numScales; ++i) {
            mergeSort.runningTime(numArraysToSort, arraySize);
            arraySize *= 2;
        }

        // Repeat for shell shellSort algorithm, resetting array size back to
        // starting value.
        arraySize = 50000;
        System.out.println("-- Shell Sort Stats -- ");
        for(int i = 0; i < numScales; ++i) {
            shellSort.runningTime(numArraysToSort, arraySize);
            arraySize *= 2;
        }
    }
}