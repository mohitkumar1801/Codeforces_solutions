import java.util.*;

public class CherryBomb {

    static int cherry(int n, int k, int[] a, int[] b) {
        int minusOne = 0;
        for (int val : b) {
            if (val == -1) minusOne++;
        }

        if (minusOne < n) {
            int expectedSum = -1;

            for (int i = 0; i < n; i++) {
                if (b[i] != -1) {
                    expectedSum = a[i] + b[i];
                    break;
                }
            }

            for (int i = 0; i < n; i++) {
                if (b[i] != -1 && a[i] + b[i] != expectedSum) {
                    return 0;
                }
            }

            for (int i = 0; i < n; i++) {
                if (b[i] == -1) {
                    int candidate = expectedSum - a[i];
                    if (candidate < 0 || candidate > k) {
                        return 0;
                    }
                }
            }
            return 1;
        }
        int maxA = a[0], minAplusK = a[0] + k;
        for (int i = 1; i < n; i++) {
            if (a[i] > maxA) maxA = a[i];
            if (a[i] + k < minAplusK) minAplusK = a[i] + k;
        }

        int ways = minAplusK - maxA + 1;
        return Math.max(0, ways);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int t = 0; t < test; t++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < n; i++) b[i] = sc.nextInt();

            int result = cherry(n, k, a, b);
            System.out.println(result);
        }
        sc.close();
    }
}
