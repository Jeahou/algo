package samsung.d4;

import java.util.Scanner;

public class S11592 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float D = sc.nextFloat();
        int n = sc.nextInt();
        float time = 0;
        for(int i=0; i<n; i++){
            float tmpD = sc.nextFloat();
            float s = sc.nextFloat();
            tmpD = D - tmpD;
            if(time < tmpD/s) time = tmpD/s;
        }
        System.out.println(D/time);
        System.out.println((float)2/3);
    }
}
