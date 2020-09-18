import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LineUp {
    // 백준문제
    //solutioin number : 2252 - 줄 세우기

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0]; // 인접리스트 개수
        int M = inputs[1]; // 받는 관계 수

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[] indegree  = new int[N+1];
        for(int i=0; i<=N; i++){
            list.add(new ArrayList<Integer>());
        }
        while(M-->0){
            int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.get(in[0]).add(in[1]);
            indegree[in[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=1 ; i< indegree.length;i++){
            if(indegree[i] == 0) q.add(i);
        }

        StringBuffer sb = new StringBuffer();
        while(!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur+" ");
            for(int i : list.get(cur)){
                indegree[i]--;
                if(indegree[i] == 0) q.add(i);
            }
        }
        System.out.println(sb.toString().trim());
    }
}
