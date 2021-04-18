package samsung.d4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S5656 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n, w, h;
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        w = sc.nextInt();
        h = sc.nextInt();
        answer = Integer.MAX_VALUE;
        int[][] map = new int[h][w];
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                map[i][j] = sc.nextInt();
            }
        }
        dfs(map, 0, 0, 0, 0);
        System.out.println(answer);

    }
    static void dfs(int[][] map, int x, int y, int depth, int count){
        if(depth != 0){
            bomb(map, y, x);
            count = clearBlock(map);
            if(count == 0) {
                answer = 0;
                return;
            }
        }
        if(depth == n){
            if(answer > count) answer = count;
            for(int[] a : map){
                System.out.println(Arrays.toString(a));
            }
            System.out.println(" ");
            return;
        }

        for(int i=0; i<map[0].length; i++){
            for(int j=0; j<map.length; j++){
                if(map[j][i] !=0){
                    int[][] tmp = new int[h][w];
                    for(int ii=0; ii<h; ii++){
                        for(int jj=0; jj<w; jj++){
                            tmp[ii][jj] = map[ii][jj];
                        }
                    }
                    dfs(tmp , i, j, depth+1, count);
                    break;
                }
            }
        }
    }
    static void bomb(int[][] map, int x, int y){
        int count = map[x][y];
        map[x][y] = 0;
        for(int i=1; i<count; i++){
            for(int j=0; j<4; j++){
                int cX = x + dx[j]*i;
                int cY = y + dy[j]*i;
                if(cX < 0 || cX >= map.length || cY < 0 || cY >= map[0].length) continue;
                if(map[cX][cY] == 0) continue;
                bomb(map, cX, cY);
            }
        }
    }
    static int clearBlock(int[][] map){
        int count = 0;
        for(int i=0; i<map[0].length; i++){
            Queue<Integer> queue = new LinkedList<>();
            int idx = map.length-1;
            for(int j=map.length-1; j>=0; j--){
                if(map[j][i] != 0) {
                    count++;
                    queue.offer(map[j][i]);
                    map[j][i] = 0;
                }
            }
            while (!queue.isEmpty()){
                map[idx--][i] = queue.poll();
            }
        }
        return count;
    }
}
