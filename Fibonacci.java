import java.util.*;

public class Fibonacci {
    static int getFib(int n, HashMap<Integer, Integer> dp) {
        if (n <= 1) {
            return n;
        }
        int last, slast;
        // for last element
        if (dp.containsKey(n - 1)) {
            last = dp.get(n - 1);
        } else {
            dp.put(n - 1, getFib(n - 1, dp));
            last = dp.get(n - 1);
        }
        // for second last
        if (dp.containsKey(n - 2)) {
            slast = dp.get(n - 2);
        } else {
            dp.put(n - 2, getFib(n - 2, dp));
            slast = dp.get(n - 2);
        }
        return last + slast;
    }

    static Scanner sc;

    public static void main(String[] args) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        long start = System.currentTimeMillis();
        System.out.println(getFib(n, dp));
        long end = System.currentTimeMillis();
        System.out.println(end - start + " ms");
    }
}