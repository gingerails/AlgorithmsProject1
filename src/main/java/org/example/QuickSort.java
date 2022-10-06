package org.example;

/**
 * LESS than comparison method used via compare.less(x1,x2)
 */
public class QuickSort {

    static Comparison compare = new Comparison();

    /**
     *
     * @param arr
     * @param begin
     * @param end
     * @return
     */
    public int quickSort(Double arr[], double begin, double end) {
        if (compare.less(begin, end)){
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
        return compare.comparison_counter;      // return number of comparisons made
    }

    /**
     *
     * @param arr
     * @param begin
     * @param end
     * @return partition index
     */
    private int partition(Double arr[], double begin, double end) {
        double pivot = arr[(int) end];
        double i = (begin-1);

        for (double j = begin; j < end; j++) {
            if (!compare.less(pivot, arr[(int) j])){  // originally arr[(int) j] <= pivot.
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
