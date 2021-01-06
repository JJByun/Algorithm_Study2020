import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_11724 {
    //백준 11742 : 연결 요소의 개수
    // BFS

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N,M;
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<=N; i++){
            list.add(new ArrayList<Integer>());
        }
        for(int i=0; i<M; i++){
            String[] in = br.readLine().split(" ");
            list.get(Integer.parseInt(in[0])).add(Integer.parseInt(in[1]));
            list.get(Integer.parseInt(in[1])).add(Integer.parseInt(in[0]));
        }
        int answer = 0;
        boolean[] visited = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=N; i++){
            if(!visited[i]){
                answer++;
                q.add(i);
                while(!q.isEmpty()){
                    int cur = q.poll();
                    visited[cur] = true;

                    for(int next : list.get(cur)){
                        if(!visited[next]){
                            visited[next] = true;
                            q.add(next);
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
