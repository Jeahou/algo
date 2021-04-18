package beakjoon;

import java.util.Scanner;

public class B15729 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int n = sc.nextInt();
        int[] map = new int[n];
        for(int i=0; i<n; i++){
            map[i] = sc.nextInt();
        }
        int[] tmp = new int[n];
        for(int i=0; i<n; i++){
            if(map[i] != tmp[i]){
                answer += 1;
                for(int j=0; j<3; j++){
                    if(tmp[i+j] == 0){
                        tmp[i+j] = 1;
                    }else{
                        tmp[i+j] = 0;
                    }
                    if(i== n-1) j = 3;
                    if(i== n-2 && j == 1) j =3;
                }
            }
        }
        System.out.println(answer);
    }
}
