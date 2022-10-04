package org.example;

import static org.example.Comparison.Operator.*;

public class QuickSortV1 {
    static Comparison compare = new Comparison();
    static int comparison_counter = 0;

    // Swap array elements
    static void swap(Double[] arr, double i, double j)
    {
        double temp = arr[(int) i];
        arr[(int) i] = arr[(int) j];
        arr[(int) j] = temp;
    }


    static double partition(Double[] arr, double low, double high)
    {

        // pivot
        double pivot = arr[(int) high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        double i = (low - 1);

        for (double j = low; j <= high - 1; j++) {

            // If current element is smaller
            // than the pivot
            if (compare.comparison(arr[(int) j], pivot, LESS, comparison_counter)){
                comparison_counter = compare.increaseCounter(comparison_counter);

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

/*
(compare.comparison(i, left, LESS, comparison_counter)){
            comparison_counter = compare.increaseCounter(comparison_counter);
 */
    public static int quickSort(Double[] arr, int low, int high)
    {
        if(compare.comparison(low, high, LESS, comparison_counter)){
            comparison_counter = compare.increaseCounter(comparison_counter);

            // pi is partitioning index, arr[p]
            // is now at right place
            double pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, (int) (pi - 1));
            quickSort(arr, (int) (pi + 1), high);
        }
        return comparison_counter;
    }
}
