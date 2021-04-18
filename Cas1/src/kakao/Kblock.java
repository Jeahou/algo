package kakao;

import java.util.LinkedList;
import java.util.Queue;

public class Kblock {
    static boolean[][] visited;
    //   1
    // 2  4
    //   3
    static int[] xDir = {1, -1, 0, 0};
    static int[] yDir = {0, 0, 1, -1};

    public static void main(String[] args) {
        int[][] map = {{0, 0, 0, 1, 0},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}};
        Robot robot = new Robot(0,0, 0,1, 4, 0);
        visited = new boolean[map.length][map.length];

    }
    static int bfs(Robot r, boolean[][] visited){
        Queue<Robot> queue = new LinkedList<>();
        queue.add(r);
        visited[r.x1][r.y1] = true;
        visited[r.x2][r.y2] = true;
        while (!queue.isEmpty()){
            Robot tmp = queue.poll();
            for(int i=0; i<4; i++){
                Robot nTmp = new Robot(tmp.x1+xDir[i], tmp.y1+yDir[i] , tmp.x2+xDir[i], tmp.y2+yDir[i], tmp.dir, tmp.distance+1);
                if(check(nTmp.x1, nTmp.y1) && check(nTmp.x2, nTmp.y2)){
                    if(visited[nTmp.x1][nTmp.y1] || visited[nTmp.x2][nTmp.y2]){
                        queue.add(nTmp);
                    }
                }
            }
        }
        return 0;
    }
    static boolean check(int x, int y){
        if(x <0 || x >= visited.length || y < 0 || y >= visited.length) {
            return false;
        }else {
            return true;
        }
    }
    static class Robot{
        int x1;
        int y1;
        int x2;
        int y2;
        int dir;
        int distance;
        Robot(int x1, int y1, int x2, int y2, int dir, int dis){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.dir = dir;
            this.distance = dis;
        }
    }
}
