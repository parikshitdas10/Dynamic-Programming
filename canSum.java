import java.util.*;

// find out if you can make a specific sum using an array of numbers
// you may use numbers any number of times.
public class canSum {
    static void getArr(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    }

    static HashMap<Integer, Boolean> dp = new HashMap<>();

    static boolean sack(int S, int[] arr, int n) {
        if (dp.containsKey(S))
            return dp.get(S);
        if (S == 0)
            return true;
        if (S < 0) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            int rem = S - arr[i];
            if (sack(rem, arr, n) == true) {
                return true;
            } else {
                dp.put(rem, false);
            }
        }
        return false;
    }

    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println("enter size of arr");
        int n = sc.nextInt();
        int[] arr = new int[n];
        getArr(arr, n);
        System.out.println("Enter sum: ");
        int S = sc.nextInt();
        boolean ans = sack(S, arr, n);
        System.out.println(ans);
    }
}
