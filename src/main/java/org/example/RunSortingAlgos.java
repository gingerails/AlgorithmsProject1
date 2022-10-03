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
        Double[] inputArray = readInputIntoArray();
        createMergeSortedFile(inputArray);

    }

    /**
     *
     * @param inputArray
     * @throws FileNotFoundException
     */
    public void createMergeSortedFile(Double[] inputArray) throws FileNotFoundException {
        PrintWriter write = new PrintWriter(new File("aik0002_merge.txt"));
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(inputArray);
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
