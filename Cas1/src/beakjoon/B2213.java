package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B2213 {
    static int[][] dp;
    static ArrayList<ArrayList<Integer>> listDp1;
    static ArrayList<ArrayList<Integer>> listDp2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[] wList = new int[n];
        String[] str = br.readLine().split(" ");
        dp = new int[n][2];
        listDp1 = new ArrayList<>();
        listDp2 = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new ArrayList<Integer>());
            listDp1.add(new ArrayList<Integer>());
            listDp2.add(new ArrayList<Integer>());
            wList[i] = Integer.parseInt(str[i]);
        }
        for(int i=0; i<n-1; i++){
            str = br.readLine().split(" ");
            int fir = Integer.parseInt(str[0])-1;
            int sec = Integer.parseInt(str[1])-1;
            if(fir > sec){
                list.get(sec).add(fir);
            }else {
                list.get(fir).add(sec);
            }
        }
        dfs(0, list, wList);
        int answer = 0;
        int idx = -1;
        if(dp[0][0] > dp[0][1]){
            answer = dp[0][0];
            idx = 0;
        }else {
            answer = dp[0][1];
            idx = 1;
        }
        System.out.println(answer);
        if(idx == 1){
            Collections.sort(listDp1.get(0));
            for(int i : listDp1.get(0)){
                System.out.print(i+1 + " ");
            }
        }else{
            Collections.sort(listDp2.get(0));
            for(int i : listDp2.get(0)){
                System.out.print(i+1 + " ");
            }
        }
    }
    static void dfs(int start, ArrayList<ArrayList<Integer>> map, int[] wList){
        for(int i : map.get(start)){
            dfs(i, map, wList);
        }
        if(map.get(start).size() != 0){
            dp[start][1] += wList[start];
            listDp1.get(start).add(start);
            for(int i : map.get(start)){
                int a = dp[i][0];
                int b = dp[i][1];
                dp[start][1] += a;
                dp[start][0] += a > b ? a : b;
                for(int j : listDp2.get(i)){
                    listDp1.get(start).add(j);
                }
                if(a > b){
                    for(int j : listDp2.get(i)){
                        listDp2.get(start).add(j);
                    }
                }else{
                    for(int j : listDp1.get(i)){
                        listDp2.get(start).add(j);
                    }
                }
            }
        }else{
            dp[start][0] = 0;
            dp[start][1] = wList[start];
            listDp1.get(start).add(start);
        }
    }
}
