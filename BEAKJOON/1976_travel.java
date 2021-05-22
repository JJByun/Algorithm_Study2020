import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_1976_여행가자 {
    // 백준 1976 여행가자
    // 유니온 파인드 문제
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer stz;
    static int N,M;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int[] p;
    static boolean[] visited;
    static int[] level;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine()); //여행하려는 나라 개수
        M = Integer.parseInt(br.readLine()); //지나가야하는 나라
        p = new int[N+1];
        level = new int[N+1];
        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
            p[i] = i;
            level[i]=1;
        }

        visited = new boolean[N+1];

        for(int i=1; i<=N; i++){
            stz = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                int n = Integer.parseInt(stz.nextToken());
                if(n==1){
                    list.get(i).add(j);
                }
            }
        }
        int[] doVisit = new int[M]; //방문해야 하는 장소들
        stz = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            doVisit[i] = Integer.parseInt(stz.nextToken());
        }
        for(int i=1; i<=N; i++){
            if(!visited[i]){
                bfs(i);
            }
        }
        int cur = p[doVisit[0]];
        String ret="YES";
        for(int i=1; i<M; i++){
            if(cur != p[doVisit[i]]){
                ret="NO";
                break;
            }
        }
        bw.write(ret+"\n");
        bw.flush();
        bw.close();
    }
    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start]=true;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : list.get(cur)){
                if(visited[next])continue;
                visited[next]=true;
                union(cur,next);
                q.add(next);
            }
        }
    }

    static int find(int n){
        if(n==p[n]) return n;
        return p[n] = find(p[n]);
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b) return;
        if(level[a] > level[b]){
            int tmp = b;
            b = a;
            a=tmp;
        }
        p[a]=b;
        if(level[b] == level[a]) ++level[b];
    }
}
