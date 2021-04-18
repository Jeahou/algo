package samsung.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class S11545 {
    public static void main(String[] args) throws IOException {
        char[][] map = new char[4][4];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean chk = false;
        for(int i=0; i<4; i++){
            String tmp = br.readLine();
            for(int j=0; j<4; j++){
                map[i][j] = tmp.charAt(j);
                if(tmp.charAt(i) == '.') chk = true;
            }
        }

        if(chk){
            String s = Cal(map);
            if(s.equals("")){
                System.out.println("Game has not completed");
            }else{
                System.out.println(s);
            }
        }else{
            String s = Cal(map);
            if(s.equals("")){
                System.out.println("Draw");
            }else{
                System.out.println(s);
            }
        }
    }
    static String Cal(char[][] map){
        char tmp = 'a';
        for(char[] s : map){
            System.out.println(Arrays.toString(s));
        }
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(j==0) {
                    tmp = map[i][j];
                }else{
                    if(tmp == 'T') tmp = map[i][j];
                    if(tmp == map[i][j] || map[i][j] == 'T'){
                        if(j==3) {
                            if(tmp == 'X'){
                                System.out.println(1);
                                return "X won";
                            }else if(tmp == 'O') {
                                return "O won";
                            }
                        }
                    }else{
                        break;
                    }
                }
            }
        }
        for(int j=0; j<4; j++){
            for(int i=0; i<4; i++){
                if(i==0) {
                    tmp = map[i][j];
                }else{
                    if(tmp == 'T') tmp = map[i][j];
                    if(tmp == map[i][j] || map[i][j]== 'T'){
                        if(i==3) {
                            if(tmp == 'X'){
                                System.out.println(2);
                                return "X won";
                            }else if(tmp == 'O') {
                                return "O won";
                            }
                        }
                    }else{
                        break;
                    }
                }
            }
        }

        int x = 0;
        int y = 0;
        tmp = map[x][y];
        for(int i=0; i<3; i++) {
            char next = map[++x][++y];
            if(tmp == 'T') tmp = next;
            if (next == tmp || next == 'T') {
                if (i == 2) {
                    if (tmp == 'X') {
                        System.out.println(3);
                        return "X won";
                    } else if (tmp == 'O') {
                        return "O won";
                    }
                }
            } else {
                break;
            }
        }

        x = 0;
        y = 3;
        tmp = map[x][y];
        for(int i=0; i<3; i++){
            char next = map[++x][--y];
            if(tmp == 'T') tmp = next;
            if(next == tmp || next == 'T'){
                if(i==2){
                    if (tmp == 'X') {
                        return "X won";
                    } else if (tmp == 'O') {
                        return "O won";
                    }
                }
            }else{
                break;
            }
        }

        return "";
    }

}
