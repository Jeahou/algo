package beakjoon;

import java.util.Arrays;
import java.util.Scanner;

public class B2873 {
    static int r,c;
    static int[][] map, dp;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static String answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        map = new int[c][r];
        dp = new int[c][r];
        for(int i=0; i<c; i++){
            for(int j=0; j<r; j++){
                map[i][j] = sc.nextInt();
            }
        }
        dp[0][0] = map[0][0];
        boolean[][] visited = new boolean[c][r];
        visited[0][0]=true;
        dfs(new Point(0,0), visited, dp[0][0], new StringBuilder());
        System.out.println(answer);
    }
    static void dfs(Point point, boolean[][] visited, int sum, StringBuilder sb){
        if(point.x == c-1 && point.y == r-1){
            answer = sb.toString();
            return;
        }
        for(int i=0; i<4; i++){
            int x = point.x + dx[i];
            int y = point.y + dy[i];
            if(x<0 || x>=c || y<0 || y>=r) continue;
            if(visited[y][x]) continue;
            if(dp[y][x] == 0) {
                dp[y][x] = sum + map[y][x];
            }else{
                if(dp[y][x] < sum + map[y][x]) {
                    dp[y][x] = sum + map[y][x];
                }else{
                    continue;
                }
            }
            if(i==0){
                sb.append("R");
            }else if(i==1){
                sb.append("L");
            }else if(i==2){
                sb.append("D");
            }else{
                sb.append("U");
            }
            visited[y][x] = true;
            dfs(new Point(x,y), visited, sum+map[y][x], sb);
            sb.delete(sb.length()-1,sb.length());
            visited[y][x] = false;
        }
    }
    static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
