package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11505 {
    static int[] Tree;
    static int[] map;
    static int mod = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int k = Integer.parseInt(tmp[2]);
        int x = (int) Math.ceil(Math.log(n)/Math.log(2))+1;
        Tree = new int[(int) Math.pow(2, x)];
        map = new int[n];
        for(int i=0; i<n; i++){
            map[i] = Integer.parseInt(br.readLine());
        }
        initTree(0, n-1, 1);
        for(int i=0; i<m+k; i++){
            tmp = br.readLine().split(" ");
            if(Integer.parseInt(tmp[0]) == 1){
                int changeIdx = Integer.parseInt(tmp[1]);
                int t = Integer.parseInt(tmp[2]);
                map[changeIdx-1] = t;
                initTree(0, n-1, 1);
            }else{
                int start = Integer.parseInt(tmp[1])-1;
                int end = Integer.parseInt(tmp[2])-1;
                System.out.println(query(0, n-1, start, end, 1));
            }
        }
    }
    static int initTree(int start, int end, int deep){
        int mid = (start+end)/2;
        if(start == end){
            return Tree[deep] = map[start];
        }
        return Tree[deep] = initTree(start, mid, deep*2) * initTree(mid+1, end, deep*2+1)%mod;
    }
    static int query(int start, int end, int left, int right, int deep){
        if(right < start || left > end){
            return 1;
        }

        if(left <= start && end <= right){
            return Tree[deep];
        }else{
            int mid = (start + end)/2;
            return query(start, mid, left, right, deep*2) * query(mid+1, end, left, right, deep*2+1)%mod;
        }
    }
}
