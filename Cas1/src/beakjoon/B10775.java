package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
/*
예제 4 6 2 2 3 3 4 4
게이트 4개
해쉬맵으로 형성
1 2 3 4
1 2 3 4

비행기가 들어와서 자기 value 값이 같으면 value -1 하고 넘어가고
value가 다르면 그 value에 따른 key값을 따라 다시 value 확인 위에거 반복
만약 따라갓는데 0이 나오면 끝 anwer 출력
 */
public class B10775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> gateList = new HashMap<Integer, Integer>();
        for(int i=1; i<=m; i++){
            gateList.put(i,i);
        }
        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            int p = Integer.parseInt(br.readLine());
            if(gateList.get(p) == 0) break;
            if(gateList.get(p) == p) {
                gateList.replace(p, gateList.get(p)-1);
                answer++;
            }else{
                int t = gateList.get(p);
                while (gateList.get(t) != t){
                    if(gateList.get(t)==0) break;
                    int tmp = t;
                    t = gateList.get(t);
                    gateList.replace(tmp, gateList.get(tmp)-1);
                }
                if(gateList.get(t) == 0){
                    break;
                }else{
                    answer++;
                    gateList.replace(t, gateList.get(t)-1);
                }
            }
            //System.out.println(gateList);

        }
        System.out.println(answer);
    }
}
