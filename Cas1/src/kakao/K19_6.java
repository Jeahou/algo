package kakao;

import java.util.*;

public class K19_6 {
    static int idx;
    public static void main(String[] args) {
        int[][] n = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        ArrayList<Node> list = new ArrayList<>();
        idx = 0;
        for(int i=0; i<n.length; i++){
            list.add(new Node(n[i][0], n[i][1], i+1));
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node node, Node t1) {
                    return t1.y - node.y;
            }
        });
        Node root = list.get(0);
        for(int i=1; i<list.size(); i++){
            connectNode(root, list.get(i));
        }
        for(Node t : list){
            System.out.println(t.x + " " + t.y + " " + t.idx);
        }
        int[][] answer = new int[2][list.size()];
        preOrder(answer[0], root);
        System.out.println(Arrays.toString(answer[0]));
        idx = 0;
        postOrder(answer[1], root);
        System.out.println(Arrays.toString(answer[1]));
    }
    static void preOrder(int[] a, Node node){
        if(node != null){
            a[idx++] = node.idx;
            if(node.left != null) preOrder(a, node.left);
            if(node.right != null) preOrder(a, node.right);
        }
    }
    static void postOrder(int[] a, Node node){
        if(node != null){
            if(node.left != null) postOrder(a, node.left);
            if(node.right != null) postOrder(a, node.right);
            a[idx++] = node.idx;
        }
    }
    static void connectNode(Node parent, Node child){
        if(parent.x > child.x){
            if(parent.left == null){
                parent.left = child;
            }else {
                connectNode(parent.left, child);
            }
        }else{
            if(parent.right == null){
                parent.right = child;
            }else {
                connectNode(parent.right, child);
            }
        }
    }
    static class Node{
        int x;
        int y;
        int idx;
        Node left = null;
        Node right = null;

        Node(int x, int y, int idx){
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }
}
