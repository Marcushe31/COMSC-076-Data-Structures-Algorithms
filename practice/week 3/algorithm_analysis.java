public class algorithm_analysis {
    public static long sumOfN(int n) {
        long theSum = 0;
        for (int i = 1; i <= n; i++ ) {
            theSum += i;
        }
        return theSum;
    }

    public static void main(String[] args) {
        System.out.println(sumOfN(10));
    }
}
