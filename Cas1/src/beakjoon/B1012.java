package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B1012 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            String[] fir = br.readLine().split(" ");
            int row = Integer.parseInt(fir[0]);
            int col = Integer.parseInt(fir[1]);
            int cnt = Integer.parseInt(fir[2]);
            int[][] map = new int[col][row];
            boolean[][] visited = new boolean[col][row];
            Point[] list = new Point[cnt];
            for(int i=0; i<cnt; i++){
                fir = br.readLine().split(" ");
                int x = Integer.parseInt(fir[1]);
                int y = Integer.parseInt(fir[0]);
                map[x][y] = 1;
                list[i] = new Point(x, y);
            }
            answer = 0;

            for(Point tmp : list){
                bfs(tmp, visited, map);
            }
            System.out.println(answer);
        }

    }
    static void bfs(Point start, boolean[][] visited, int[][] map){
        Queue<Point> queue = new LinkedList<>();
        if(!visited[start.x][start.y]){
            queue.offer(start);
            visited[start.x][start.y] = true;
            while (!queue.isEmpty()){
                Point tmp = queue.poll();
                for(int i=0; i<4; i++){
                    int x = tmp.x + dx[i];
                    int y = tmp.y + dy[i];
                    if(x<0 || x>= map.length || y < 0 || y >= map[0].length) continue;
                    if(visited[x][y] || map[x][y] == 0) continue;
                    queue.offer(new Point(x, y));
                    visited[x][y] = true;
                }
            }
            answer += 1;
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
