package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class B2468 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int maxHigh = 0;
        for(int i=0; i<n; i++){
            String[] fir = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                int tmp = Integer.parseInt(fir[j]);
                map[i][j] = tmp;
                maxHigh = Math.max(tmp, maxHigh);
            }
        }
        int[] answerList = new int[maxHigh+1];
        int answer = 1;
        for(int cnt=1; cnt<maxHigh; cnt++){
            ArrayList<Point> pList = new ArrayList<>();
            boolean[][] visited = new boolean[n][n];
            int ans = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(map[i][j] > cnt) pList.add(new Point(i,j));
                }
            }
            for(Point start : pList){
                if(!visited[start.x][start.y]){
                    bfs(map, start,cnt, visited);
                    ans +=1;
                }
            }
            answer = Math.max(ans, answer);
        }
        System.out.println(answer);
    }
    static void bfs(int[][] map,Point start, int max, boolean[][] visited){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.x][start.y] = true;
        while (!queue.isEmpty()){
            Point tmp = queue.poll();
            for(int i=0; i<4; i++){
                int x = tmp.x + dx[i];
                int y = tmp.y + dy[i];

                if(x < 0 || x >= map.length || y < 0 || y >= map.length) continue;
                if(visited[x][y] || map[x][y] <= max) continue;
                visited[x][y] = true;
                queue.offer(new Point(x, y));
            }
        }
    }
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
