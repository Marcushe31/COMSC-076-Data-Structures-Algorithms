import java.util.ArrayList;
import java.util.Random;

/**
 * COMSC-076: Algorithm Analysis
 * The purpose of this assignment is to show how ArrayList's IndexOf() method's
 * time complexity is O(n)
 * 
 * @author Marcus Hernandez
 */

public class AlgorithmAnalysis {
    /**
     * Fill the given arraylist with sequential integers from 0 to size -1
     * @param list the arraylist to fill
     * @param size the number of items to add
     */
    public static void addSize(ArrayList<Integer> list, int size) {
        for (int i = 0; i < size; i += 1) {
            list.add(i);
        }
    }

    /**
     * Measures the average time that it takes to run callsPerTrial() calls, 
     * with each serching for a random target.
     * runs 25 timing trials, and the first 20 are discarded for better data.
     *  The result is the average of the last 5 trials. 
     * @param list the ArrayList to search
     * @param size the number of items in the list
     * @return the average time in seconds of the last FIVE trials
     */
    public static double measure(ArrayList<Integer> list, int size) {
        Random rng = new Random();
        int trials = 25;
        int warmup = 20;
        int callsPerTrial = 20000;

        double totalSeconds = 0;
        int counted = 0;

        for (int trial = 0; trial < trials; trial += 1) {
            System.gc();

            long start = System.nanoTime();
            for (int i = 0; i < callsPerTrial; i += 1) {
                int target = rng.nextInt(size);
                list.indexOf(target);
            }

            long time = System.nanoTime() - start;

            double seconds = time / 1_000_000_000.0;

            // only keeps trials AFTER the warmup
            if (trial >= warmup) {
                totalSeconds += seconds;
                counted++;
            }
        }

        return totalSeconds / counted;

    }

    /**
     * Builds 5 ArrayLists of different sizes, times indexOf() on each using measure(), 
     * and then will print the results as size, time(seconds)
     */
    public static void main(String args[]) {
        // 10,000 size test
        ArrayList<Integer> l1 = new ArrayList<>();

        // 100,000 size test
        ArrayList<Integer> l2 = new ArrayList<>();

        // 250,000 size test
        ArrayList<Integer> l3 = new ArrayList<>();

        // 750,000 size test
        ArrayList<Integer> l4 = new ArrayList<>();

        // 1 Million size test
        ArrayList<Integer> l5 = new ArrayList<>();

        // adding size to ArrayLists
        addSize(l1, 10000);
        addSize(l2, 100000);
        addSize(l3, 250000);
        addSize(l4, 750000);
        addSize(l5, 1000000);

        System.out.println("-------------------------");

        System.out.println("Size, Time(second)");
        System.out.println("10000, " + measure(l1, 10000));
        System.out.println("100000, " + measure(l2, 100000));
        System.out.println("250000, " + measure(l3, 250000));
        System.out.println("750000, " + measure(l4, 750000));
        System.out.println("1000000, " + measure(l5, 1000000));

        System.out.println("-------------------------");
    }
}
