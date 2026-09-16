import java.util.Scanner;
import java.util.ArrayList;

public class RemoveItem {
    public static double timeRemove (int len, boolean removeFirst) {
        final int N_Trials = 25;
        final int N_ignore = 20;
        long totalTime = 0;

        ArrayList<Integer> list = new ArrayList<>(len);

        for (int trial = 0; trial < N_Trials; trial += 1) {
            int start = list.size();

            for (int i = start; i < len; i++) {
                list.add(i);
            }
            System.gc();

            long startTime = system.nanoTime();
            for (int count = 0; count < 1000; count += 1) {
                if (removeFirst) {
                    list.remove(0);
                } else {
                    list.remove(list.size() - 1);
                }
            }

            if (trial >= N_ignore) {
                totalTime += System.nanoTime() - startTime;
            }
        }
        return (totalTime / (N_Trials - N_ignore)) / 1.0E9;
    }

    public static void main(String[] args) {
        
    }
}
