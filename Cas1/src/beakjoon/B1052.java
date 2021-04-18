package beakjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class B1052 {
    // 5 - 1 2 - 1 1 1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        int answer = 0;
        int s = n;
        int c = 0;
        if(n<k){
            answer = -1;
        }else{
            int tmp = 0;
            while (true){
                c = s%2;
                s = s/2;
                if(s==0) break;
                tmp += c+s;
                if(tmp > k){
                    list.add(c);
                    tmp -= s;
                }else{
                    answer = -1;
                    break;
                }
            }
            list.add(1);
        }
        if(answer != -1){
            int max = 0;
            int tmp = 0;
            for(int i = list.size()-1; i>=0; i--){
                if(tmp < k){
                    if(list.get(i) != 0) tmp += 1;
                }else{
                    max = (int) Math.pow(2, i+1);
                    for(int j=0; j<=i; j++){
                        if(list.get(j) == 1){
                            answer += Math.pow(2, j);
                        }
                    }
                    answer = max - answer;
                    break;
                }
            }
        }
        if(answer == -1){
            System.out.println(0);
        }else{
            System.out.println(answer);
        }
    }
}
