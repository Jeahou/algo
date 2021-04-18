package kakao;

import java.util.*;

public class K21_6 {
    static int[] dX = {1, -1, 0, 0};
    static int[] dY = {0, 0, 1, -1};
    static ArrayList<int[]> iList = new ArrayList<>();
    public static void main(String[] args) {
        int[][] board = {{3,0,0,2},{0,0,1,0},{0,1,0,0},{2,0,0,3}};
        int r = 0;
        int c = 1;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                if(!list.contains(board[i][j]) && board[i][j] != 0) list.add(board[i][j]);
            }
        }
        int[] sList = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            sList[i] = list.get(i);
        }
        dfs(0, sList);
        HashSet<Integer> hashSet = new HashSet<>();
        int realAnswer = Integer.MAX_VALUE;
        for(int i =0 ; i<iList.size(); i++){
            int[] startList = iList.get(i);
            int answer = 0;
            int sX = r;
            int sY = c;
            System.out.println(Arrays.toString(startList));
            for(int j =0; j<startList.length; j++){
                Point start = new Point(sX, sY, 0);
                if(board[start.x][start.y] != startList[j]){
                    start = bfs(board, startList[j], start, new boolean[4][4], hashSet);
                    answer += start.count;
                    start.count = 0;
                }
                start = bfs(board, startList[j], start, new boolean[4][4], hashSet);
                hashSet.add(startList[j]);
                answer += start.count;
                start.count = 0;
                sX = start.x;
                sY = start.y;
            }
            hashSet.clear();
            System.out.println(answer);
            realAnswer = realAnswer < answer ? realAnswer : answer;
        }
        realAnswer += sList.length*2;
        System.out.println(realAnswer);

    }
    static class Point{
        int x;
        int y;
        int count;
        
        Point(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    static Point bfs(int[][] map, int idx, Point start, boolean[][] chechkMap, HashSet<Integer> hashSet){
        Queue<Point> queue = new LinkedList<>();
        Point answer = null;
        queue.offer(start);
        chechkMap[start.x][start.y] =true;
        while (!queue.isEmpty()){
            Point nP = queue.poll();
            if(map[nP.x][nP.y] == idx && nP.count != 0 ){
                answer = nP;
                break;
            }
            for(int i=0; i<4; i++){
                int newX = nP.x + dX[i];
                int newY = nP.y + dY[i];
                int newP = nP.count +1;
                if(newX < 0 || newX > 3 || newY < 0 || newY >3) continue;
                if(!chechkMap[newX][newY]){
                    queue.offer(new Point(newX, newY, newP));
                    chechkMap[newX][newY] = true;
                }
                if(map[newX][newY] == 0 || hashSet.contains(map[newX][newY])){
                    while (map[newX][newY] == 0 || hashSet.contains(map[newX][newY])){
                        newX += dX[i];
                        newY += dY[i];
                        if(newX < 0 || newX >3 || newY < 0 || newY > 3){
                            newX -= dX[i];
                            newY -= dY[i];
                            break;
                        }
                    }
                    if(chechkMap[newX][newY]) continue;
                    chechkMap[newX][newY] = true;
                    queue.offer(new Point(newX, newY, newP));
                }

            }
        }
        return answer;
    }
    static void swap(int i, int j, int[] a){
        int pix = a[i];
        a[i] = a[j];
        a[j] = pix;
    }

    static void dfs(int depth, int[] a){
        if(a.length == depth){
            int[] tmp = Arrays.copyOf(a, a.length);
            if(!iList.contains(tmp)){
                iList.add(tmp);
            }
        }else{
            for(int i=depth; i<a.length; i++){
                swap(depth, i, a);
                dfs(depth+1, a);
                swap(depth, i, a);
            }
        }
    }
}
