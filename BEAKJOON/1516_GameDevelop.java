import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1516_GameDevelop {
    //sol num : 1516 - 게임개발
    // 위상정렬 문제
    public static void main(String args[] ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<=N; i++) list.add(new ArrayList<Integer>());
        int[] indegree = new int[N+1];
        int[] cost = new int[N+1];
        int[] ret = new int[N+1];
        for(int i=1; i<=N; i++){
            int[] ins = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            cost[i] = ins[0];
            for(int j=1; j<ins.length-1; j++){
                list.get(ins[j]).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++){
            if(indegree[i] == 0) q.add(i);
            ret[i] = cost[i];
        }
        while(!q.isEmpty()){
            int cur  = q.poll();
            for(int next : list.get(cur)){
                if(--indegree[next] == 0) q.add(next);
                ret[next] = Math.max(ret[next], cost[next] + ret[cur]);
            }
        }

        for(int i=1; i<ret.length; i++)
            System.out.println(ret[i]);
    }
}
