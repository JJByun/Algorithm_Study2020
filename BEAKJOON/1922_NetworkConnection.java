import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 백준_1922_네트워크연결 {
    //백준 1922 네트워크 연결
    // 크루스칼 알고리즘 - MST
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static int N,M;
    static int[] p;
    static int[][] edge;
    static int ret;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        p = new int[N+1];
        M = Integer.parseInt(br.readLine());
        edge = new int[M][3];
        ret=0;
        for(int i=1; i<=N; i++) p[i] = i;

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

        Arrays.parallelSort(edge, 0, M, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2]; //오름차순 정렬 -> 비용이 작은거부터 찾아봐주기
            }
        });
        for(int i=0; i<M; i++){
            a = find(edge[i][0]);
            b = find(edge[i][1]);
            if(a != b){
                ret += edge[i][2];
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
        if(p[node] == node) return node;
        return p[node] = find(p[node]);
    }
}
