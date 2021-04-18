package beakjoon;

import java.util.Arrays;
import java.util.Scanner;

public class B2613 {
    static int[] map;
    static int n,m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n];
        for(int i=0; i<n; i++){
            map[i] = sc.nextInt();
        }
        int start=1, end=100*n;
        while (start<=end){
            int mid = (start + end)/2;
            if(maxSum(mid)){
                end = mid-1;
            }else{
                start = mid +1;
            }
        }
        System.out.println(start);
        int[] answer = solve(start);
        noZero(answer);
        for(int i=0; i<answer.length; i++){
            if(i != answer.length-1){
                System.out.print(answer[i] + " ");
            }else{
                System.out.println(answer[i]);
            }
        }

    }
    static int[] solve(int val){
        int[] answer = new int[m];
        int idx = 0;
        int sum = 0, count = 0;
        for(int i=0; i<n; i++){
            sum += map[i];
            if(sum <= val){
                count++;
            }else{
                answer[idx++] = count;
                sum = map[i];
                count = 1;
            }

        }
        answer[idx] = count;

        return answer;
    }
    // 그룹에 0이 없게 만들기
    static void noZero(int[] answer){
        int idx;
        for(int i=0; i<answer.length; i++){
            if(answer[i] == 0){
                idx = i-1;
                answer[i]++;
                while (true){
                    if(answer[idx] == 1){
                        idx--;
                        continue;
                    }
                    break;
                }
                answer[idx]--;
            }
        }
    }
    // 되는지 안되는지 찾기
    static boolean maxSum(int val){
        int sum = 0, cnt = 1;
        for(int i=0; i<n; i++){
            if(map[i] > val) return false;
            if(cnt > m) return false;
            if(sum + map[i] <= val){
                sum += map[i];
            }else {
                cnt++;
                sum = map[i];
            }
        }
        return cnt <= m;
    }
}
