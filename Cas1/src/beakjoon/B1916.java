package beakjoon;

import java.util.*;

public class B1916 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<City>> list = new ArrayList<ArrayList<City>>();
        for(int i=0; i<n; i++){
            list.add(new ArrayList<City>());
        }
        for(int i=0; i<m; i++){
            int idx = sc.nextInt()-1;
            list.get(idx).add(new City(sc.nextInt()-1, sc.nextInt()));
        }
        int start = sc.nextInt()-1;
        int end = sc.nextInt() -1;
        /*int low = 1;
        int high = Integer.MAX_VALUE;
        if(start != end){
            while (low<=high){
                int mid = (high+low)/2;
                if(bfs(list, new boolean[n], start, end, mid)){
                    high= mid-1;
                }else{
                    low = mid +1;
                }
            }
            System.out.println(low);
        }else{
            System.out.println(0);
        }*/
        int[] tt = dijkstra(list,new int[n], start, end, new boolean[n]);
        System.out.println(tt[end]);
    }

    static boolean bfs(ArrayList<ArrayList<City>> list, boolean[] visited, int start, int end, int val){
        Queue<City> queue = new LinkedList<>();
        queue.offer(new City(start, 0));
        visited[start] =true;
        while (!queue.isEmpty()){
            City tmp = queue.poll();
            for(City c : list.get(tmp.goal)){
                if(val < c.cost + tmp.cost) continue;
                if(visited[c.goal]) continue;
                if(c.goal == end) return true;
                queue.offer(new City(c.goal, c.cost+tmp.cost));
                visited[c.goal] = true;
            }
        }
        return false;
    }
    static int[] dijkstra(ArrayList<ArrayList<City>> list, int[] map, int start, int end, boolean[] visited){
        Arrays.fill(map, Integer.MAX_VALUE);
        PriorityQueue<City> pq = new PriorityQueue<City>();
        pq.offer(new City(start, 0));
        map[start] = 0;
        while (!pq.isEmpty()){
            City tmp = pq.poll();
            int t = tmp.goal;
            if(!visited[t]){
                visited[t] = true;
                for(City c : list.get(t)){
                    if(!visited[c.goal] && map[c.goal] > map[t] + c.cost){
                        map[c.goal] = map[t] + c.cost;
                        pq.add(new City(c.goal, map[c.goal]));
                    }
                }
            }
        }

        return map;
    }
    static class City implements Comparable<City>{
        int goal;
        int cost;

        City(int goal, int cost){
            this.goal = goal;
            this.cost = cost;
        }

        @Override
        public int compareTo(City city) {
            return this.cost - city.cost;
        }
    }
}
