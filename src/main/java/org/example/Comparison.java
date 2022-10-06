package org.example;

/**
 * Your program must have the following function clearly identified and implemented:
 *
 * Comparison function - to compare an array element to another array element:
 * - LESS(a, b) : if (a < b) return true, else return false.
 * Note that all other operators (>, >=, <=, ==, !=) can be computed by making appropriate calls to the above function.
 * The above function must increment a counter 'comparison_count' (this will be needed for output).
 * Obviously, one of your goals is to minimize the total number of array element comparisons.
 * ABSOLUTELY NO "array element" comparisons outside of this function.
 *
 */

public class Comparison {
    public int comparison_counter = 0;

    public boolean less(double x1, double x2) {
        comparison_counter = comparison_counter + 1;
        return x1 < x2;
    }
}
