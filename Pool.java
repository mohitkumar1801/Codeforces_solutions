import java.util.*;
public class Pool {
    static void movement(int[][] arr,int n){
        for(int i = 0;i<n;i++){
            if(arr[i][2] != -1 && arr[i][3] != -1) {
                arr[i][2] = arr[i][2] + arr[i][0] / 2;
                arr[i][3] = arr[i][3] + arr[i][1] / 2;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_cases = sc.nextInt();
        for(int test = 0;test<test_cases;test++){
            int n = sc.nextInt();
            int s = sc.nextInt();
            int[][] arr = new int[n][4];
            for(int i = 0;i<n;i++){
                for(int j = 0;j<4;j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            int potted = 0;
            for(int i = 0;i<n;i++){
                int dx = arr[i][0];
                int dy = arr[i][1];
                int x = arr[i][2];
                int y = arr[i][3];
                if((dx==dy && x == y) || (x+y==s && dx==-dy)){
                    potted++;
                }
            }
            System.out.println(potted);
        }
    }
}
