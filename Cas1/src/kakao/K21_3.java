package kakao;

import java.util.Arrays;
import java.util.Comparator;

public class K21_3 {
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        int[] answer = new int[query.length];
        Arrays.sort(info, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] tmp1 = o1.split(" ");
                String[] tmp2 = o2.split(" ");
                return Integer.parseInt(tmp1[4]) - Integer.parseInt(tmp2[4]);
            }
        });
        for(int i=0; i<query.length; i++){
            String[] qList = query[i].split(" and | ");
            int target = Integer.parseInt(qList[4]);
            int start = 0;
            int end = info.length;
            int mid = 0;
            while (start < end){
                mid = (start + end) /2;
                if(Integer.parseInt(info[mid].split(" ")[4]) >= target){
                    end  = mid;
                }else {
                    start = mid+1;
                }
            }
            String[] n_Info = Arrays.copyOfRange(info, end, info.length);
            Arrays.sort(n_Info, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    String[] tmp1 = o1.split(" ");
                    String[] tmp2 = o2.split(" ");
                    return tmp1[0].compareTo(tmp2[0]);
                }
            });
            //System.out.println(Arrays.toString(n_Info));
            if(n_Info.length == 0) {
                answer[i] = 0;
                continue;
            }
            // 0
            if(!qList[0].equals("-")){
                int[] n = binaryS(n_Info.length, n_Info, qList, 0);
                n_Info = Arrays.copyOfRange(n_Info, n[0], n[1]);
            }
            if(n_Info.length == 0) {
                answer[i] = 0;
                continue;
            }
            Arrays.sort(n_Info, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    String[] tmp1 = o1.split(" ");
                    String[] tmp2 = o2.split(" ");
                    return tmp1[1].compareTo(tmp2[1]);
                }
            });
            //1
            if(!qList[1].equals("-")){
                int[] n = binaryS(n_Info.length, n_Info, qList, 1);
                n_Info = Arrays.copyOfRange(n_Info, n[0], n[1]);
            }
            //2
            if(n_Info.length == 0) {
                answer[i] = 0;
                continue;
            }
            Arrays.sort(n_Info, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    String[] tmp1 = o1.split(" ");
                    String[] tmp2 = o2.split(" ");
                    return tmp1[2].compareTo(tmp2[2]);
                }
            });
            if(!qList[2].equals("-")){
                int[] n = binaryS(n_Info.length, n_Info, qList, 2);
                n_Info = Arrays.copyOfRange(n_Info, n[0], n[1]);
            }
            if(n_Info.length == 0) {
                answer[i] = 0;
                continue;
            }
            Arrays.sort(n_Info, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    String[] tmp1 = o1.split(" ");
                    String[] tmp2 = o2.split(" ");
                    return tmp1[3].compareTo(tmp2[3]);
                }
            });
            //3
            if(!qList[3].equals("-")){
                int[] n = binaryS(n_Info.length, n_Info, qList, 3);
                n_Info = Arrays.copyOfRange(n_Info, n[0], n[1]);
            }
            answer[i] = n_Info.length;
        }
        System.out.println(Arrays.toString(answer));
    }
    static int[] binaryS(int listLength, String[] n_Info, String[] qList, int depth){
        int start = 0;
        int end = listLength;
        int mid = 0;
        while (start < end){
            mid = (start + end) /2;
            if(n_Info[mid].split(" ")[depth].compareTo(qList[depth]) >= 0){
                end  = mid;
            }else {
                start = mid+1;
            }
        }
        int f =end;
        start = 0;
        end = listLength;
        mid = 0;
        while (start < end){
            mid = (start + end) /2;
            if(n_Info[mid].split(" ")[depth].compareTo(qList[depth]) <= 0){
                start  = mid+1;
            }else {
                end = mid;
            }
        }
        int l = end;
        return new int[] {f, l};
    }

}
