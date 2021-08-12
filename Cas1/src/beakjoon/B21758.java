package beakjoon;

import java.util.Scanner;

public class B21758 {
    static int n, mid, right, left;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] list = new int[n];
        int sum = 0;
        int max = 0;
        for(int i=0; i<n; i++){
            int tmp = sc.nextInt();
            if(i>0 && i<n-1){
                sum += tmp;
                if(tmp > max) max = tmp;
            }
            list[i] = tmp;
        }
        mid = sum + max;
        right = rightCal(list, sum);
        left = leftCal(list, sum);
        int result = mid > right ? mid : right;
        result = result > left ? result : left;
        System.out.println(result);
    }
    static int rightCal(int[] list, int sum){
        int tmp = sum + list[n-1]*2;
        int max = tmp - list[n-2];
        int prior = 0;
        for(int i=n-3; i>=1; i--){
            prior += list[i+1];
            if(max < prior + sum - list[i]+ list[n-1]*2) max = prior + sum - list[i] + list[n-1]*2;
        }
        return max;
    }
    static int leftCal(int[] list, int sum){
        int tmp = sum + list[0]*2;
        int max = tmp - list[1];
        int prior = 0;
        for(int i=2; i<n-1; i++){
            prior += list[i-1];
            if(max < prior + sum - list[i]+ list[0]*2) max = prior + sum - list[i] + list[0]*2;
        }
        return max;
    }
}
