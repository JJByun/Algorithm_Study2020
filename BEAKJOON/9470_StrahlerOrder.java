import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_9470_StrahlerOrder {
    //solution number : 9470 - Strachler 순서

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=1; i<=N; i++){
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int k =arr[0];
            int m = arr[1];
            int p = arr[2];

            ArrayList<ArrayList<Integer>> list= new ArrayList<>();
            int[] indegree = new int[m+1];
            int[] tmp = new int[m+1];
            for(int n=0; n<=m ;n++){
                list.add(new ArrayList<Integer>());
            }
            while(p-->0){
                int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                list.get(in[0]).add(in[1]);
                indegree[in[1]]++;
            }
//            Queue<Integer> q = new LinkedList<>();
//            for(int n=1; n< indegree.length; n++){
//                if(indegree[n] == 0){
//                    q.add(n);
//                    tmp[n] =1;
//                }
//            }

//            while(!q.isEmpty()){
//                int cur = q.poll();
//                for(int next : list.get(cur)){
//                    if(--indegree[next] == 0) q.add(next);
//                    tmp[next] = Math.max(tmp[cur] +1 , tmp[next]);
//                }
//            }
            System.out.println(k+" "+indegree[m]);
        }
    }
}
