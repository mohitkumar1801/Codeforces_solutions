import java.lang.Math;
import java.util.*;
class Recycle{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_cases = sc.nextInt();
        for(int i = 0;i<test_cases;i++){
            int n = sc.nextInt();
            int c = sc.nextInt();
            int[] arr = new int[n];
            for(int j = 0;j<n;j++) {
                arr[j] = sc.nextInt();
            }
            int closest = 0;
            for(int k = 0;k<n;k++){
                if(arr[k]<=c && arr[k]!=-1){
                    closest = arr[k];
                    break;
                }
            }
            if(closest==0){
                System.out.println(n);
                continue;
            }
            for(int o = 0;o<n;o++) {
                closest = 0;
                for(int k = 0;k<n;k++){
                    if(arr[k]<=c && arr[k]!=-1){
                        closest = arr[k];
                        break;
                    }
                }
                for (int l = 0; l < n; l++) {
                    if (arr[l] <= c && arr[l]!=-1 && (c - arr[l]) <= (c - closest)) {
                        closest = arr[l];
                    }
                }
                for (int m = 0; m < n; m++) {
                    if (arr[m] == closest) {
                        arr[m] = -1;
                        break;
                    }
                }
                for(int q = 0;q<n;q++){
                    if(arr[q]!=-1 && arr[q]<=c){
                        arr[q] = arr[q]*2;
                    }
                }
            }
            int coin = 0;
            for(int p = 0;p<n;p++){
                if(arr[p]!=-1){
                    coin++;
                }
            }
            System.out.println(coin);
        }
    }
}