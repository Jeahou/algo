package beakjoon;

import java.util.*;

public class B2437 {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] list = new int[n];
            for(int i=0; i<n; i++){
                list[i] = sc.nextInt();
            }
            Arrays.sort(list);
            int[] answer = new int[n];
            int sum = 0;
            int ans = 0;
            for(int i=0; i<n; i++){
                if(i==0 && list[i] > 1) {
                    ans = 1;
                    break;
                }
                sum += list[i];
                if(i<n-1 && list[i+1] > sum+1){
                    ans = sum+1;
                    break;
                }
            }
            if(ans == 0) ans = sum+1;
            System.out.println(ans);
        }
}
