package kakao;

import java.util.LinkedList;

public class K20_6 {
    static boolean chk;
    static LinkedList<Integer> list;
    static int[][] nWeak;
    public static void main(String[] args) {
        int n = 12;
        int[] weak = {1, 5, 6, 10};
        int[] dist = {1, 2, 3, 4};
        int answer = -1;
        chk = false;
        nWeak = new int[weak.length][weak.length];
        for(int i=0; i<weak.length; i++){
            for(int j=0; j<weak.length; j++){
                if(j+i >= weak.length){
                    nWeak[i][j] = weak[j+i-weak.length] + n ;
                }else{
                    nWeak[i][j] = weak[i+j];
                }
            }
        }
        for(int i=1; i<=dist.length; i++){
            per(dist, dist.length, i, 0, new boolean[dist.length], new int[i]);
            if(chk){
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
    static void per(int[] dList, int n, int r, int depth, boolean[] visited, int[] output){
        if(chk) return;
        if(r==depth){
            chk = isChk(nWeak, output, r);
            return;
        }
        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = dList[i];
                per(dList, n, r, depth+1, visited, output);
                visited[i] = false;
            }

        }
    }
    static boolean isChk(int[][] weak, int[] dist, int num){
        boolean check = false;
        for(int[] w : weak){
            int start =0;
            int idx =0;
            boolean[] vi = new boolean[w.length];
            while (idx != num){
                int i = start;
                int value = dist[idx++];
                for(int j=start; j<w.length; j++){
                    if(!(w[j]-w[i] <= value))break;
                    vi[j] = true;
                    start++;
                }
            }
            if(isVisited(vi)){
                check = true;
                break;
            }
        }
        return check;
    }
    static boolean isVisited(boolean[] visited){
        for(boolean b : visited){
            if(!b) return false;
        }
        return true;
    }

}
