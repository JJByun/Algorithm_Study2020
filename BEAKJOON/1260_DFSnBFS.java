import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class DFSnBFS {
    //Solution Number : 1260

    //인접 리스트로 그래프 구현
    static ArrayList<ArrayList<Integer>> graph;
    public static void main(String args[]) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String [] input = bf.readLine().split(" ");
        int node = Integer.parseInt(input[0]);
        int edge = Integer.parseInt(input[1]);
        int start = Integer.parseInt(input[2]);

        graph = new ArrayList<>();
        for(int i=0; i<node+1; i++){
            graph.add(new ArrayList<Integer>()); //graph 생성
        }
        for(int i=0; i<edge; i++){
            String[] inputs = bf.readLine().split(" ");
            int node1 = Integer.parseInt(inputs[0]);
            int node2 = Integer.parseInt(inputs[1]);
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        for(int i=1; i<node+1; i++){
            Collections.sort(graph.get(i));
        }
        boolean [] visited = new boolean[node+1];
        dfs(start,visited);
        System.out.println();
        bfs(start);
    }
    public static void dfs(int n, boolean[] visited){
        if(visited[n]) //방문한 경우 리턴
            return;
        System.out.print(n+" ");
        visited[n] = true;
        for(int i=0; i<graph.get(n).size(); i++){
            int node = graph.get(n).get(i);
            if(!visited[node]){
                dfs(node,visited);
            }
        }
    }

    public static void bfs(int startNode){
        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);
        boolean [] visited = new boolean[graph.size()+1];
        while(!q.isEmpty()){
            int node = q.poll();
            if(visited[node]) //이미 방문한기 경우 넘겨주기
                continue;

            visited[node] = true;
            System.out.print(node+" ");
            for(int n : graph.get(node))
                q.add(n);
        }
    }
}
