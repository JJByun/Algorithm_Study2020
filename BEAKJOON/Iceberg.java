import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Iceberg {
    //solution number : 2573

    static int[][] board;
    static int N, M;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int retCount = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = size[0];
        M = size[1];
        //board 생성
        board = new int[N+1][M+1];
        for(int i=0; i<N; i++){
            int[] boardSize = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<M; j++){
                board[i][j] = boardSize[j];
            }
        }

        do{
            retCount++;
            melt();
        }while (!isSplit());
        System.out.println(retCount);

    }

    static void melt(){ //빙산 녹이기
        int[][] tmpBoard = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                tmpBoard[i][j] = board[i][j];
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                //System.out.println(i+" "+j +" "+ board[i][j]);
                if(board[i][j] == 0){
                    //동서남북 녹이기
                    for(int n=0; n<dx.length; n++){
                        int x2 = i + dx[n];
                        int y2 = j + dy[n];
                        if(x2 < 0 || x2 >= N || y2 < 0 || y2 >=M) continue;
                        tmpBoard[x2][y2] -= 1;
                    }
                }
            }
        }

        //0이하인 숫자를 0으로 만들어주
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(tmpBoard[i][j] <= 0)
                    board[i][j] = 0;
                else
                    board[i][j] = tmpBoard[i][j];
            }
        }
    }

    static boolean isSplit(){ //두개로 나뉘었는지 체크

        int count = 0;
        boolean[][] visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            for(int j=0 ; j<M; j++){
                if(board[i][j] != 0 && !visited[i][j]){
                    count++;
                    visited[i][j] = true;
                    //dfs 로 끝까지 탐색
                    dfs(i,j, visited);
                }
            }
        }
        if(count == 0){ //모든 배열이 0인 경우 그냥 리턴해주기
            retCount = 0;
            return true;
        }

        if(count == 1)
            return false;
        else
            return true;
    }
    static void dfs(int x, int y, boolean[][] visited){
        for(int n=0; n<dx.length; n++){
            int x2 = x + dx[n];
            int y2 = y + dy[n];
            if(x2 < 0 || x2 >= N || y2 < 0 || y2 >= M) continue;
            if(!visited[x2][y2] && board[x2][y2] != 0){
                visited[x2][y2] = true;
                dfs(x2,y2, visited);
            }

        }
    }


}
