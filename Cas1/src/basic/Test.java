package basic;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test {
    static ArrayList<String> list;
    public static void main(String[] args) {
        StringBuilder sSb = new StringBuilder();
        StringBuilder eSb = new StringBuilder();
        list = new ArrayList<>();

        String ss = "aacacaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        System.out.println(ss.length());
        St(ss,0, ss.length()-1, 0);
        System.out.println(list);
        int i = 0;
        System.out.println(Math.pow(2, i));
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> aa = new ArrayList<>();
    }
    public static void St(String str, int start, int end, int idx){
        boolean chk = true;
        StringBuilder sSb = new StringBuilder();
        StringBuilder eSb = new StringBuilder();
        int cnt = 0;
        while (start < str.length()/2){
            sSb.append(str.charAt(start++));
            eSb.insert(0, str.charAt(end--));
            if(sSb.compareTo(eSb)==0){
                System.out.println(sSb.toString());
                list.add(idx, eSb.toString());
                list.add(idx, sSb.toString());
                St(str, start, end, idx+1);
                chk = false;
                break;
            }
        }
        if(chk && sSb.length() != 0){
            if(end == start) sSb.append(str.charAt(start));
            sSb.append(eSb);
            list.add(idx, sSb.toString());
        }
    }
}
