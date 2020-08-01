import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Labatory {
    // solution number : 14502
    static int N;
    static int M;
    static int[][] board;
    static int[][] tmp;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int MAX = Integer.MIN_VALUE;
    static ArrayList<Point> virus = new ArrayList<>();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        N = inputs[0];
        M = inputs[1];
        board = new int[N][M];
        tmp = new int[N][M];
        for(int i=0; i<N; i++){
            int[] boards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<M; j++){
                board[i][j] = boards[j];
                if(boards[j] == 2)
                    virus.add(new Point(i,j));
            }
        }
        // 0 -> 빈칸
        // 1 -> 벽
        // 2 -> 바이러스
        // 벽을 꼭 3개를 세워서 안전영역의 최댓값을 만들어야 한다!
        setWall(0,0);
        System.out.println(MAX);
    }
    static void copy(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++)
                tmp[i][j] = board[i][j];
        }
    }
    static void setWall(int start, int depth){
        if(depth == 3){
            copy();
            for(Point p : virus)
                spread(p);
            MAX = Math.max(MAX, countSafety());
            return;
        }
        for(int i= start; i<N*M; i++){
            int x = i / M;
            int y = i % M;
            //백트래
            if(board[x][y] == 0){
                board[x][y] = 1;
                setWall(start+1, depth+1);
                board[x][y] = 0;
            }
        }
    }
    //바이러스 dfs로 퍼트리기
    public static void spread(Point p){
        for(int i=0; i<4; i++){
            int x2 = p.x + dx[i];
            int y2 = p.y + dy[i];
            if(x2 < 0 || x2 >= N || y2 < 0 || y2 >= M ) continue;
            if(tmp[x2][y2] == 0){
                tmp[x2][y2] = 2;
                spread(new Point(x2,y2));
            }
        }

    }
    public static int countSafety(){
        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(tmp[i][j] == 0)
                    cnt++;
            }
        }
        return cnt;
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
