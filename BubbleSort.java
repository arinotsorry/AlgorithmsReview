package Sorting;

import java.util.Arrays;

/**
 * Author: Ari Wisenburn
 * Description: A simple comparison-based sorting algorithm that repeatedly steps through the list, compares adjacent
 * elements, and swaps them if they're in the wrong order
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 */
public class BubbleSort {
    public static void main(String[] args){
        int[] array = {3, 5, 7 ,3 ,6 ,8 , 9, 1, 4, 5, 1, 2, 8, 3, 6, 4, 8, 7, 9, 5};
        boolean printIntermediateSteps = false;

        // print unsorted array
        printArray(array, "Unsorted array:");

        // sort array in ascending order and print
        bubbleSortAscending(array, printIntermediateSteps);
        printArray(array, "Array sorted in ascending order:");

        // sort array in descending order and print
        bubbleSortDescending(array, printIntermediateSteps);
        printArray(array, "Array sorted in descending order:");
    }

    /**
     * Parses through the array, comparing pairs of numbers, making sure the larger one is on the right.
     * Ends up grabbing the largest number and moving it to the end
     *
     * @param array the array to be sorted
     * @param printIntermediateSteps boolean whether to print intermediate steps
     */
    public static void bubbleSortAscending(int[] array, boolean printIntermediateSteps){
        for(int iterations = 0; iterations < array.length; iterations++){
            for(int iterator = 0; iterator < array.length - 1; iterator++){
                // compare and swap
                if( array[iterator] > array[iterator + 1] ){
                    int temp = array[iterator + 1];
                    array[iterator + 1] = array[iterator];
                    array[iterator] = temp;
                }
            }
            if(printIntermediateSteps)
                printIteration(array, iterations);
        }
    }

    /**
     * Parses through the array, comparing pairs of numbers, making sure the smaller one is on the right.
     * Ends up grabbing the smallest number and moving it to the end
     *
     * @param array the array to be sorted
     * @param printIntermediateSteps boolean whether to print intermediate steps
     */
    public static void bubbleSortDescending(int[] array, boolean printIntermediateSteps){
        for(int iterations = 0; iterations < array.length; iterations++){
            for(int iterator = 0; iterator < array.length - 1; iterator++){
                // compare and swap
                if( array[iterator] < array[iterator + 1] ){
                    int temp = array[iterator + 1];
                    array[iterator + 1] = array[iterator];
                    array[iterator] = temp;
                }
            }
            if(printIntermediateSteps)
                printIteration(array, iterations);
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
