package beakjoon;

import java.util.Arrays;
import java.util.Scanner;

public class B2294 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] map = new int[n];
        int[] dp = new int[m+1];
        for(int i=0; i<n; i++){
            int t = sc.nextInt();
            map[i] = t;
        }
        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[0] = 0;
        for(int i=0; i<n; i++){
            for(int j=map[i]; j<=m; j++){
                dp[j] = Math.min(dp[j], dp[j-map[i]]+1);
            }
        }
        if(dp[m] == Integer.MAX_VALUE-1){
            System.out.println(-1);
        }else{
            System.out.println(dp[m]);
        }
    }
}
