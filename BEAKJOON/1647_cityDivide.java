import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 백준_1647_도시분할계획 {
    //백준 1647 도시 분할 계획
    //MST
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer stz;
    static int N,M;
    static int[] p;
    static int[] level;
    static int[][] edge;
    static int MAX;
    static int ret;
    public static void main(String[] args) throws IOException {
        stz = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());
        edge = new int[M][3];
        p = new int[N+1];
        level = new int[N+1];
        for(int i=1; i<=N; i++){
            p[i] = i;
            level[i]=1;
        }
        int a,b,c;
        for(int i=0; i<M; i++){
            stz = new StringTokenizer(br.readLine());
            a = Integer.parseInt(stz.nextToken());
            b = Integer.parseInt(stz.nextToken());
            c = Integer.parseInt(stz.nextToken());
            edge[i][0] = a;
            edge[i][1] = b;
            edge[i][2] = c;
        }
        Arrays.parallelSort(edge, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        MAX = Integer.MIN_VALUE;
        ret = 0;
        for(int i=0; i<M; i++){
            a = find(edge[i][0]);
            b = find(edge[i][1]);
            if(a!=b){
                union(a,b);
                ret += edge[i][2];
                MAX = Math.max(MAX, edge[i][2]);
            }
        }
        System.out.println(ret-MAX);
    }
    static void union(int a, int b){
        if(p[a] > p[b]){
            int tmp = b;
            b=a;
            a=tmp;
        }
        p[a]=b;
        if(level[a]==level[b]) ++level[b];
    }
    static int find(int n){
        if(p[n] == n) return n;
        return p[n] = find(p[n]);
    }
}
