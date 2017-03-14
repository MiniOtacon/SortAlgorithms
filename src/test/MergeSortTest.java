package test;

import main.MergeSort;
import main.ShellSort;
import main.SortAlgorithm;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Austin on 3/14/17.
 */
public class MergeSortTest {

    @Test // Case where each element in array has same value
    public void sortSameNumbers(){
        //System.out.print("@Test (MergeSort) sortSameNumbers: ");
        int size = 10000;
        int[] myArray = new int[size];
        int[] javaArray = new int[size];

        for (int i = 0; i < myArray.length; ++i) {
            myArray[i] = 42; // set each index element to 42
        }
        System.arraycopy(myArray, 0, javaArray, 0, myArray.length);
        SortAlgorithm mergeSort = new MergeSort();
        try{
            mergeSort.sort(myArray);
        }catch(Exception e){
            e.printStackTrace();
        }
        Arrays.sort(javaArray);
        assertArrayEquals(myArray, javaArray);
        //System.out.println("Passed.");
    }

    @Test // Case where each element in array is increasing by 1
    public void sortSequentialNumbers(){
        //System.out.print("@Test (MergeSort) sortSequentialNumbers: ");
        int size = 10000;
        int[] myArray = new int[size];
        int[] javaArray = new int[size];

        for (int i = 0; i < myArray.length; ++i) {
            myArray[i] = i;
        }
        System.arraycopy(myArray, 0, javaArray, 0, myArray.length);
        SortAlgorithm mergeSort = new MergeSort();
        try{
            mergeSort.sort(myArray);
        }catch(Exception e){
            e.printStackTrace();
        }
        Arrays.sort(javaArray);
        assertArrayEquals(myArray, javaArray);
        //System.out.println("Passed.");
    }

    @Test // Case where array is empty
    public void sortEmpty(){
        //System.out.print("@Test (MergeSort) sortEmpty: ");
        int size = 0;
        int[] myArray = new int[size];
        int[] javaArray = new int[size];
        System.arraycopy(myArray, 0, javaArray, 0, myArray.length);
        SortAlgorithm mergeSort = new MergeSort();
        try{
            mergeSort.sort(myArray);
        }catch(Exception e){
            e.printStackTrace();
        }
        Arrays.sort(javaArray);
        assertArrayEquals(myArray, javaArray);
        //System.out.println("Passed.");
    }

    @Test // Case where array has one element
    public void sortOne(){
        //System.out.print("@Test (ShellSort) sortOne: ");
        int size = 1;
        int[] myArray = new int[size];
        int[] javaArray = new int[size];
        System.arraycopy(myArray, 0, javaArray, 0, myArray.length);
        SortAlgorithm mergeSort = new ShellSort();
        try{
            mergeSort.sort(myArray);
        }catch(Exception e){
            e.printStackTrace();
        }        Arrays.sort(javaArray);
        assertArrayEquals(myArray, javaArray);
        //System.out.println("Passed.");
    }


    @Test // Case where array is null
    public void sortNull(){
        //System.out.print("@Test (MergeSort) sortOne: ");
        int[] myArray = null;
        try{
            SortAlgorithm mergeSOrt = new ShellSort();
            mergeSOrt.sort(myArray);
        }catch(Exception e){
            e.printStackTrace();
        }
        //System.out.println("Passed.");
    }
}