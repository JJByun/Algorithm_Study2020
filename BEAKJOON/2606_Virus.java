import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Virus {
    //soution number : 2606
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        //인접리스트로 그래프 구현하기
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<N+1; i++){
            graph.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[N+1];

        while(n-- > 0){
            // 그래프 연결시키기
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(inputs[0]).add(inputs[1]);
            graph.get(inputs[1]).add(inputs[0]);
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        while(!q.isEmpty()){
            int num = q.poll();
            for(int tmp : graph.get(num)){
                if(!visited[tmp]){
                    visited[tmp] = true;
                    count ++;
                    q.add(tmp);
                }
            }
        }
        System.out.println(count);
    }
}
