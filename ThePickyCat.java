import java.lang.Math;
import java.rmi.dgc.VMID;
import java.util.*;
public class ThePickyCat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_cases = sc.nextInt();
        for (int test = 0;test<test_cases;test++){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            if(n==1) {
                System.out.println("YES");
                continue;
            }
            int medium  = Math.abs(arr[0]);
            int medium_index = (n-1)/2;
            for(int i = 0;i<n;i++){
                arr[i] = Math.abs(arr[i]);
            }
            Arrays.sort(arr);
            int index = 0;
            for(int i = 0;i<n;i++){
                if(arr[i]==medium){
                    index = i;
                    break;
                }
            }
            if(n-index>=index){
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
