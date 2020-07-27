import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Tomato2 {
    //solution number : 7576

    static int M;
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static Queue<Point> q = new LinkedList<>();
    static int count = 0;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        M = inputs[0];
        N = inputs[1];
        //board 생성
        board = new int[N][M];
        visited = new boolean[N][M];
        int tom = 0;
        for(int i=0; i<N; i++){
            int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<M; j++){
                board[i][j] = in[j];
                if(in[j] == 1)
                    tom++;
            }
        }
        //익은 토마토가 하나도 없는 경우
        if(tom == 0){
            System.out.println("-1");
            return;
        }

        //예외처리 - 토마토 주위로 빈 칸인 경우
        if(isSurroundEmpty()){
            System.out.println("-1");
            return;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j] == 1 && !visited[i][j]){
                    q.add(new Point(i,j));
                }
            }
        }
        bfs();

        if(isEnd())
            System.out.println(count);

    }

    static void bfs(){
        while(!q.isEmpty()){
            boolean dayCut = false;
            int qSize = q.size();

            for(int n=0; n<qSize; n++){
                Point p = q.poll();
                int x = p.x;
                int y = p.y;
                visited[x][y] = true;
                for(int i=0; i<4; i++){
                    int x2 = x + dx[i];
                    int y2 = y + dy[i];
                    if(x2 < 0 || x2 >= N || y2 < 0 || y2 >= M || visited[x2][y2]) continue;
                    if (board[x2][y2] == 0){
                        dayCut = true;
                        board[x2][y2] = 1;
                        q.add(new Point(x2,y2));
                    }
                }

            }
            if(dayCut)
                count++;
        }
    }
    static boolean isSurroundEmpty(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j] == 0){
                    boolean b = true;
                    for(int n=0; n<4; n++){ //빈 칸으로 둘러쌓이면 다 익을 수 없음
                        int x2 = i + dx[n];
                        int y2 = j + dy[n];
                        if(x2 < 0 || x2 >= N || y2 < 0 || y2 >= M) continue;
                        if(board[x2][y2] != -1)
                            b=false;
                    }
                    if(b)
                        return true;
                }
            }
        }
        return false;
    }
    static boolean isEnd(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j] == 0) { //안익은게 하나라도 있으면 false return
                    System.out.println("-1");
                    return false;
                }else if(count == 0){
                    System.out.println("0");
                    return false;
                }

            }
        }
        return true;
    }

    public static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
