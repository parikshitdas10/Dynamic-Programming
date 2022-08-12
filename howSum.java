import java.util.*;

public class howSum {
    static Scanner sc;
    static ArrayList<Integer> comb = new ArrayList<>();
    static HashMap<Integer, Boolean> dp = new HashMap<>();

    static boolean getComb(int S, int[] arr, int n) {
        if (dp.containsKey(S))
            return dp.get(S);
        if (S == 0)
            return true;

        if (S < 0)
            return false;
        for (int i = 0; i < n; i++) {
            int rem = S - arr[i];
            if (getComb(rem, arr, n) == true) {
                comb.add(arr[i]);
                dp.put(rem, true);
                return true;
            } else {
                dp.put(rem, false);
            }
        }

        return false;

    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println("Enter sum:");
        int S = sc.nextInt();
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        getComb(S, arr, n);
        System.out.println(comb);
    }
}
