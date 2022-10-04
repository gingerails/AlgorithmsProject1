package org.example;

import static org.example.Comparison.Operator.*;

public class MergeSortBasic {
    static Comparison compare = new Comparison();
    static int comparison_counter = 0;

    public static int mergeSort(Double[] a, int n) {
        if (n < 2) {
            return n;
        }
        int mid = n / 2;
        Double[] l = new Double[mid];
        Double[] r = new Double[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
        return n;
    }

    /***
     * The way I am counting comparisons is calling a function which increases the number of comparisons by one.
     * @param a
     * @param l
     * @param r
     * @param left
     * @param right
     * @return
     */
    public static int merge( Double[] a, Double[] l, Double[] r, double left, double right) {

        int i = 0, j = 0, k = 0;
        while ((compare.comparison(i, left, LESS, comparison_counter)) && (compare.comparison(j, right, LESS, comparison_counter))) {
                comparison_counter = compare.increaseCounter(comparison_counter);
                comparison_counter = compare.increaseCounter(comparison_counter);
            if (compare.comparison(l[i], r[j], LESS_EQUAL, comparison_counter)){
                comparison_counter = compare.increaseCounter(comparison_counter);
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (compare.comparison(i, left, LESS, comparison_counter)){
            comparison_counter = compare.increaseCounter(comparison_counter);
            a[k++] = l[i++];
        }
        while (compare.comparison(j, right, LESS, comparison_counter)){
            comparison_counter = compare.increaseCounter(comparison_counter);
            a[k++] = r[j++];
        }
        return comparison_counter;
    }


}