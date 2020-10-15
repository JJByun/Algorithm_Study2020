import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_14567_Prerequisite {
    //solution number : 14567 - 선수과목

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N,M;
        String[] in = br.readLine().split(" ");
        N = Integer.parseInt(in[0]);
        M = Integer.parseInt(in[1]);
        int[] indegree = new int[N+1];
        int[] ret = new int[N+1];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<=N; i++){
            list.add(new ArrayList<Integer>());
        }
        while(M-->0){
            int[] ins = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.get(ins[0]).add(ins[1]);
            indegree[ins[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=1 ;i<=N; i++){
            if(indegree[i] == 0) q.add(i);
            ret[i]=1;
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : list.get(cur)){
                if(--indegree[next] == 0) q.add(next);
                ret[next] = Math.max(ret[next], ret[cur] + 1);
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i=1; i<=N; i++){
            sb.append(ret[i]+" ");
        }
        System.out.println(sb.toString().trim());
    }
}
