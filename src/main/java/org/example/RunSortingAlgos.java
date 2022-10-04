package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RunSortingAlgos {

    /**
     * Main entry point of class
     * @throws IOException
     */
    public void runner() throws IOException {
        Double[] merge_inputArray = readInputIntoArray();
        Double[] quick_inputArray = new Double[merge_inputArray.length];

        // Copy the array into quick_inputArray before performing mergesort and quicksort
        System.arraycopy(merge_inputArray, 0, quick_inputArray, 0, merge_inputArray.length);

        createMergeSortedFile(merge_inputArray);
        createQuickSortedFile(quick_inputArray);

    }
    /**
     *
     * @param inputArray
     * @throws FileNotFoundException
     */
    public void createQuickSortedFile(Double[] inputArray) throws FileNotFoundException {
        PrintWriter write = new PrintWriter(new File("aik0002_quick.txt"));
        int length = inputArray.length;
        QuickSort quickSort = new QuickSort();

        int counter =  quickSort.quickSort(inputArray, 0, length-1);
        write.println("Number of comparisons made: " + counter);
        for(int i = 0; i < inputArray.length; i++) {
            write.println( inputArray[i]);
        }
        write.close();
    }


    /**
     *
     * @param inputArray
     * @throws FileNotFoundException
     */
    public void createMergeSortedFile(Double[] inputArray) throws FileNotFoundException {
        PrintWriter write = new PrintWriter(new File("aik0002_merge.txt"));
        MergeSortBasic mergeSort = new MergeSortBasic();
        int length = inputArray.length;
        int counter = mergeSort.mergeSort(inputArray, length);
        write.println("Number of comparisons made: " + counter);
        for(int i = 0; i < inputArray.length; i++) {
            write.println( inputArray[i]);
        }
        write.close();
    }

    /**
     * Gets input from file into array of doubles (inputList).
     * @throws IOException
     */
    public Double[] readInputIntoArray() throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

        List<Double> inputList = new ArrayList<>();

        String line =reader.readLine();

        // checking for end of file
        while (line != null) {
            inputList.add(Double.valueOf(line));
            line = reader.readLine();
        }
        reader.close();

        Double[] inputArray = new Double[inputList.size()];
        inputArray = inputList.toArray(inputArray);

        return inputArray;
    }


}
