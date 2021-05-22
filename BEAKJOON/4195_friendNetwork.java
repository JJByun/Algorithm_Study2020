import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 백준_4195_친구네트워크 {
    // 백준 4195 친구 네트워크
    // 유니온 파인드 문제
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer stz;
    static int[] p;
    static int[] level;
    static int[] relation;
    static HashMap<String, Integer> map;
    static int curIdx;
    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(br.readLine());
        while (tc-->0){
            int N = Integer.parseInt(br.readLine());
            curIdx = 1;
            map = new HashMap<>();
            String[] query = new String[N];
            for(int i=0; i<N; i++){
                String ins = br.readLine();
                String[] name = ins.split(" ");
                checkName(name[0]);
                checkName(name[1]);
                query[i] = ins;
            }
            p = new int[map.size()+1];
            level = new int[map.size()+1];
            relation = new int[map.size()+1];
            for(int i=1; i<=map.size();i++){
                p[i] = i;
                level[i]=1;
                relation[i]=1;
            }
            //query 돌면서 같은 네트워크인지 체크해주기
            for(int i=0; i<N; i++){
                String[] name = query[i].split(" ");
                union(map.get(name[0]), map.get(name[1]));
            }
            bw.flush();
        }
        bw.close();
    }

    static void union(int a, int b) throws IOException {
        a = find(a);
        b = find(b);
        if(a==b){
            bw.write(relation[a]+"\n");
            return;
        }
        if(level[a] > level[b]){
            int tmp = b;
            b = a;
            a=tmp;
        }
        p[a]=b;
        relation[b] += relation[a]; //a의 친구관계 다 넣어주기
        bw.write(relation[b]+"\n");
        if(level[a]==level[b]) ++level[b];
    }
    static int find(int n){
        if(n==p[n]) return n;
        return p[n] = find(p[n]);
    }
    static void checkName(String name){
        if(map.containsKey(name)){
            return ;
        }else{
            map.put(name, curIdx++);
        }
    }
}
