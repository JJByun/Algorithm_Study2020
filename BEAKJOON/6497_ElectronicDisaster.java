import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 백준_6497_전력난 {
    // 백준 6597 전력난
    // 크루스칼 알고리즘 문제 - 전력을 최소화하면서 모든 도시를 연결하는 방법을 물었음 -> MST로 거리가 최소인거부터 넣어주면 됨
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static int[][] edge;
    static int N,M;
    static int[] p = new int[200001];
    public static void main(String[] args) throws IOException {
        while(true){
            stz = new StringTokenizer(br.readLine());
            N = Integer.parseInt(stz.nextToken());
            M = Integer.parseInt(stz.nextToken());
            if (N == 0 && M == 0) {
                break;
            }
            edge = new int[M][3];

            for(int i=0; i<=N; i++) p[i] = i;

            int maxCost=0;
            int a,b,c;
            for(int i=0; i<M; i++){
                stz = new StringTokenizer(br.readLine());
                a = Integer.parseInt(stz.nextToken());
                b = Integer.parseInt(stz.nextToken());
                c = Integer.parseInt(stz.nextToken());
                edge[i][0] = a;
                edge[i][1] = b;
                edge[i][2] = c;
                maxCost+=c;
            }
            Arrays.parallelSort(edge, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[2] - o2[2];
                }
            });
            int removeCost=0;
            for(int i=0; i<M; i++){
                a = find(edge[i][0]);
                b = find(edge[i][1]);
                if(a!=b){
                    removeCost+=edge[i][2];
                    union(edge[i][0], edge[i][1]);
                }
            }
            System.out.println(maxCost - removeCost);
        }

    }

    static int find(int x){
        if(p[x] == x) return x;
        return p[x] = find(p[x]);
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            p[a] = b;
        }
    }
    static class Node{
        int node,cost;
        Node(int node, int cost){
            this.node=node;
            this.cost=cost;
        }
    }
}
