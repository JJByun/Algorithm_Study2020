import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 백준_1197_최소스패닝트리 {
    //백준 1197 최소스패닝트리
    // MST  알고리즘(크루스칼 알고리즘)
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static int V,E;
    static int[] p;
    static int[][] edge;
    public static void main(String[] args) throws IOException {
        stz = new StringTokenizer(br.readLine());
        V = Integer.parseInt(stz.nextToken());
        E = Integer.parseInt(stz.nextToken());
        edge = new int[E][3];
        p = new int[V+1];
        for(int i=1; i<=V; i++) p[i] = i;

        int a,b,c;
        for(int i=0; i<E; i++){
            stz = new StringTokenizer(br.readLine());
            a = Integer.parseInt(stz.nextToken());
            b = Integer.parseInt(stz.nextToken());
            c = Integer.parseInt(stz.nextToken());
            edge[i][0] = a;
            edge[i][1] = b;
            edge[i][2] = c;
        }
        Arrays.parallelSort(edge, 0, E, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        int ret = 0;
        for(int i=0; i<E; i++){
            a = find(edge[i][0]);
            b = find(edge[i][1]);
            if(a != b){
                ret+=edge[i][2];
                union(a,b);
            }
        }
        System.out.println(ret);
    }

    static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        p[rootA] = rootB;
    }
    static int find(int node){
        if(node == p[node]) return node;
        return p[node] = find(p[node]);
    }
}
