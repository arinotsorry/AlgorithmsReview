package Sorting;

import java.util.Arrays;

public class SelectionSort {
    /**
     * Author: Ari Wisenburn
     * Description: A simple comparison-based sorting algorithm that finds the smallest/largest element from the
     * unsorted portion and moves it to the beginning/end
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     */
    public static void main(String[] args){
        int[] array = {3, 5, 7 ,3 ,6 ,8 , 9, 1, 4, 5, 1, 2, 8, 3, 6, 4, 8, 7, 9, 5};
        boolean printIntermediateSteps = false;

        // print unsorted array
        printArray(array, "Unsorted array:");

        // sort array in ascending order and print
        selectionSortAscending(array, printIntermediateSteps);
        printArray(array, "Array sorted in ascending order:");

        // sort array in descending order and print
        selectionSortDescending(array, printIntermediateSteps);
        printArray(array, "Array sorted in descending order:");
    }

    /**
     * Goes through each index and swaps it with the smallest number not sorted yet
     *
     * @param array the array to be sorted
     * @param printIntermediateSteps boolean whether to print intermediate steps
     */
    public static void selectionSortAscending(int[] array, boolean printIntermediateSteps){
        // static index refers to the index that is being replaced by the next smallest number
        for(int staticIndex = 0; staticIndex < array.length - 1; staticIndex++){
            // establish a minimum that we're trying to beat
            int minimum = array[staticIndex];
            int minIndex = staticIndex;

            // find the next smallest number left in the array (including the # we're looking at)
            for(int searching = staticIndex + 1; searching < array.length; searching++){
                if(array[searching] < minimum){
                    minimum = array[searching];
                    minIndex = searching;
                }
            }

            // replace the current index with the smallest number
            int temp = array[staticIndex];
            array[staticIndex] = array[minIndex];
            array[minIndex] = temp;

            // optional - print the state of the array
            if( printIntermediateSteps )
                printIteration(array, staticIndex);
        }
    }

    /**
     * Goes through each index and swaps it with the largest number not sorted yet
     *
     * @param array the array to be sorted
     * @param printIntermediateSteps boolean whether to print intermediate steps
     */
    public static void selectionSortDescending(int[] array, boolean printIntermediateSteps){
// static index refers to the index that is being replaced by the next smallest number
        for(int staticIndex = 0; staticIndex < array.length - 1; staticIndex++){
            // establish a minimum that we're trying to beat
            int maximum = array[staticIndex];
            int maxIndex = staticIndex;

            // find the next smallest number left in the array (including the # we're looking at)
            for(int searching = staticIndex + 1; searching < array.length; searching++){
                if(array[searching] > maximum){
                    maximum = array[searching];
                    maxIndex = searching;
                }
            }

            // replace the current index with the smallest number
            int temp = array[staticIndex];
            array[staticIndex] = array[maxIndex];
            array[maxIndex] = temp;

            // optional - print the state of the array
            if( printIntermediateSteps )
                printIteration(array, staticIndex);
        }
    }

    /**
     * prints intermediate transitional info as array is being sorted
     * @param array array being sorted
     * @param iter iteration number
     */
    public static void printIteration(int[] array, int iter){
        System.out.println("After iteration " + iter + ":");
        System.out.println(Arrays.toString(array));
    }

    /**
     * print the entire array nicely
     *
     * @param array array that was sorted
     * @param message label for array
     */
    public static void printArray(int[] array, String message){
        System.out.println(message);
        System.out.println(Arrays.toString(array));
        System.out.println();
    }
}
