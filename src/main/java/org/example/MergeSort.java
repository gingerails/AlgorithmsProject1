package org.example;

import static org.example.Comparison.Operator.*;

public class MergeSort {
    static Comparison compare = new Comparison();
    static int comparison_counter;

    public static void sort(Double[] a) {
        Double[] helper = new Double[a.length];
        sort(a, 0, a.length - 1, helper);
     //   Map map = new HashMap<>();
    }

    private static void sort(Double[] a, int lo, int hi, Double[] helper) {
        if (compare.comparison(a, lo, hi, GREATER_EQUAL, comparison_counter)) {
            System.out.println("somehow 0 is greater than 999");
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid, helper);
        sort(a, mid + 1, hi, helper);
        merge(a, lo, mid, hi, helper);
    }

    private static void merge(Double[] a, int lo, int mid, int hi, Double[] helper) {

        for (int i = lo; i <= hi; i++){
            helper[i] = a[i];
        }
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (compare.comparison(a, i, mid, GREATER, comparison_counter))
                a[k] = helper[j++];
            else if (compare.comparison(a, j, hi, GREATER_EQUAL, comparison_counter))
                a[k] = helper[i++];
            else if (compare.comparison(helper, i, j, LESS_EQUAL, comparison_counter))
                a[k] = helper[i++];
            else
                a[k] = helper[j++];
        }

    }

}