package kakao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SearchSong {
    public static void main(String[] args) {
        String[] words = {"a", "frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"??","fro??", "????o", "fr???", "fro???", "pro?"};
        //10001
        TestTrie[] listTrie = new TestTrie[10001];
        TestTrie[] reverseListTrie = new TestTrie[10001];
        for(int i=0; i<words.length; i++){
            System.out.println(2);
            int len = words[i].length();
            if(listTrie[len] == null) listTrie[len] = new TestTrie();
            listTrie[len].insert(words[i]);
            if(reverseListTrie[len] == null) reverseListTrie[len] = new TestTrie();
            String s = new StringBuffer(words[i]).reverse().toString();
            reverseListTrie[len].insert(s);
        }
        int[] answer = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            System.out.println(1);
            if(queries[i].charAt(0) != '?'){
                int len = queries[i].length();
                if(listTrie[len] == null){
                    answer[i] = 0;
                    continue;
                }
                int ans = listTrie[len].getCount(queries[i]);
                answer[i] =  ans;
            }else {
                int len = queries[i].length();
                if(reverseListTrie[len] == null){
                    answer[i] = 0;
                    continue;
                }
                String s = new StringBuffer(queries[i]).reverse().toString();
                System.out.println(s);
                int ans = reverseListTrie[len].getCount(s);
                answer[i] =  ans;
            }
        }
        System.out.println(Arrays.toString(answer));

    }
    static class TestTrie{
        Node root;
        TestTrie(){
            this.root = new Node();
        }
        void insert(String word){
            Node node = this.root;
            for(int i=0; i<word.length(); i++){
                node.count++;
                node = node.child.computeIfAbsent(word.charAt(i), character -> new Node());
            }
        }
        int getCount(String word){
            Node node = this.root;
            for(int i=0; i<word.length(); i++){
                if(word.charAt(i) == '?') break;
                if(!node.child.containsKey(word.charAt(i))) return 0;
                node = node.child.get(word.charAt(i));
            }
            return node.count;
        }
    }
    static class Node{
        Map<Character, Node> child;
        int count;

        Node(){
            this.child = new HashMap<>();
            int count =0;
        }
    }

}

