import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_1991_TreeTravel {
    //solution number : 1991 - 트리 순회

    static final int LEFT = 0;
    static final int RIGHT = 1;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            char c = (char) ('A' + i);
            map.put(c, i+1);
        }
        map.put('.',0);
        int[][] graph = new int[n+1][2];

        for(int i=1; i<n; i++){
            char[] ins = br.readLine().toCharArray();
            char root = ins[0];
            int nRoot = root - 64;
            char left = ins[2];
            char right = ins[4];
            graph[nRoot][0] = map.get(left);
            graph[nRoot][1] = map.get(right);
        }

        StringBuilder sb = new StringBuilder();
        preOrder(graph, 1, sb);
        System.out.println(sb.toString());
        sb.delete(0,sb.length());
        inOrder(graph, 1, sb);
        System.out.println(sb.toString());
        sb.delete(0,sb.length());
        postOrder(graph,1,sb);
        System.out.println(sb.toString());
    }
    private static void preOrder(int[][] graph, int root, StringBuilder sb){ // val -> left -> right
        char c = (char)(root + 64);
        sb.append(c);
        if(graph[root][LEFT] != 0) preOrder(graph,graph[root][LEFT],sb);
        if(graph[root][RIGHT] != 0) preOrder(graph,graph[root][RIGHT],sb);
    }
    private static void inOrder(int[][] graph, int root, StringBuilder sb){ // left -> root -> right
        if(graph[root][LEFT] != 0) inOrder(graph,graph[root][LEFT],sb);
        char c = (char)(root + 64);
        sb.append(c);
        if(graph[root][RIGHT] != 0) inOrder(graph,graph[root][RIGHT],sb);
    }
    private static void postOrder(int[][] graph, int root, StringBuilder sb){ // left -> right -> root
        if(graph[root][LEFT] != 0) postOrder(graph,graph[root][LEFT],sb);
        if(graph[root][RIGHT] != 0) postOrder(graph,graph[root][RIGHT],sb);
        char c = (char)(root + 64);
        sb.append(c);
    }
}
