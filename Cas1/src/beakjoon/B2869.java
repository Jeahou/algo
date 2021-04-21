package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        long A = Long.parseLong(tmp[0]);
        long B = Long.parseLong(tmp[1]);
        long V = Long.parseLong(tmp[2]);
        long answer = 0;
        answer += (V-B)/(A-B);
        if((V-B)%(A-B) != 0) answer += 1;
        System.out.println(answer);
    }
}
