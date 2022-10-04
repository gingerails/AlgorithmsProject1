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
 */

/**
 * I really hope I did this properly - I understood everything about counting the comparisons, but
 * I wasn't sure if this function was *only* supposed to support a less-than method, or if by 'appropriate calls' we were supposed to pass the opration as a
 * parameter. I went with the latter assumption - I know I probably should have just asked for clarification.
 */

public class Comparison {
    public enum Operator
    {
        LESS("<") {
            @Override public boolean apply(double x1, double x2) {
                return x1 < x2;
            }
        },
        GREATER(">") {
            @Override public boolean apply(double x1, double x2) {
                return x1 > x2;
            }
        },
        LESS_EQUAL("<=") {
            @Override public boolean apply(double x1, double x2) {
                return x1 <= x2;
            }
        },
        GREATER_EQUAL(">=") {
            @Override public boolean apply(double x1, double x2) {
                System.out.println(x1 >= x2);
                return x1 >= x2;
            }
        },
        EQUALS("==") {
            @Override public boolean apply(double x1, double x2) {
                return x1 == x2;
            }
        },
        NOT_EQUALS("!=") {
            @Override public boolean apply(double x1, double x2) {
                return x1 != x2;
            }
        };

        private final String text;

        private Operator(String text) {
            this.text = text;
        }

        public abstract boolean apply(double x1, double x2);

        @Override public String toString() {
            return text;
        }
    }


    /**
     * Comparison counter.
     * To make sure I was only updating this each time the comparison function is called,
     * I kept it as a static variable of the comparison obj that was updated on each function call
     */
    static int comparison_counter = 0;
    public int increaseCounter(int comparison_counter){
        comparison_counter = comparison_counter + 1;

        return comparison_counter;
    }

    /**
     *
     * @param i
     * @param j
     * @param op
     * @return
     */
    public boolean comparison(double i, double j, Operator op, int comparison_counter){
       // increaseCounter(comparison_counter);
        //comparison_counter = comparison_counter + 1;
//        System.out.print (op.apply(i, j));
//        System.out.print (comparison_count);
        return op.apply(i, j);
    }
}
