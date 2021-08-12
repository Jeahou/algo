package beakjoon;

import java.sql.PreparedStatement;
import java.util.Scanner;

public class B21760 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T =sc.nextInt();
        for(int i=0; i<T; i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int d = sc.nextInt();
            long result = -1;
            int start = 1;
            int end = d;
            boolean chk = false;
            while (start <= end){
                int mid = (start+end)/2;
                if(((long) k*mid*(m*(m-1))*n + (long) mid*m*m*(n*(n-1))) <= 2*d){
                    start = mid+1;
                }else if(((long) k*mid*(m*(m-1))*n + (long) mid*m*m*(n*(n-1))) > 2*d){
                    end = mid-1;
                }
            }
            result = (long) (k*(start-1)*(m*(m-1))/2*n + (start-1)*m*m*(n*(n-1)/2));
            if(result == 0){
                System.out.println(-1);
            }else{
                System.out.println(result);
            }
        }
    }
}
