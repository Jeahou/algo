package kakao;

import java.util.HashMap;

public class Test2 {
    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        int[] answer = new int[enroll.length];
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, Integer> amountList = new HashMap<>();
        for(int i=0; i<enroll.length; i++){
            map.put(enroll[i], referral[i]);
        }
        for(int i=0; i<seller.length; i++){
            int total = amount[i]*100;
            int up = total/10;
            int my = total - up;
            String s = seller[i];
            if(s.equals("mary")) System.out.println(up);
            if(!amountList.containsKey(s)){
                amountList.put(s, my);
            }else{
                amountList.put(s,amountList.get(s) + my);
            }
            while (!map.get(s).equals("-")){
                s = map.get(s);
                total = up;
                up = total/10;
                my = total - up;
                if(!amountList.containsKey(s)){
                    amountList.put(s, my);
                }else{
                    amountList.put(s,amountList.get(s) + my);
                }
            }
        }
        int idx=0;
        for(String s : enroll){
            if(!amountList.containsKey(s)){
                answer[idx++] = 0;
            }else{
                answer[idx++] = amountList.get(s);
            }
        }
    }
}
