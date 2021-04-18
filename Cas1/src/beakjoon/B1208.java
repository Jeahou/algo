package beakjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class B1208 {
    static int s;
    static long answer;
    static ArrayList<Integer> front;
    static ArrayList<Integer> back;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        s = sc.nextInt();
        answer = 0;
        int[] pri = new int[n/2];
        int[] last = new int[n/2 + n%2];
        int idx = 0;
        for(int i=0; i<n; i++){
            if(i < n/2){
                pri[idx++] = sc.nextInt();
            }else if(i==n/2){
                idx = 0;
                last[idx++] = sc.nextInt();
            }else{
                last[idx++] = sc.nextInt();
            }
        }
        front = new ArrayList<>();
        back = new ArrayList<>();
        for(int i=1; i<=pri.length; i++){
            comb(pri, 0, new boolean[pri.length], i, 0, front);
        }
        for(int i=1; i<=last.length; i++){
            comb(last, 0, new boolean[last.length], i, 0, back);
        }
        Collections.sort(front);
        Collections.sort(back);

        int leftIdx = 0;
        int rightIdx = back.size()-1;
        while (leftIdx < front.size() && rightIdx >= 0){
            int la = front.get(leftIdx);
            int ra = back.get(rightIdx);
            if(la+ra == s){
                long lans = 0;
                while (leftIdx < front.size() && la == front.get(leftIdx)){
                    lans++;
                    leftIdx++;
                }
                long rans = 0;
                while (rightIdx >= 0 && ra == back.get(rightIdx)){
                    rans++;
                    rightIdx--;
                }
                answer += lans*rans;
            }
            if(la + ra < s) leftIdx++;
            if(la + ra > s) rightIdx--;
        }
        System.out.println(answer);

    }

    static void comb(int[] map, int start, boolean[] visited, int r, int output, ArrayList<Integer> aList){
        if(r == 0){
            if(s == output) answer +=1;
            aList.add(output);
            return;
        }
        for(int i=start; i<map.length; i++){
            if(!visited[i]) {
                visited[i] = true;
                output += map[i];
                comb(map, i, visited, r - 1, output, aList);
                output -= map[i];
                visited[i]=false;
            }
        }
    }
}
