import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ACM_Craft {
    // solution number : 백준 1005 - ACM Craft 문제
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int itr = Integer.parseInt(br.readLine());
        while(itr-->0){
            int N; //건물 개수
            int K; //건설 규칙 순서 개수
            int[] inputs  = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            N = inputs[0];
            K = inputs[1];

            int[] apt = new int[N+1]; //건물 걸리는 시간을 담는 배열
            int[] times = new int[N+1]; //해당 노드까지 걸리는 시간을 업데이트 해주는 배열
            int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int i=1; i<=in.length;i++){
                apt[i]=in[i-1];
                times[i]=in[i-1];
            }
            int[] indegree = new int[N+1]; //위상정렬 체크 배열
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for(int i=0;i<=N; i++){
                list.add(new ArrayList<Integer>());
            }
            for(int i=0; i<K; i++){
                int[] v = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                list.get(v[0]).add(v[1]);
                indegree[v[1]]++;
            }
            int target = Integer.parseInt(br.readLine()); //마지막으로 도착해야 하는 아파트
            Queue<Integer> q = new LinkedList<>();
            for(int i=1; i<=N; i++){ //먼저 선행조건 없는 건물 넣어주기
                if(indegree[i] == 0) q.add(i);
            }
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int next : list.get(cur)){
                    indegree[next]--; //선행조건 감소
                    times[next] = Math.max(times[next], apt[next] + times[cur]);
                    if(indegree[next] == 0) q.add(next);
                }
            }
            System.out.println(times[target]);
        }
    }
}
