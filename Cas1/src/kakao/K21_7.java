package kakao;

import java.util.*;

public class K21_7 {
    static int[][] dp;
    static int count;
    public static void main(String[] args) {
        int[] sales = {10, 10, 1, 1};
        int[][] links = {{3, 2}, {4,3}, {1,4}};
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<sales.length; i++){
            list.add(new ArrayList<Integer>());
        }
        int[][] map = new int[sales.length][sales.length];
        for(int i=0; i<links.length; i++){
            map[links[i][0]-1][links[i][1]-1] = 1;
            list.get(links[i][0]-1).add(links[i][1]-1);
        }
        System.out.println(list);
        count = 1;
        dp = new int[sales.length][2];
        /*dfs(0, map, sales, new boolean[sales.length]);
        for(int i=0; i<dp.length; i++){
            System.out.println(Arrays.toString(dp[i]));
        }*/
        // dfs는 인접행렬 dfs2는 인접리스트
        dfs2(0, list, sales, new boolean[sales.length]);
        for(int i=0; i<dp.length; i++){
            System.out.println(Arrays.toString(dp[i]));
        }
    }
    static void dfs(int start, int[][] map,  int[] sales, boolean[] visited){
        for(int i=0; i<map.length; i++){
            if(map[start][i] == 1 && !visited[i]){
                visited[i] = true;
                dfs(i, map, sales, visited);
                visited[i] = false;
            }
        }
        int t = start;
        int max = Integer.MAX_VALUE;
        int idx = -1;
        dp[t][1] += sales[t];
        for(int i=0; i< map.length; i++){
            if(map[start][i] == 1) {
                int a = dp[i][0] > dp[i][1] ? dp[i][1] : dp[i][0];
                dp[t][1] += a;
                if (max > dp[i][1] - dp[i][0]) {
                    max = dp[i][1] - dp[i][0];
                    idx = i;
                }
            }
        }
        for(int i=0; i<map.length; i++){
            if(map[start][i] == 1) {
                if (i != idx) {
                    int a = dp[i][0] > dp[i][1] ? dp[i][1] : dp[i][0];
                    dp[t][0] += a;
                } else {
                    dp[t][0] += dp[i][1];
                }
            }
        }
    }
    static void dfs2(int start, ArrayList<ArrayList<Integer>> map,  int[] sales, boolean[] visited){
        visited[start] = true;
        for(int t : map.get(start)){
            if(!visited[t]){
                dfs2(t, map, sales, visited);
            }
        }

        int t = start;
        int max = Integer.MAX_VALUE;
        int idx = -1;
        dp[t][1] += sales[t];
        if(map.get(t).size() == 0){
            dp[t][0] = 0;
        }else{
            for(int i : map.get(t)){
                int a = dp[i][0] > dp[i][1] ? dp[i][1] : dp[i][0];
                dp[t][1] += a;
                if (max > dp[i][1] - dp[i][0]) {
                    max = dp[i][1] - dp[i][0];
                    idx = i;
                }
            }
            for(int i : map.get(t)){
                if (i != idx) {
                    int a = dp[i][0] > dp[i][1] ? dp[i][1] : dp[i][0];
                    dp[t][0] += a;
                } else {
                    dp[t][0] += dp[i][1];
                }
            }
        }
    }

}
