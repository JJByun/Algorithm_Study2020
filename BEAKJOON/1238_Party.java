import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_1238_파티 {
    // 백준 1238 파티
    // 다익스트라 문제
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static int N,M,X;
    static ArrayList<ArrayList<Node>> list,revereList;
    static int[] dist, reverseDist;
    public static void main(String [] args) throws IOException {
        stz = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());
        X = Integer.parseInt(stz.nextToken());
        init();
        int a,b,c;
        while(M-->0){
            stz = new StringTokenizer(br.readLine());
            a = Integer.parseInt(stz.nextToken());
            b = Integer.parseInt(stz.nextToken());
            c = Integer.parseInt(stz.nextToken());
            list.get(a).add(new Node(b,c));
            revereList.get(b).add(new Node(a,c));
        }

        exec(0);
        exec(1);
        int ret = 0;
        for(int i=1; i<=N; i++){
            ret = Math.max(ret, dist[i] + reverseDist[i]);
        }
        System.out.println(ret);
    }
    static void exec(int tag){
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.w-o2.w;
            }
        });
        if(tag==0){ //X 에서 모든 노드까지의 최단경로 구하기
           pq.add(new Node(X,0));
           dist[X] = 0;
           while(!pq.isEmpty()){
               Node cur = pq.poll();
               if(dist[cur.n] < cur.w) continue;
               for(Node next : list.get(cur.n)){
                   int nextCost = dist[cur.n] + next.w;
                   if(dist[next.n] > nextCost){
                       dist[next.n] = nextCost;
                       pq.add(new Node(next.n, nextCost));
                   }
               }
           }
        }else{ //reverse를 활용해서 모든 노드에서 X까지의 최단 경로 구하기
            pq.add(new Node(X,0));
            reverseDist[X] = 0;
            while(!pq.isEmpty()){
                Node cur = pq.poll();
                if(reverseDist[cur.n] < cur.w) continue;
                for(Node next : revereList.get(cur.n)){
                    int nextCost = reverseDist[cur.n] + next.w;
                    if(reverseDist[next.n] > nextCost){
                        reverseDist[next.n] = nextCost;
                        pq.add(new Node(next.n, nextCost));
                    }
                }
            }
        }
    }
    static void init(){
        dist = new int[N+1];
        reverseDist = new int[N+1];
        list = new ArrayList<>();
        revereList = new ArrayList<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(reverseDist, Integer.MAX_VALUE);
        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
            revereList.add(new ArrayList<>());
        }
    }
    static class Node{
        int n,  w;
        Node(int n, int w){
            this.n=n;
            this.w=w;
        }
    }
}
