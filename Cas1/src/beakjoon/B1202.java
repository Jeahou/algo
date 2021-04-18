package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class B1202 {

    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        long answer = 0;
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[] bag = new int[m];
        int[][] gem = new int[n][2];
        for(int i=0; i<n; i++){
            str = br.readLine().split(" ");
            gem[i][0] = Integer.parseInt(str[0]);
            gem[i][1] = Integer.parseInt(str[1]);
        }
        for(int i=0; i<m; i++){
            String s = br.readLine();
            bag[i] = Integer.parseInt(s);
        }
        Arrays.sort(bag);
        Arrays.sort(gem, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else {
                    return o1[0] - o2[0];
                }
            }
        });

        /*for(int i : bag){
            System.out.println(i);
        }*/
        /*for(int[] i : gem){
            System.out.println(i[0] + " " + i[1]);
        }*/
        int idx = 0;
        for(int i=0; i<m; i++){
            while (idx < n && bag[i] >= gem[idx][0]){
                priorityQueue.offer(gem[idx++][1]);
            }
            if(!priorityQueue.isEmpty()){
                answer += priorityQueue.poll();
            }
        }
        //System.out.println(priorityQueue);
        System.out.println(answer);

    }
}
