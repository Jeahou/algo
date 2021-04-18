package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class B14502 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] fir = br.readLine().split(" ");
        int n = Integer.parseInt(fir[0]);
        int m = Integer.parseInt(fir[1]);
        int[][] map = new int[n][m];
        ArrayList<Point> list = new ArrayList<>();
        ArrayList<Point> vList = new ArrayList<>();
        for(int i=0; i<n; i++){
            fir = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(fir[j]);
                if(fir[j].equals("0")) list.add(new Point(i, j));
                if(fir[j].equals("2")) vList.add(new Point(i, j));
            }
        }
        answer = 0;
        per(list, vList, 0,0 , new boolean[list.size()], new Point[3], map);
        System.out.println(answer);

    }
    static void per(ArrayList<Point> list, ArrayList<Point> vList, int start, int c, boolean[] visited, Point[] outList, int[][] map){
        if(c == 3){
            int a = bfs(map, vList, new boolean[map.length][map[0].length], outList);
            answer = a > answer ? a : answer;
            return;
        }else{
            for(int i=start; i<list.size(); i++){
                if(!visited[i]){
                    outList[c] = list.get(i);
                    visited[i] = true;
                    per(list, vList, i+1,c+1, visited, outList, map);
                    visited[i] = false;
                }
            }
        }
    }
    static int bfs(int[][] map, ArrayList<Point> start, boolean[][] visited, Point[] blockList){
        int[][] tmpMap = new int[map.length][map[0].length];
        int answer = 0;
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                tmpMap[i][j] = map[i][j];
            }
        }
        for(Point tmp : blockList){
            tmpMap[tmp.x][tmp.y] = 1;
        }
        Queue<Point> queue = new LinkedList<>();
        for(Point p : start){
            queue.offer(p);
            visited[p.x][p.y] = true;
        }
        while (!queue.isEmpty()){
            Point tmp = queue.poll();
            for(int i=0; i<4; i++){
                int x = tmp.x + dx[i];
                int y = tmp.y + dy[i];
                if(x <0 || x>= map.length || y <0 || y>= map[0].length) continue;
                if(visited[x][y] || tmpMap[x][y] == 1) continue;
                queue.offer(new Point(x,y));
                visited[x][y] = true;
                tmpMap[x][y] = 2;
            }
        }
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                if(tmpMap[i][j] == 0) answer += 1;
            }
        }
        return answer;
    }
    static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
