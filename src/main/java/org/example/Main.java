/****************************************************************
 * Author: Abi Kunkle
 * Date: 4 Oct 2022
 * Description: Program to sort a given array A[n] by mergesort and quicksort. Output sorted array and total number of element comparisons taken for the sorting methods to text files.
 * Build and IDE: Java 17, Maven build, IntelliJ Idea 2022
 * ********************************
 */

package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        RunSortingAlgos runner = new RunSortingAlgos();
        runner.runner();
    }
}

