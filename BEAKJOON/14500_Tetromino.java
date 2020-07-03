import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Tetromino {
    //solution number : 14500
    static int retCount = 0;
    static int[][] board;
    static boolean[][] visited;
    static int N, M;
    static int[] _X = {-1,1,0,0};
    static int[] _Y = {0,0,-1,1};
    static int ex[][] = {{0, 0, 0, -1}, {0, 0, -1, 1}, {0, 0, 0, 1}, {0, 0, -1, 1}};
    static int ey[][] = {{0, 1, -1, 0}, {0, 1, 0, 0}, {0, -1, 1, 0}, {0, -1, 0, 0}};
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = size[0];
        M = size[1];
        //board 생성
        board = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        for(int i=0; i<N; i++){
            int[] boardSize = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<M; j++){
                board[i][j] = boardSize[j];
            }
        }
        //탐색 시작
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                //System.out.println(i+" "+j+" 탐색 시작");
                //dfs 먼저 수행
                visited[i][j] = true;
                //dfs로 먼저 탐
                dfs(i,j,board[i][j], 1, visited);
                visited[i][j] = false;
                //ㅗ 모양 움직여주기
                check_exshape(i,j);
            }
        }
        System.out.println(retCount);

    }
    static void dfs(int x, int y, int sum_value, int depth, boolean[][] visited){
        if(depth == 4){
            retCount = Math.max(retCount,sum_value);
            return;
        }

        for(int i=0; i<4; i++){
            int nx = x + _X[i];
            int ny = y + _Y[i];

            // 지도 넘어가는 경우 검사
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

            // 방문하지 않은 점이면
            if(!visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, sum_value + board[nx][ny], depth + 1,visited);
                visited[nx][ny] = false;
            }
        }
    }

    public static void check_exshape(int x, int y) {

        for (int i = 0; i < 4; i++) {

            Boolean isOut = false;
            int sum_value = 0;

            for (int j = 0; j < 4; j++) {
                int nx = x + ex[i][j];
                int ny = y + ey[i][j];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    isOut = true;
                    break;
                } else {
                    sum_value += board[nx][ny];
                }
            }
            if (!isOut) {
                retCount = Math.max(retCount, sum_value);
            }
        }
    }
}
