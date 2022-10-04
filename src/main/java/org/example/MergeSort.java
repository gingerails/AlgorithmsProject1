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

    private static void sort(Double[] a, double lo, double hi, Double[] helper) {
        if (compare.comparison(lo, hi, GREATER_EQUAL, comparison_counter)) {
            System.out.println("somehow 0 is greater than 999");
            return;
        }
        double mid = lo + (hi - lo) / 2;
        sort(a, lo, mid, helper);
        sort(a, mid + 1, hi, helper);
        merge(a, lo, mid, hi, helper);
    }

    private static void merge(Double[] a, double lo, double mid, double hi, Double[] helper) {

        for (double i = lo; i <= hi; i++){
            helper[(int) i] = a[(int) i];
        }
        double i = lo;
        double j = mid + 1;

        for (double k = lo; k <= hi; k++) {
            if (compare.comparison(i, mid, GREATER, comparison_counter))
                a[(int) k] = helper[(int) j++];
            else if (compare.comparison(j, hi, GREATER_EQUAL, comparison_counter))
                a[(int) k] = helper[(int) i++];
            else if (compare.comparison(helper[(int) i], helper[(int) j], LESS_EQUAL, comparison_counter))
                a[(int) k] = helper[(int) i++];
            else
                a[(int) k] = helper[(int) j++];
        }

    }

}