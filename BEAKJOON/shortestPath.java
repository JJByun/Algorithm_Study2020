import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_1753_최단경로 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static int V,E,K;
    static int[] cost;
    public static void main(String args[]) throws IOException {
        stz = new StringTokenizer(br.readLine());
        V = Integer.parseInt(stz.nextToken());
        E = Integer.parseInt(stz.nextToken());
        K = Integer.parseInt(br.readLine());
        cost = new int[V+1];
        for(int i=0; i<cost.length; i++) cost[i] = Integer.MAX_VALUE;

        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for(int i=0; i<=V; i++){
            list.add(new ArrayList<Node>());
        }
        for(int i=0; i<E; i++){
            stz = new StringTokenizer(br.readLine());
            list.get(Integer.parseInt(stz.nextToken())).add(new Node(Integer.parseInt(stz.nextToken()), Integer.parseInt(stz.nextToken())));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.w-o2.w;
            }
        });
        cost[K] = 0;
        pq.add(new Node(K,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cost[cur.idx] < cur.w) continue; // 이미 해당 간선의 가중치가 이미 있는 가중치보다 크다면 넘겨주기
            for(Node next : list.get(cur.idx)){
                int nextCost = cost[cur.idx] + next.w;
                if(cost[next.idx] > nextCost){ //업데이트 시켜주는게 더 비용이 적다면 선택해주기
                    cost[next.idx] = nextCost;
                    pq.add(new Node(next.idx, nextCost));
                }
            }
        }

        for(int i=1; i<=V; i++){
            if(cost[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(cost[i]);
        }

    }
    static class Node{
        int idx;
        int w;
        Node(int idx, int w){
            this.idx=idx;
            this.w=w;
        }
    }
}
