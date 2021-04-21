package beakjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class B2632 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] fList = new int[m*2-1];
        int[] sList = new int[n*2-1];
        for(int i=0; i<m; i++){
            fList[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){
            sList[i] = sc.nextInt();
        }
        int idx = 0;
        for(int i=m; i<fList.length; i++){
            fList[i] = fList[idx++];
        }
        idx = 0;
        for(int i=n; i<sList.length; i++){
            sList[i] = sList[idx++];
        }
        ArrayList<Integer> f = new ArrayList<>();
        ArrayList<Integer> s = new ArrayList<>();
        int count = 0;
        int sum = 0;
        int total = 0;
        for(int i=0; i<m; i++){
            sum = fList[i];
            total += sum;
            f.add(sum);
            idx = i+1;
            while (count < m-2){
                   sum += fList[idx];
                   idx++;
                   f.add(sum);
                   count++;
            }
            count = 0;
        }
        f.add(total);
        f.add(0);
        sum = 0;
        total = 0;
        for(int i=0; i<n; i++){
            sum = sList[i];
            total += sum;
            s.add(sum);
            idx = i+1;
            while (count < n-2){
                sum += sList[idx];
                idx++;
                s.add(sum);
                count++;
            }
            count=0;
        }
        s.add(total);
        s.add(0);
        Collections.sort(f);
        Collections.sort(s);
        int answer = 0;
        int left = 0;
        int rigth = s.size()-1;
        while (left < f.size() && rigth >=0){
            int lv = f.get(left);
            int rv = s.get(rigth);
            if(rv + lv == g){
               int lc = 0;
               int rc = 0;
                while (left < f.size() && f.get(left) == lv){
                    lc++;
                    left++;
                }
                while (rigth>=0 && s.get(rigth) == rv){
                    rc++;
                    rigth--;
                }
                answer+= lc*rc;
            }
            if(rv+lv > g) rigth--;
            if(rv+lv < g) left++;
        }
        System.out.println(answer);
    }
}
