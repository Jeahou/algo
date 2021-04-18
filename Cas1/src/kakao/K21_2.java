package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class K21_2 {
    public static void main(String[] args) {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2,3,4};
        String[] c_orders = new String[orders.length];
        for(int i=0; i<orders.length; i++) {
            String[] stmp = orders[i].split("");
            Arrays.sort(stmp);
            String ss = "";
            for (String s : stmp) {
                ss += s;
            }
            c_orders[i] = ss;
        }
        System.out.println(Arrays.toString(c_orders));
        HashMap<String , Integer> hashMap = new HashMap<>();
        ArrayList<String> answerList = new ArrayList<>();
        for(int j=0; j<course.length; j++){
            for(int i=0; i<orders.length; i++){
                dfs(c_orders[i], new StringBuffer(), 0, course[j], hashMap);
            }
            int answer = 2;
            for(String key : hashMap.keySet()){
                if(answer <= hashMap.get(key)){
                    answer = hashMap.get(key);
                }
            }
            for(String key : hashMap.keySet()){
                if(hashMap.get(key) == answer) answerList.add(key);
            }
            hashMap.clear();
        }
        Collections.sort(answerList);
        System.out.println(answerList);
    }
    static void dfs(String s, StringBuffer k, int depth , int course, HashMap<String , Integer> hashMap){
        if(depth == course){
            if(hashMap.containsKey(k.toString())){
                hashMap.put(k.toString(), hashMap.get(k.toString())+1);
            }else{
                hashMap.put(k.toString(), 1);
            }
        }else{
            if(depth == 0){
                for(int i=0; i<s.length(); i++){
                    k.append(s.charAt(i));
                    dfs(s, k, depth+1, course, hashMap);
                    k.delete(0, 1);
                }
            }else{
                for(int i=s.indexOf(k.substring(k.length()-1, k.length()))+1; i<s.length(); i++){
                    k.append(s.charAt(i));
                    dfs(s, k, depth+1, course, hashMap);
                    k.delete(k.length()-1,k.length());
                }
            }
        }

    }
}
