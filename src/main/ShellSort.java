package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Austin on 3/4/17.
 */
public class ShellSort extends SortAlgorithm {

    public void sort(int[] array) throws Exception{
        try{
            shellSort(array);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void shellSort(int [] array){

        int inner = 0;
        int outer = 0;
        int temp = 0;
        int h = 1;

        /*
        Knuth's increment sequence (3h+1), aka interval
         */
        if(array != null){
            while (h <= array.length/3){
                h = (3 * h) + 1;
            }
            while (h > 0){
                for (outer = h; outer < array.length; outer++){
                    temp = array[outer];
                    inner = outer;

                    while (inner > h - 1 && array[inner - h] >= temp) {
                        array[inner] = array[inner - h];
                        inner -= h;
                    }
                    array[inner] = temp;
                }
                // Calculate new inteval
                h = (h - 1) / 3;
            }
        }
    }

    public void runningTime(int numArrays, int arraySize){

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

        // Iterate through list, usiing system time to determine how long shellSort algorithm takes.
        for(int i = 0; i < list.size(); ++i) {
            long startTime = System.nanoTime();
            try{
                sort(list.get(i));

            }catch(Exception e){
                e.printStackTrace();
            }
            long endTime = System.nanoTime();
            long duration = ((endTime - startTime)/1000000);  //divide by 1000000 to get milliseconds
            durationArray[i] = duration;
            totalDuration += duration;
        }
        // Display duration stats.
        avgDuration = totalDuration/list.size();
        System.out.print("Array Size: " + arraySize + ", ");
        //System.out.println("Sort Times: " + Arrays.toString(durationArray));
        System.out.println("Average shellSort time: " + avgDuration + " milliseconds.");
    }

    public static void main(String[] args){

        int numArraysToSort = 10;
        int arraySize = 1000;
        SortAlgorithm obj = new ShellSort();

        System.out.println("-- Shell Sort Stats -- ");
        for(int i = 0; i < 5; ++i) {
            obj.runningTime(numArraysToSort, arraySize);
            arraySize *= 10;
        }
    }
}
