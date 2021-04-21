package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1992 {
    static int[][] map;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i=0; i<n; i++){
            String[] tmp = br.readLine().split("");
            for(int j=0; j<tmp.length; j++){
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        sb = new StringBuilder();
        quadTree(n, 0, 0);
        System.out.println(sb.toString());
    }
    static void quadTree(int n, int x, int y){
        if(n==1){
            sb.append(map[y][x]);
            return;
        }
        boolean zero=true, one = true;
        for(int i=y; i<y+n; i++){
            for(int j=x; j<x+n; j++){
                if(map[i][j] == 1){
                    zero = false;
                }else{
                    one = false;
                }
            }
        }
        if(one){
            //1
            sb.append("1");
        }else if(zero){
            //0
            sb.append("0");
        }else{
            sb.append("(");
            quadTree(n/2, x, y);
            quadTree(n/2, x+n/2, y);
            quadTree(n/2, x, y+n/2);
            quadTree(n/2, x+n/2, y+n/2);
            sb.append(")");
        }
    }
}
//((110(0101))(0010)1(0001))