package org.example;

/**
 * LESS than comparison method used via compare.less(x1,x2) in the merge function
 */
public class MergeSort {
    static Comparison compare = new Comparison();

    /**
     * @param a
     * @param n
     * @return
     */
    public static int mergeSort(Double[] a, int n) {
        if (n < 2) {
            return n;
        }
        int mid = n / 2;
        Double[] l = new Double[mid];
        Double[] r = new Double[n - mid];

        // Not using the Less function because these are not array index value comparisons.
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
     * Number of comparisons is increased internally each time compare.less() is called. This number will be returned by the
     * merge function.
     * @param a
     * @param l
     * @param r
     * @param left
     * @param right
     * @return comparison_counter
     */
    public static int merge( Double[] a, Double[] l, Double[] r, double left, double right) {

        int i = 0, j = 0, k = 0;
        while ((compare.less(i, left)) && (compare.less(j, right))) {
            if (!compare.less(r[j], l[i])){         // originally l[i] <= r[j]
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (compare.less(i, left)){     // i < left
            a[k++] = l[i++];
        }
        while (compare.less(j, right)){   // j < right
            a[k++] = r[j++];
        }
        return compare.comparison_counter;
    }
}