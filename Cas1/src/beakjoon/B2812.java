package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        String ss = br.readLine();
        String[] sTmp = ss.split("");
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        int idx = 0;
        for(int i=0; i<n; i++) {
            if (stack.isEmpty()) {
                stack.add(sTmp[i]);
            } else {
                while (!stack.isEmpty()) {
                    if (Integer.parseInt(stack.peek()) < Integer.parseInt(sTmp[i]) && idx < k) {
                        stack.pop();
                        idx++;
                    } else {
                        stack.add(sTmp[i]);
                        break;
                    }
                }
                if (stack.isEmpty()) {
                    stack.add(sTmp[i]);
                }
            }
        }
        while (idx < k){
            stack.pop();
            idx++;
        }
        while (!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }
        System.out.println(sb.toString());
    }
}
