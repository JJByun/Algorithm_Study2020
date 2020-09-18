import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class WorkBoot {
    //solution number : 1766 - 문제집

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0]; // 인접리스트 개수
        int M = inputs[1]; // 받는 관계 수
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[] indegree = new int[N+1];
        for(int i=0; i<=N; i++){
            list.add(new ArrayList<Integer>());
        }
        while(M-->0){
            int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.get(in[0]).add(in[1]);
            indegree[in[1]]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuffer sb = new StringBuffer();
        //indegree가 0인 것들을 배열에 담기
        for(int i=1; i<=N; i++){
            if(indegree[i] == 0)
                pq.add(i);
        }
        //pq가 빌때까지 반복
        while(!pq.isEmpty()){
            int cur = pq.poll();
            sb.append(cur+" ");
            //자식 노드들의 indegree 값을 0으로 만들어주기
            for(int i : list.get(cur)){
                indegree[i]--;
                if(indegree[i] == 0) pq.add(i);
            }
        }
        System.out.println(sb.toString().trim());
    }
}

