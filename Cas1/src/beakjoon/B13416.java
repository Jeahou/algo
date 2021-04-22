package beakjoon;

import java.util.Scanner;

public class B13416 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tt=0; tt<T; tt++){
            int n = sc.nextInt();
            int answer = 0;
            for(int i=0; i<n; i++){
                int tmp = 0;
                for(int j=0; j<3; j++){
                    int t = sc.nextInt();
                    if(t>=0){
                       tmp = t > tmp ? t : tmp;
                    }
                }
                answer += tmp;
            }
            System.out.println(answer);
        }
    }
}
