package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class K21_3_2 {
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"- and - and - and - 50","java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        int[] answer = new int[query.length];
        String[] info_1 = {"cpp","java","python"};
        String[] info_2 = {"backend","frontend"};
        String[] info_3 = {"junior","senior"};
        String[] info_4 = {"chicken","pizza"};
        StringBuffer sb = new StringBuffer();
        int score = 0;
        for(String s1 : info_1){
            for(String s2 : info_2){
                for(String s3 : info_3){
                    for(String s4 : info_4){
                        sb.append(s1).append(s2).append(s3).append(s4);
                        map.put(sb.toString(), new ArrayList<Integer>());
                        sb.delete(0, sb.length());
                    }
                }
            }
        }
        for(int i=0; i<info.length; i++){
            String[] tmp = info[i].split(" ");
            sb.append(tmp[0]).append(tmp[1]).append(tmp[2]).append(tmp[3]);
            ArrayList<Integer> arr = map.get(sb.toString());
            arr.add(Integer.parseInt(tmp[4]));
            Collections.sort(arr);
            sb.delete(0, sb.length());
        }
       // System.out.println(map);
        for(int i=0; i<query.length; i++){
            String[] tmp = query[i].split(" ");
            //System.out.println(Arrays.toString(tmp));
            String[] a, b, c, d;
            if(tmp[0].equals("-")){
                a = info_1;
            }else {
                a = new String[] {tmp[0]};
            }
            if(tmp[2].equals("-")){
                b = info_2;
            }else {
                b = new String[] {tmp[2]};
            }
            if(tmp[4].equals("-")){
                c = info_3;
            }else {
                c = new String[] {tmp[4]};
            }
            if(tmp[6].equals("-")){
                d = info_4;
            }else {
                d = new String[] {tmp[6]};
            }
            for(String s1 : a) {
                for (String s2 : b) {
                    for (String s3 : c) {
                        for (String s4 : d) {
                            sb.append(s1).append(s2).append(s3).append(s4);

                            int start = 0;
                            int end = map.get(sb.toString()).size();
                            while (start < end) {
                                int mid = (start + end) / 2;
                                if (map.get(sb.toString()).get(mid) >= Integer.parseInt(tmp[7])) {
                                    end = mid;
                                } else {
                                    start = mid + 1;
                                }
                            }
                            answer[i] += map.get(sb.toString()).size() - end;
                            sb.delete(0, sb.length());
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.toString(answer));
    }
}
