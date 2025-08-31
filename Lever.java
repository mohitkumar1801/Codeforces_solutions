import java.util.*;
public class Lever {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_cases = sc.nextInt();
        for(int i = 0 ; i<test_cases;i++){
            int len = sc.nextInt();
            int[] a = new int[len];
            int[] b = new int[len];
            for(int j = 0;j<len;j++){
                a[j] = sc.nextInt();
            }
            for(int j = 0;j<len;j++){
                b[j] = sc.nextInt();
            }
            int iteration = 0;
            boolean changed = true;
            while(changed) {
                changed = false;
                int count_1 = 0;
                int count_2 = 0;
                for(int j = 0;j<len;j++){
                    if(a[j]>b[j] && count_1==0){
                        changed = true;
                        a[j] = a[j]-1;
                        count_1++;
                    }
                    if(a[j]<b[j] && count_2==0){
                        a[j] = a[j]+1;
                        count_2++;
                    }
                }
                iteration++;
                if(!changed){
                    break;
                }
            }
            System.out.println(iteration);
        }
    }
}
