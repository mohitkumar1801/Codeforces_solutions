import java.lang.Math;
import java.util.*;
public class MakeItEqual {
    static boolean found(int max , int[] arr){
        for(int k : arr){
            if(max==k){
                return true;
            }
        }
        return false;
    }
    static int searchS(int max, int[] arr){
        for(int x = 0;x<arr.length;x++){
            if(arr[x]==max){
                return x;
            }
        }
        return -1;
    }
    static int searchT(int max, int[] arr){
        for(int x = 0;x<arr.length;x++){
            if(arr[x]==max){
                return x;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_cases = sc.nextInt();
        for(int i = 0;i<test_cases;i++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] s = new int[n];
            int[] t = new int[n];
            for(int j = 0;j<n;j++){
                s[j] = sc.nextInt();
            }
            for(int j = 0;j<n;j++){
                t[j] = sc.nextInt();
            }
            boolean fromS = false;
            boolean fromT = false;

            int counter = 0;
            for(int z = 0;z<n;z++) {
                int max = s[0];
                for(int j : s){
                    if (j>max){
                        max = j;
                        fromS = true;
                    }
                }
                for(int j : t){
                    if(j>max){
                        max = j;
                        fromT = true;
                        fromS = false;
                    }
                }
                int real_max = max;
                if (fromS) {
                    while (!found(max, t)) {
                        max = Math.abs(max - k);
                        int max2 = Math.abs(Math.abs(max - k) - k);
                        if (max == max2 && !found(max,t) && !found(Math.abs(max-k), t)) {
                            counter = -1;
                            break;
                        }
                    }
                    if(found(real_max,t)){
                        int index = searchT(max,t);
                        if(index>-1){
                            t[index]=-1;
                        }
                        index = searchS(max,s);
                        if(index>-1){
                            s[index]=-1;
                        }
                        counter++;
                    }

                }
                else{
                    while (!found(max, s)) {
                        max = Math.abs(max - k);
                        int max2 = Math.abs(Math.abs(max - k) - k);
                        if (max == max2 && !found(max,s) && !found(Math.abs(max-k), s) ){
                            counter = -1;
                            break;
                        }
                    }
                    if(found(max,s)){
                        int index = searchS(max,s);
                        if(index>-1){
                            s[index]=-1;
                        }
                        index = searchT(real_max,t);
                        if(index>-1){
                            t[index]=-1;
                        }
                        counter++;
                    }

                }
                if(counter == -1){
                    System.out.println("NO");
                    break;
                }
            }
            int done = 0;
            for(int y = 0 ; y<n;y++){
                if (s[y]==-1){
                    done++;
                }
            }
            if(counter==n){
                System.out.println("YES");
            }
            System.out.println(Arrays.toString(s));
            System.out.println(Arrays.toString(t));
        }
    }
}
