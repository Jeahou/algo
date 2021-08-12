package beakjoon;

import java.util.Scanner;

public class B2586 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] pump = new int[n];
        int[] fireCar = new int[m];
        for(int i=0; i<n; i++){
            pump[i]= sc.nextInt();
        }
        for(int i=0; i<m; i++){
            fireCar[i] = sc.nextInt();
        }
        int answer = 0;
        for(int i=0; i<m; i++){
            int start = 0, end = pump.length-1;
            boolean chk = false;
            while (start<=end){
                int mid = (start+end)/2;
                if (pump[mid] - fireCar[i] > 0) {
                    end = mid-1;
                }else if(pump[mid] - fireCar[i] < 0){
                    start = mid+1;
                }else{
                    chk = true;
                    break;
                }
            }
            if(chk) continue;
            if(start == end) answer += Math.abs(pump[start] - fireCar[i]);
            if(start != end) {
                if(end < 0){
                    answer += Math.abs(pump[start] - fireCar[i]);
                }else if(start > pump.length-1){
                    answer += Math.abs(pump[end] - fireCar[i]);
                }else{
                    answer += Math.min(Math.abs(pump[start] - fireCar[i]), Math.abs(pump[end] - fireCar[i]));
                }
            }
        }
        System.out.println(answer);
    }

}
