package kakao;

import java.util.LinkedList;
import java.util.Queue;

public class K20_7 {
    static int[] xDir = {1, -1, 0, 0};
    static int[] yDir = {0, 0, 1, -1};
    static int[] rDir = {1, -1};
    public static void main(String[] args) {
        // dir 1은 가로방향 -1은 세로 방향
        int[][] map =  {{0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 0, 0}, {0, 1, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 1, 1, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0}};
        Robot r1 = new Robot(0,0 ,0, 1, 1, 0);
        int k = map.length;
        System.out.println(bfs(r1, new boolean[k][k], new  boolean[k][k], map));
    }
    static int bfs(Robot r1, boolean[][] rowVisited, boolean[][] colVisited, int[][] map){
        int answer = 0;
        Queue<Robot> queue = new LinkedList<>();
        int n = map.length-1;
        System.out.println(n);
        rowVisited[r1.x1][r1.y1] = true;
        rowVisited[r1.x2][r1.y2] = true;
        queue.offer(r1);
        while (!queue.isEmpty()){
            Robot tmp = queue.poll();
            if((tmp.x1 == n && tmp.y1 == n) || (tmp.x2 == n && tmp.y2 == n)){
              answer = tmp.count;
              break;
            }
            if(tmp.dir == 1){
                for(int i=0; i<4; i++){
                    int newX1 = tmp.x1 + xDir[i];
                    int newY1 = tmp.y1 + yDir[i];
                    int newX2 = tmp.x2 + xDir[i];
                    int newY2 = tmp.y2 + yDir[i];
                    int dir = tmp.dir;
                    if(newX1 < 0 || newX1 > n || newY1 < 0 || newY1 > n || newY2 < 0 || newY2 > n || newX2 < 0 || newX2 > n) continue;
                    //System.out.println(newX1 + " " + newY1 + " " + newX2 + " " + newY2);
                    if(map[newX1][newY1] == 1 || map[newX2][newY2] == 1) continue;
                    if(rowVisited[newX1][newY1] && rowVisited[newX2][newY2]) continue;
                    Robot nRobot = new Robot(newX1, newY1, newX2, newY2, dir, tmp.count+1);
                    rowVisited[newX1][newY1] = true;
                    rowVisited[newX2][newY2] = true;
                    queue.offer(nRobot);
                }
                for(int i=-1; i<=1; i+=2){
                    int newX1 = tmp.x1 + i;
                    int newY1 = tmp.y1;
                    int newX2 = tmp.x2 + i;
                    int newY2 = tmp.y2;
                    if(newX1 < 0 || newX1 > n || newY1 < 0 || newY1 > n || newY2 < 0 || newY2 > n || newX2 < 0 || newX2 > n) continue;
                    if(map[newX1][newY1] == 1 || map[newX2][newY2] == 1) continue;

                    if(!(colVisited[tmp.x1][newY1] && colVisited[newX1][newY1])){
                        Robot nR = new Robot(tmp.x1, newY1, newX1, newY1, -1, tmp.count+1);
                        colVisited[tmp.x1][newY1] = true;
                        colVisited[newX1][newY1] = true;
                        queue.offer(nR);
                    }
                    if(!(colVisited[tmp.x2][newY2] && colVisited[newX2][newY2])){
                        Robot nR = new Robot(newX2, newY2, tmp.x2, newY2, -1, tmp.count+1);
                        colVisited[tmp.x2][newY2] = true;
                        colVisited[newX2][newY2] = true;
                        queue.offer(nR);
                    }
                }
            }else{
                for(int i=0; i<4; i++){
                    int newX1 = tmp.x1 + xDir[i];
                    int newY1 = tmp.y1 + yDir[i];
                    int newX2 = tmp.x2 + xDir[i];
                    int newY2 = tmp.y2 + yDir[i];
                    int dir = tmp.dir;
                    if(newX1 < 0 || newX1 > n || newY1 < 0 || newY1 > n || newY2 < 0 || newY2 > n || newX2 < 0 || newX2 > n) continue;
                    if(map[newX1][newY1] == 1 || map[newX2][newY2] == 1) continue;
                    if(colVisited[newX1][newY1] && colVisited[newX2][newY2]) continue;
                    Robot nRobot = new Robot(newX1, newY1, newX2, newY2, dir, tmp.count+1);
                    colVisited[newX1][newY1] = true;
                    colVisited[newX2][newY2] = true;
                    queue.offer(nRobot);
                }
                for(int i=-1; i<=1; i+=2){
                    int newX1 = tmp.x1;
                    int newY1 = tmp.y1 + i;
                    int newX2 = tmp.x2;
                    int newY2 = tmp.y2 + i;
                    if(newX1 < 0 || newX1 > n || newY1 < 0 || newY1 > n || newY2 < 0 || newY2 > n || newX2 < 0 || newX2 > n) continue;
                    if(map[newX1][newY1] == 1 || map[newX2][newY2] == 1) continue;
                    if(!(rowVisited[newX1][tmp.y1] && rowVisited[newX1][newY1])){
                        Robot nR = new Robot(newX1, tmp.y1, newX1, newY1, 1, tmp.count+1);
                        rowVisited[newX1][tmp.y1] = true;
                        rowVisited[newX1][newY1] = true;
                        queue.offer(nR);
                    }
                    if(!(rowVisited[newX2][tmp.y2] && rowVisited[newX2][newY2])){
                        Robot nR = new Robot(newX2, tmp.y2, newX2, newY2, 1, tmp.count+1);
                        rowVisited[newX2][tmp.y2] = true;
                        rowVisited[newX2][newY2] = true;
                        queue.offer(nR);
                    }
                }
            }
        }
        return answer;
    }
    static class Robot{
        int x1;
        int x2;
        int y1;
        int y2;
        int count;
        int dir;

        public Robot(int x1, int y1, int x2, int y2, int dir, int count){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.count = count;
            this.dir = dir;
        }
    }
}
