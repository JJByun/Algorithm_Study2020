import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Make1 {
    //solution number : 1463 - 1로 만들기 문제

    static int minValue = Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        //dfs(num,0); //dfs 완탐으로 문제 안풀림
        int ans = 0;
        boolean[] visited = new boolean[10000001];

        //bfs 시작
        Queue<info> q = new LinkedList<>();
        q.add(new info(num,0));
        while(!q.isEmpty()){
            info node = q.poll();
            int n = node.n;
            int count = node.count;
            if(n == 1){
                ans = count;
                break;
            }
            if(visited[n]) continue;
            else visited[n] = true;
            if(n % 3 == 0){

                q.add(new info(n/3, count+1));
            }
            if(n % 2 == 0){

                q.add(new info(n/2,count+1));
            }

            q.add(new info(n-1,count+1));
        }

        System.out.println(ans);
    }
    static void dfs(int n, int count){
        //termination check
        if(n == 1){
            minValue = Math.min(minValue, count);
            return;
        }
        //recursion
        if(n % 3 == 0)
            dfs(n/3,count+1);
        if(n % 2 == 0)
            dfs(n/2, count+1);
        dfs(n-1,count+1);
    }
    static class info{
        int n;
        int count;

        info(int n,int count){
            this.n = n;
            this.count = count;
        }
    }
}
