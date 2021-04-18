package beakjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B8983 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        long l = sc.nextInt();
        int[] shooter = new int[n];
        for(int i=0; i<n; i++){
            shooter[i] = sc.nextInt();
        }
        long[][] monster = new long[m][2];
        for(int i=0; i<m; i++){
            long a = sc.nextLong();
            long b = sc.nextLong();
            if(l >= b){
                monster[i][0] = a;
                monster[i][1] = b;
            }
        }
        Arrays.sort(shooter);
        Arrays.sort(monster, new Comparator<long[]>() {
            @Override
            public int compare(long[] longs, long[] t1) {
                return (int)(t1[1] - longs[1]);
            }
        });

        int answer = 0;
        for(long[] i : monster){
            if(i[0] == 0) break;
            long tmp = l-i[1];
            if(chk(shooter, tmp, i[0])) answer++;
        }
        System.out.println(answer);
    }
    static boolean chk(int[] shooter, long tmp, long a){
        int start = 0, end = shooter.length;
        while (start<=end){
            int mid = (start+end)/2;
            if(Math.abs(shooter[mid]-a) <= tmp) return true;
            if(shooter[mid]-a < 0){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return false;
    }
}
