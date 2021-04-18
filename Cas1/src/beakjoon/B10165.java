package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B10165 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] list = new int [m*2][3];
        int idx =0;
        ArrayList<Integer> answer =  new ArrayList<>();
        for(int i=1; i<=m; i++){
            String s = br.readLine();
            String[] str = s.split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            if(a>b && b==0) b=n;
            if(a>b){
                list[idx][0] = a-n;
                list[idx][1] = b;
                list[idx][2] = i;
                idx++;
                list[idx][0] = a;
                list[idx][1] = b+n;
                list[idx][2] = i;
                idx++;
            }else{
                list[idx][0] = a;
                list[idx][1] = b;
                list[idx][2] = i;
                idx++;
                list[idx][0] = a+n;
                list[idx][1] = b+n;
                list[idx][2] = i;
                idx++;
            }
        }
        Arrays.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o2[1] - o1[1];
                }else{
                    return o1[0] - o2[0];
                }
            }
        });
        int listIdx = 0;
        for(int i=1; i<list.length; i++){
            if(!(list[listIdx][0] <= list[i][0] && list[listIdx][1] >= list[i][1])){
                listIdx=i;
                if(!answer.contains(list[i][2])) answer.add(list[i][2]);
            }
        }
        Collections.sort(answer);
        for(int i=0; i<answer.size(); i++){
            System.out.print(answer.get(i));
            if(i != answer.size()-1) System.out.print(" ");
        }
    }
}
