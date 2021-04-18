package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class B2667 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static ArrayList<Integer> sum;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        ArrayList<Point> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            String[] fir = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(fir[j]);
                if(fir[j].equals("1")) list.add(new Point(i,j));
            }
        }
        boolean[][] visited = new boolean[n][n];
        sum = new ArrayList<Integer>();
        for(Point start : list){
            bfs(map, start, visited);
        }
        answer = sum.size();
        System.out.println(answer);
        Collections.sort(sum);
        for(int tmp : sum){
            System.out.println(tmp);
        }
    }
    static void bfs(int[][] map, Point start, boolean[][] visited){
        if(!visited[start.x][start.y]){
            int listAnswer = 1;
            Queue<Point> queue = new LinkedList<>();
            queue.offer(start);
            visited[start.x][start.y] = true;
            while (!queue.isEmpty()){
                Point tmp = queue.poll();
                for(int i=0; i<4; i++){
                    int x = tmp.x + dx[i];
                    int y = tmp.y + dy[i];
                    if(x < 0 || x >= map.length || y < 0 || y >= map[0].length) continue;
                    if(visited[x][y] || map[x][y] == 0) continue;
                    visited[x][y] = true;
                    listAnswer += 1;
                    queue.offer(new Point(x, y));
                }
            }
            sum.add(listAnswer);
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
