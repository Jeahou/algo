package beakjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2606 {
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<Integer>());
        }
        for(int i=0; i<m; i++){
            int fir = sc.nextInt();
            int sec = sc.nextInt();
            list.get(fir).add(sec);
            list.get(sec).add(fir);
        }
        answer = -1;
        bfs(list, 1, new boolean[n+1]);
        System.out.println(answer);
    }
    static void bfs(ArrayList<ArrayList<Integer>> list, int start, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()){
            int tmp = queue.poll();
            answer += 1;
            for(int i : list.get(tmp)){
                if(!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
