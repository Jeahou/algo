package beakjoon;

import java.util.*;

public class B17280 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0; t<T; t++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<Integer> pass = new ArrayList<>();
            for(int i=0; i<n; i++){
                pass.add(sc.nextInt());
            }
            int[][] ride = new int[m][2];
            for(int i=0; i<m; i++){
                ride[i][0] = sc.nextInt();
                ride[i][1] = sc.nextInt();
            }
            Collections.sort(pass);
            Arrays.sort(ride, new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    if(ints[0] == t1[0]){
                        return ints[1] - t1[1];
                    }else{
                        return ints[0] - t1[0];
                    }
                }
            });
            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    return ints[1] - t1[1];
                }
            });
            int answer = 0;
            int idx = 0;
            for(int i=0; i<pass.size(); i++){
                while (idx < ride.length && ride[idx][0] <= pass.get(i)){
                    priorityQueue.offer(ride[idx++]);
                }

                while (!priorityQueue.isEmpty() && priorityQueue.peek()[1] < pass.get(i)) priorityQueue.poll();

                if(!priorityQueue.isEmpty() &&priorityQueue.peek()[1] >= pass.get(i)){
                    priorityQueue.poll();
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }
}
