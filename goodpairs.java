import java.util.*;
import java.lang.Math;
public class goodpairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_cases = sc.nextInt();
        for(int test = 0; test <test_cases; test++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            String str = sc.next();
            int zero = 0;
            int one = 0;
            for(int i = 0;i<n;i++){
                if(str.charAt(i)=='0'){
                    zero++;
                }
                else {
                    one++;
                }
            }
            int max = zero/2 + one/2;
            int min = Math.abs(zero-one)/2;
            boolean possible = (k>=min && k<=max && (k-min)%2==0);
            if (possible){
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
