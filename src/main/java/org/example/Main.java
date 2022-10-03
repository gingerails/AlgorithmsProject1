/****************************************************************
 * Author: Abi Kunkle
 * Date: 4 Oct 2022
 * Description:
 * Build and IDE: Java 17, Maven build, IntelliJ Idea 2022
 * ********************************
 */

package org.example;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        //    For generating my own test input files:
//        GenerateFile generateFile = new GenerateFile();
//        generateFile.generateFile();
        // Runner creates mergesort and quicksort output files
        RunSortingAlgos runner = new RunSortingAlgos();
        runner.runner();
    }
}
