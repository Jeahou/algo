package beakjoon;

import java.util.Arrays;
import java.util.Scanner;

public class B6549 {
    static int[] segTree;
    static long answer;
    static int[] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int n = sc.nextInt();
            if(n==0) break;
            int size = (int) Math.ceil(Math.log(n)/Math.log(2));
            map = new int[n+1];
            for(int i=1; i<=n; i++){
                map[i] = sc.nextInt();
            }
            segTree = new int[(int) Math.pow(2, size+1)];
            initTree(1, n, 1);
            answer = 0;
            getMax(1, n, 1,1, n);
            System.out.println(answer);
        }
    }
    static void getMax(int start , int end, int idx, int left, int rigth){
        int m = query(start, end, idx, left, rigth);
        int b = rigth-left+1;
        answer = answer < (long) map[m]*b ? (long) map[m]*b : answer;
        if(left <= m-1){
            getMax(start, end, idx, left, m-1);
        }
        if(m+1 <= rigth){
            getMax(start, end, idx, m+1, rigth);
        }
    }
    static void initTree(int start, int end, int idx){
        if(start == end){
            segTree[idx] = start;
        }else{
            int mid = (start+end)/2;
            initTree(start, mid, idx*2);
            initTree(mid+1, end, idx*2+1);

            if(map[segTree[idx*2]] > map[segTree[idx*2+1]]){
                segTree[idx] = segTree[idx*2+1];
            }else{
                segTree[idx] = segTree[idx*2];
            }
        }
    }
    static int query(int start, int end, int idx, int left, int right){
        if(right < start || left > end){
            return Integer.MAX_VALUE;
        }
        if(left<=start && end <=right){
            return segTree[idx];
        }
        int mid = (start+end)/2;
        int l = query(start, mid, idx*2, left, right);
        int r = query(mid+1, end, idx*2+1, left, right);

        if(l==Integer.MAX_VALUE){
            return r;
        }else if(r == Integer.MAX_VALUE){
            return l;
        }else{
            return map[l] < map[r] ? l : r;
        }
    }
}
