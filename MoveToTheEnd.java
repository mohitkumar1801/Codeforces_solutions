import java.util.*;

public class MoveToTheEnd {
    static boolean isAllSame(int[] arr) {
        int value = arr[0];
        for (int num : arr) {
            if (num != value) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            if (n == 1) {
                System.out.println(arr[0]);
                continue;
            }

            if (isAllSame(arr)) {
                long sum = 0;
                for (int num : arr) {
                    sum += num;
                    System.out.print(sum + " ");
                }
                System.out.println();
                continue;
            }

            // prefix sum
            long[] prefix = new long[n + 1];
            for (int i = 0; i < n; i++) prefix[i + 1] = prefix[i] + arr[i];

            // max index up to each position
            int[] maxIdx = new int[n];
            maxIdx[0] = 0;
            for (int i = 1; i < n; i++) {
                if (arr[i] > arr[maxIdx[i - 1]]) {
                    maxIdx[i] = i;
                } else {
                    maxIdx[i] = maxIdx[i - 1];
                }
            }

            // answer each k
            for (int k = 1; k <= n; k++) {
                int idx = maxIdx[n - k];
                long sum = (prefix[n] - prefix[n - (k - 1)]) + arr[idx];
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}
