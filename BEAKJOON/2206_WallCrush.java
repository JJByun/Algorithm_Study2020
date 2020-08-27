import java.awt.image.BufferedImageFilter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WallCruch {
    //solution number : 2206
    static int N,M;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int answer = Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] board = new int[1001][1001];
        int[][] visited = new int[1001][1001];
        N = in[0];
        M = in[1];
        for(int i=0; i<N; i++){
            char[] arr = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                board[i][j] = Character.getNumericValue(arr[j]);
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        //bfs 탐색 시작
        Queue<point> q = new LinkedList<>();
        q.add(new point(0,0,1,0)); //x, y좌표, 이동거리, 공사 횟수
        visited[0][0] = 0;
        while(!q.isEmpty()){
            point p = q.poll();
            int x = p.x;
            int y = p.y;
            if(x == N-1 && y == M-1){
               answer = p.sum;
               break;
            }

            for(int i=0; i<4; i++){
                int x2 = x + dx[i];
                int y2 = y + dy[i];

                if(x2 < 0 || x2 >= N || y2 < 0 || y2 >= M ) continue; //exception
                if(visited[x2][y2] <= p.crush) continue; //이미 방문한 곳은 넘겨주기

                if(board[x2][y2] == 0){ //벽이 아닌 경우 넣어주면
                    visited[x2][y2] = p.crush;
                    q.add(new point(x2,y2,p.sum+1,p.crush));
                }else{ //벽인 경우 부수지 않은 경우만 넘을 수 있음
                    if(p.crush == 0){
                        visited[x2][y2] = p.crush + 1;
                        q.add(new point(x2,y2,p.sum+1, p.crush+1));
                    }
                }

            }
        }

        if(answer == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(answer);
    }

    public static class point{
        int x;
        int y;
        int crush; //꺴는지 체크
        int sum; //이동 거리
        point(int x, int y, int sum, int crush){
            this.x = x;
            this.y = y;
            this.crush = crush;
            this.sum = sum;
        }
    }
}
