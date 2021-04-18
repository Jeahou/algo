package beakjoon;

import java.util.*;

public class B1939 {
    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        ArrayList<ArrayList<IsLand>> list = new ArrayList<ArrayList<IsLand>>();
        for(int i=0; i<n; i++){
            list.add(new ArrayList<IsLand>());
        }
        for(int i=0; i<m; i++){
            int t1 = sc.nextInt()-1;
            int t2 = sc.nextInt()-1;
            int t3 = sc.nextInt();
            if(t3 > max) max = t3;
            if(t3 < min) min = t3;
            list.get(t1).add(new IsLand(t2, t3));
            list.get(t2).add(new IsLand(t1, t3));
        }
        int start = sc.nextInt()-1, end = sc.nextInt()-1;
        while (min<=max){
            int mid = (min+max)/2;
            if(bfs(list, new boolean[n],start, end, mid)){
                min = mid+1;
            }else{
                max = mid-1;
            }
        }
        System.out.println(max);
    }
    static boolean bfs(ArrayList<ArrayList<IsLand>> list, boolean[] visited, int start, int end, int val){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()){
            int tmp = queue.poll();
            if(tmp == end) return true;
            for(IsLand i : list.get(tmp)){
                if(i.cost >= val && !visited[i.edge]){
                    queue.offer(i.edge);
                    visited[i.edge] = true;
                }
            }
        }
        return false;
    }
    static class IsLand{
        int edge, cost;

        IsLand(int edge, int cost){
            this.edge = edge;
            this.cost = cost;
        }
    }
}
