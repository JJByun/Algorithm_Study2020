import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 백준_16398_행성연결 {
    //백준 16398 행성 연결
    //MST
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer stz;
    static int[] p;
    static int[] level;
    static int[][] edge;
    static boolean[][] visited;
    static int N;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        p = new int[N+1];
        level = new int[N+1];
        edge = new int[(N*(N-1))/2][3];
        visited = new boolean[N+1][N+1];
        for(int i=1; i<=N; i++){
            p[i]=i;
            level[i]=1;
        }
        int a;
        int edgeIdx=0;
        for(int i=1; i<=N; i++){
            stz = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                a = Integer.parseInt(stz.nextToken()); //가중치
                if(visited[i][j]) continue;
                if(i==j) continue;
                edge[edgeIdx][0]=i;
                edge[edgeIdx][1]=j;
                edge[edgeIdx++][2]=a;
                visited[j][i]=true;
                visited[i][j] = true;
            }
        }
        Arrays.parallelSort(edge, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        int ret = 0;
        int b;
        for(int i=0; i<edge.length; i++){
            a = find(edge[i][0]);
            b = find(edge[i][1]);
            if(a==b){
                continue;
            }else{
                union(a,b);
                ret+=edge[i][2];
            }

        }
        System.out.println(ret);
    }
    static int find(int n){
        if(p[n] == n) return n;
        return p[n] = find(p[n]);
    }
    static void union(int a, int b){
//        if(level[a] > level[b]){
//            int tmp = b;
//            b=a;
//            a=tmp;
//        }
        p[a]=b;
        //if(level[a]==level[b])++level[b];
    }
}
