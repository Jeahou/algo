package beakjoon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class B15961 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int max = 0;
        int n = sc.nextInt();
        int d = sc.nextInt();
        int k = sc.nextInt();
        int c = sc.nextInt();
        int[] dish = new int[n];
        int[] visited = new int[d+1];
        for(int i=0; i<n; i++){
            dish[i] = sc.nextInt();
        }
        for(int i=0; i<k; i++){
            if(visited[dish[i]] == 0) answer++;
                visited[dish[i]]++;
        }
        max = answer;
        for(int i=1; i<n; i++){
            if(max <= answer){
                if(visited[c] == 0) max +=1;
                else max = answer;
            }
            visited[dish[i-1]]--;
            if(visited[dish[i-1]] == 0) answer -=1;

            if(visited[dish[(i+k-1) % n]] == 0) answer += 1;
            visited[dish[(i+k-1) % n]]++;
        }
        System.out.println(max);
    }
}
