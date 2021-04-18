package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B17828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        if(n > m || n*26 < m){
            System.out.println("!");
        }else{
            System.out.println(Cal(n, m));
        }
    }
    static String Cal(int n, int m){
        int[] map = new int[n];
        int sh = m/n;
        int ga = m%n;
        for(int i=0; i<n; i++){
            map[i] = sh;
        }
        for(int i=n-1; i>=0; i--){
            if(ga == 0) break;
            map[i] += ga;
            if(map[i] >= 26){
                ga = map[i] - 26;
                map[i] = 26;
            }else{
                ga = 0;
            }
        }
        System.out.println(Arrays.toString(map));
        int t = 0;
        int idx = n-1;
        for(int i=0; i<n; i++){
            if(i>idx) break;
            int tmp = map[i]-1;
            map[i] = 1;
            t = tmp;
            while (map[idx] <= 26){
                if(t == 0) break;
                map[idx] += t;
                if(map[idx] >= 26){
                    t = map[idx] - 26;
                    map[idx] = 26;
                    idx--;
                }else{
                    t = 0;
                }
                if(idx < 0) break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            char c = (char) (map[i] + 64);
            sb.append(c);
        }
        return sb.toString();
    }
}
