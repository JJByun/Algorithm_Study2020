import javax.lang.model.type.UnionType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_2887_행성터널 {
    //크루스칼 알고리즘 + 정렬 문제
    static StringTokenizer stz;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int ret;
    static int[] p;
    static ArrayList<Edge> list = new ArrayList<>();
    static Node[] nodes;
    // 세 개의 좌표 중 가장 최소로 노드를 연결해야 한다
    // 따라서 한번씩 각 좌표값 기준으로 정렬을 해서 노드와 노드사이의 차이값을 넣어준다
    // 크루스칼을 수행하면서 노드 사이의 연결 값이 최소가 되면서 아직 연결을 안했다면 연결을 시켜주면서 union 수행
    // List에는 모든 노드의 연결 상태 * 3 만큼의 크기가 들어가게 됨 (N-1) * 3 의 크기

    public static void main(String args[]) throws IOException {
        ret = Integer.MAX_VALUE;
        N = Integer.parseInt(br.readLine());
        nodes = new Node[N];

        int a,b,c;
        for(int i=0; i<N; i++){
            stz = new StringTokenizer(br.readLine());
            a = Integer.parseInt(stz.nextToken());
            b = Integer.parseInt(stz.nextToken());
            c = Integer.parseInt(stz.nextToken());
            nodes[i] = new Node(i+1, a,b,c);
        }

        //어떻게 해결할지 고민해보기
        //하나씩 정렬
        Arrays.sort(nodes, (o1,o2) -> o1.x - o2.x);
        for(int i=0; i<N-1; i++){
            int weight = Math.abs(nodes[i].x - nodes[i+1].x);
            list.add(new Edge(nodes[i].n, nodes[i+1].n, weight));
        }
        Arrays.sort(nodes, (o1,o2) -> o1.y - o2.y);
        for(int i=0; i<N-1; i++){
            int weight = Math.abs(nodes[i].y - nodes[i+1].y);
            list.add(new Edge(nodes[i].n, nodes[i+1].n, weight));
        }
        Arrays.sort(nodes, (o1,o2) -> o1.z - o2.z);
        for(int i=0; i<N-1; i++){
            int weight = Math.abs(nodes[i].z - nodes[i+1].z);
            list.add(new Edge(nodes[i].n, nodes[i+1].n, weight));
        }

        ret= 0;
        kruskal();
        System.out.println(ret);
    }
    static void kruskal(){
        p = new int[N+1];
        for(int i=1; i<=N; i++) p[i] = i;
        Collections.sort(list, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        for(int i=0; i<list.size(); i++){
            Edge cur = list.get(i);

            if(find(cur.start) != find(cur.end)){
                ret += cur.weight;
                union(cur.start, cur.end);
            }
        }

    }
    static void union(int a, int b){
        int roota = find(a);
        int rootb = find(b);
        p[roota] = rootb;
    }
    static int find(int node){
        if(node == p[node]) return node;
        return p[node] = find(p[node]);
    }

    static class Node{
        int n, x, y, z;
        Node(int n, int x, int y, int z){
            this.n=n;
            this.x=x;
            this.y=y;
            this.z=z;
        }
    }
    //리스트에 넣기 위한 클래스. 노드와 노드 사이의 간선 가중치를 저장한다.
    //리스트에는 중복돼서 들어가기 때문에 그 중 가장 작은 값을 선택하고 크루스칼로 MST를 수행한다
    static class Edge{
        int start, end, weight;
        Edge(int start, int end, int weight){
            this.start=start;
            this.end=end;
            this.weight=weight;
        }
    }
}
