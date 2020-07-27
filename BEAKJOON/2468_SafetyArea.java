import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SafetyArea {
    // solution number : 2468

    static int[][] board;
    static int N;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int MAX = 0;
    static int MAX_SAFETY = 0;
    static int[][] tmp;
    static boolean[][] visited;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i=0; i<N; i++){
            int[] arrs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<N; j++){
                board[i][j] = arrs[j];
                MAX = Math.max(MAX, arrs[j]);
            }
        }
        for(int n=0; n<MAX; n++){
            tmp = board.clone();
            //board 먼저 침수시켜주기
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(tmp[i][j] <= n)
                        tmp[i][j] = -1;
                }
            }

            int count = 0;
            visited = new boolean[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(tmp[i][j] != -1 && !visited[i][j]){ //침수 안당하고 방문 안한 지역이라면
                        count++;
                        visited[i][j] = true;
                        dfs(new Point(i,j));
                        //dfs탐색 종료 시점. 인접한 부분은 모두 탐색 완료

                    }
                }
            }
            // 침수 높이가 i 일때 탐색 완료 시점
            MAX_SAFETY = Math.max(MAX_SAFETY , count);

        }
        System.out.println(MAX_SAFETY);
    }
    static void dfs(Point p){
        for(int i=0; i<4; i++){
            int x2 = p.x + dx[i];
            int y2 = p.y + dy[i];
            if(x2 < 0 || x2 >= N || y2 < 0 || y2 >= N || visited[x2][y2]) continue;
            if(tmp[x2][y2] != -1){
                visited[x2][y2] = true;
                dfs(new Point(x2,y2));
            }
        }
        return;
    }
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
