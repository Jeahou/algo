package samsung.d4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S5653 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Point> queue;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] map = new int[n+k][m+k];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i+k/2][j+k/2] = sc.nextInt();
            }
        }
        queue = new LinkedList<>();
        boolean[][] visited = new boolean[n+k+k][m+k+k];
        for(int i=1; i<=k; i++){
            bfs(map, i, visited);
            for(int[] s : map){
                System.out.println(Arrays.toString(s));
            }
            System.out.println(" ");
        }
    }
    static void bfs(int[][] map, int t, boolean[][] visited){
        int answer = 0;
        while (!queue.isEmpty()){
            Point tmp = queue.poll();
            for(int i=0; i<4; i++){
                int x = tmp.x + dx[i];
                int y = tmp.y + dy[i];
                if(x < 0 || x >= map.length || y < 0 || y >= map[0].length) continue;
                if(visited[x][y]) continue;
                if(map[x][y] < tmp.count) map[x][y] = tmp.count;
            }
        }
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                if(map[i][j] == t) {
                    if(!visited[i][j]){
                        queue.offer(new Point(i, j, map[i][j]));
                        visited[i][j] = true;
                    }
                }
                if(visited[i][j]){
                    if(map[i][j] >= 0) map[i][j] -= 1;
                    if(map[i][j] >= 0) answer += 1;
                }
            }
        }
        System.out.println(answer);
    }
    static class Point{
        int x, y, count;

        Point(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
