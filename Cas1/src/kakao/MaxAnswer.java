package kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class MaxAnswer {
    static ArrayList<Character> mList;
    static String[] sList;
    static long answer = 0;
    public static void main(String[] args) {
        String expression = "50*6-3*2";
        mList = new ArrayList<Character>();
        if(expression.contains("-")){
            mList.add('-');
        }
        if(expression.contains("*")){
            mList.add('*');
        }
        if(expression.contains("+")){
            mList.add('+');
        }
        sList = new String[mList.size()];
        for(int i=0; i<mList.size(); i++){
            sList[i] = String.valueOf(mList.get(i));
        }
        dfs(0, expression);
        System.out.println(answer);
    }
    static void dfs(int depth, String exp){
        if(depth == sList.length){
            long t = cal(exp, sList);
            answer = t > answer ? t : answer;
        }
        for(int i=depth; i<sList.length; i++){
            swap(i, depth, sList);
            dfs(depth+1, exp);
            swap(i, depth, sList);
        }
    }
    static void swap(int i, int j, String[] sList){
        String s =sList[i];
        sList[i] = sList[j];
        sList[j] = s;
    }
    static long cal(String exp, String[] mList){
        HashMap<String, Integer> hList = new HashMap<>();
        for(int i=0; i<mList.length; i++){
            hList.put(mList[i], i);
        }
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<String>();
        ArrayList<String> list = new ArrayList<String>();

        for(int i=0; i<exp.length(); i++){
            char c = exp.charAt(i);
            if(c == '-' || c == '+' || c == '*'){
                list.add(sb.toString());
                sb.delete(0, sb.length());
                while (!stack.isEmpty() && hList.get(c+"") >= hList.get(stack.peek())) {
                    list.add(stack.pop());
                }
                stack.add(String.valueOf(c));
            }else{
                sb.append(c);
            }
        }
        list.add(sb.toString());
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        for(String s : list){
            if(s.equals("+")){
                long a = Long.parseLong(stack.pop());;
                long b = Long.parseLong(stack.pop());;
                a = a + b;
                stack.add(Long.toString(a));

            }else if(s.equals("-")){
                long a = Long.parseLong(stack.pop());;
                long b = Long.parseLong(stack.pop());;
                a = b-a;
                stack.add(Long.toString(a));
            }else if(s.equals("*")){
                long a = Long.parseLong(stack.pop());
                long b = Long.parseLong(stack.pop());
                a = a * b;
                stack.add(Long.toString(a));
            }else{
                stack.add(s);
            }
        }
        return Math.abs(Long.parseLong(stack.pop()));
    }
}
