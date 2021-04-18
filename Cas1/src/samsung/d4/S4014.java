package samsung.d4;

import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class S4014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[][] map = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
            }
        }
        System.out.println(totalCal(map, x));
        int[] tt = {4, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5, 5, 4, 4, 4};
        System.out.println(Cal(tt, 3));
    }
    static boolean Cal(int[] map, int n){
        Stack<Integer> stack = new Stack<>();
        boolean chk = false;
        boolean state = true;
        for(int i=0; i<map.length; i++) {
            if(stack.isEmpty()) {
                stack.add(map[i]);
            }else{
                if(stack.peek() == map[i]) {
                    stack.add(map[i]);
                }else if(stack.peek() > map[i] ){
                    if(stack.peek() - map[i] > 1) return false;
                    if(!state){
                        if(stack.size() < n) return false;
                    }
                    stack.clear();
                    stack.add(map[i]);
                    state = false;
                }else if (stack.peek() < map[i]){
                    if(map[i] - stack.peek() > 1) return false;
                    if(!state){
                        if(stack.size() < 2*n) return false;
                    }else{
                        if(stack.size() < n) return false;
                    }
                    stack.clear();
                    stack.add(map[i]);
                    state = true;
                }
            }
        }
        if(!state){
            if(stack.size() >= n) chk = true;
        }else{
            chk = true;
        }
        return chk;
    }
    static int totalCal(int[][] map, int x){
        int answer = 0;
        int[] tmp = new int[map.length];
        for(int i=0; i<map.length; i++){
            if(Cal(map[i], x)) {
                answer += 1;
                System.out.println(Arrays.toString(map[i]));
                System.out.println(" "+i);
            }
        }
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map.length; j++){
                tmp[j] = map[j][i];
            }
            if(Cal(tmp, x)) {
                answer +=1;
                System.out.println(Arrays.toString(tmp));
                System.out.println(" ");
            }
        }
        return answer;
    }
}
