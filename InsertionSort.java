package Sorting;

import java.util.Arrays;

public class InsertionSort {
    /**
     * Author: Ari Wisenburn
     * Description: Builds the final sorted array one item at a time, placing each element in its correct position
     * relative to the already sorted elements
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] array = {3, 5, 7, 3, 6, 8, 9, 1, 4, 5, 1, 2, 8, 3, 6, 4, 8, 7, 9, 5};

        // print unsorted array
        printArray(array, "Unsorted array:");

        // sort array in ascending order and print
        insertionSortAscending(array);
        printArray(array, "Array sorted in ascending order:");

        // sort array in descending order and print
        insertionSortDescending(array);
        printArray(array, "Array sorted in descending order:");
    }

    /**
     * Finds where to insert the next number in the previously sorted portion
     *
     * @param array the array to be sorted
     */
    public static void insertionSortAscending(int[] array) {
        for (int first_index_not_checked = 1; first_index_not_checked < array.length; first_index_not_checked++) {
            // right now, we're looking at the first number that hasn't been categorized yet
            // we have to start another counter to look for where to insert the number
            int insertion_index = 0;
            while (insertion_index <= first_index_not_checked) {
                if (array[first_index_not_checked] < array[insertion_index])
                    break;
                insertion_index++;
            }

            // save the value to be moved
            int wandering_value = array[first_index_not_checked];

            // shift the rest of the array over, beginning with the wandering value
            for (int shift = insertion_index; shift <= first_index_not_checked; shift++) {
                int temp = array[shift];
                array[shift] = wandering_value;
                wandering_value = temp;
            }
        }
    }

    /**
     * Finds where to insert the next number in the previously sorted portion
     *
     * @param array the array to be sorted
     */
    public static void insertionSortDescending(int[] array) {
        for (int first_index_not_checked = 1; first_index_not_checked < array.length; first_index_not_checked++) {
            // right now, we're looking at the first number that hasn't been categorized yet
            // we have to start another counter to look for where to insert the number
            int insertion_index = 0;
            while (insertion_index <= first_index_not_checked) {
                if (array[first_index_not_checked] > array[insertion_index]) // only change between asc and desc
                    break;
                insertion_index++;
            }

            // save the value to be moved
            int wandering_value = array[first_index_not_checked];

            // shift the rest of the array over, beginning with the wandering value
            for (int shift = insertion_index; shift <= first_index_not_checked; shift++) {
                int temp = array[shift];
                array[shift] = wandering_value;
                wandering_value = temp;
            }
        }
    }

    /**
     * prints intermediate transitional info as array is being sorted
     *
     * @param array array being sorted
     * @param iter  iteration number
     */
    public static void printIteration(int[] array, int iter) {
        System.out.println("After iteration " + iter + ":");
        System.out.println(Arrays.toString(array));
    }

    /**
     * print the entire array nicely
     *
     * @param array   array that was sorted
     * @param message label for array
     */
    public static void printArray(int[] array, String message) {
        System.out.println(message);
        System.out.println(Arrays.toString(array));
        System.out.println();
    }
}
