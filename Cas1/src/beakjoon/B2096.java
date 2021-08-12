package beakjoon;

import java.util.Scanner;

public class B2096 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] maxdp = new int[3];
        int[] mindp = new int[3];
        for(int i=0; i<3; i++){
            int tmp = sc.nextInt();
            maxdp[i] = tmp; mindp[i] = tmp;
        }
        for(int i=1; i<n; i++){
            int[] maxTmp = new int[3];
            int[] minTmp = new int[3];
            for(int j=0; j<3; j++){
                int tmp = sc.nextInt();
                maxTmp[j] = tmp;
                minTmp[j] = tmp;
                if(j==0){
                    maxTmp[j] = (maxTmp[j] + Math.max(maxdp[j], maxdp[j+1]));
                    minTmp[j] = (minTmp[j] + Math.min(mindp[j], mindp[j+1]));
                }else if(j == 1){
                    int max = Math.max(maxdp[j], maxdp[j+1]);
                    max = Math.max(max, maxdp[j-1]);
                    int min = Math.min(mindp[j], mindp[j+1]);
                    min = Math.min(min, mindp[j-1]);
                    maxTmp[j] += max;
                    minTmp[j] += min;
                }else{
                    maxTmp[j] = (maxTmp[j] + Math.max(maxdp[j], maxdp[j-1]));
                    minTmp[j] = (minTmp[j] + Math.min(mindp[j], mindp[j-1]));
                }
            }
            for(int j=0; j<3; j++){
                maxdp[j] = maxTmp[j];
                mindp[j] = minTmp[j];
            }
        }
        int maxAnswer = Integer.MIN_VALUE;
        int minAnswer = Integer.MAX_VALUE;
        for(int i=0; i<3; i++){
            if(maxAnswer < maxdp[i]) maxAnswer = maxdp[i];
            if(minAnswer > mindp[i]) minAnswer = mindp[i];
        }
        System.out.println(maxAnswer + " " + minAnswer);

    }
}
