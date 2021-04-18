package kakao;

import java.util.Arrays;

public class K21_4 {
    public static void main(String[] args) {
        int n = 7;
        int s = 3;
        int a = 4;
        int b = 1;
        int[][] fares ={{5, 7, 9}, {4, 6, 4},{3, 6, 1}, {3, 2, 3}, {2, 1, 6}};                                                                 ;
        int[][] map = new int[n][n];
        for(int i=0; i<fares.length; i++){
            int f1 = fares[i][0]-1;
            int f2 = fares[i][1]-1;
            int distance = fares[i][2];
            map[f1][f2] = distance;
            map[f2][f1] = distance;
        }
        for(int[] i : map){
            System.out.println(Arrays.toString(i));
        }

        int[] st = dijk(s-1, map);
        int answer = st[a-1] + st[b-1];
        for(int i=0; i<n; i++){
            if(i == s-1) continue;
            int[] second = dijk(i, map);
            int fir = st[i];
            int aPrice = second[a-1];
            int bPrice = second[b-1];
            answer = answer > (fir + aPrice + bPrice) ? (fir + aPrice + bPrice) : answer;
        }
        System.out.println(answer);
    }
    static int[] dijk(int start, int[][] map){
        int[] list = new int[map.length];
        boolean[] check = new boolean[map.length];
        for(int i=0; i<list.length; i++){
            list[i] = Integer.MAX_VALUE;
        }
        list[start] = 0;
        check[start] = true;
        for(int i=0; i<list.length; i++){
            if(map[start][i]!=0) list[i] = map[start][i];
        }
        for(int i=0; i<list.length-1; i++){
            int idx=-1;
            int distance = Integer.MAX_VALUE;
            for(int j=0; j<list.length; j++){
                if(!check[j] && list[j] < distance){
                    distance = list[j];
                    idx = j;
                }
            }
            System.out.println(idx);
            if(idx == -1 ) break;
            check[idx] = true;
            for(int j=0; j<list.length; j++){
                if(!check[j] && map[idx][j] !=0){
                    if(list[j] > distance + map[idx][j]){
                        list[j] = distance + map[idx][j];
                    }
                }
            }
        }
        return list;
    }
}
