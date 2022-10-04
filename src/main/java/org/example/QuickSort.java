package org.example;

import static org.example.Comparison.Operator.*;
import static org.example.Comparison.Operator.LESS_EQUAL;

public class QuickSort {

    static Comparison compare = new Comparison();
    static int comparison_counter = 0;

    public int quickSort(Double arr[], double begin, double end) {
        if(compare.comparison(begin, end, LESS, comparison_counter)){
            comparison_counter = compare.increaseCounter(comparison_counter);

            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
        return comparison_counter;
    }

    private int partition(Double arr[], double begin, double end) {
        double pivot = arr[(int) end];
        double i = (begin-1);

        for (double j = begin; j < end; j++) {
            if (compare.comparison(arr[(int) j],pivot, LESS_EQUAL, comparison_counter)){
                comparison_counter = compare.increaseCounter(comparison_counter);
                i++;

                double swapTemp = arr[(int) i];
                arr[(int) i] = arr[(int) j];
                arr[(int) j] = swapTemp;
            }
        }

        double swapTemp = arr[(int) (i+1)];
        arr[(int) (i+1)] = arr[(int) end];
        arr[(int) end] = swapTemp;

        return (int) (i+1);
    }
}
