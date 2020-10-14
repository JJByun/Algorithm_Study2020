import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2637_Toy {
    //solution number : 2637 - 장난감 조립
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //완성 장난감 번호
        int M = Integer.parseInt(br.readLine()); //받는 개수

        ArrayList<ArrayList<Toy>> list = new ArrayList<>();
        for(int i=0; i<=N; i++){
            list.add(new ArrayList<Toy>());
        }
        int[] indegree = new int[N+1];
        int[][] cnt = new int[101][101];
        while(M-->0){
            int [] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.get(arr[0]).add(new Toy(arr[1],arr[2]));
            indegree[arr[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++){
            if(indegree[i] == 0)q.add(i);
            cnt[i][i]=1;
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            for(Toy t : list.get(cur)){
                for(int j=1; j<=N; j++){
                    cnt[j][t.num] += t.cnt*cnt[j][cur];
                }
                if(--indegree[t.num]==0)q.add(t.num);
            }
        }
        for(int i=1; i<=N; i++){
            if(list.get(i).size()==0){
                System.out.println(i+" "+cnt[N][i]);
            }
        }


    }
    public static class Toy{
        int num;
        int cnt;
        Toy(int num, int cnt){
            this.cnt=cnt;
            this.num=num;
        }
    }

}
