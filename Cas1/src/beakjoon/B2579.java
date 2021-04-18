package beakjoon;

import java.util.Arrays;
import java.util.Scanner;

public class B2579 {
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] map = new int[n];
        for(int i=0; i<n; i++){
            map[i] = sc.nextInt();
        }
        int[] dp = new int[n];
        dp[0] = map[0];
        if(n >=2){
            dp[1] = map[0]+map[1];
            if(n >=3){
                dp[2] = Math.max(map[0]+map[2], map[1]+map[2]);
                for(int ans=3; ans<n; ans++){
                    dp[ans] = map[ans]+Math.max(map[ans-1]+dp[ans-3], dp[ans-2]);
                }
            }
        }
        System.out.println(dp[n-1]);
    }
}
