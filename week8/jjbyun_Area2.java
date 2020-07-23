import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Area2 {

        // solution number : 2583
        static int N,M,K;
        static int[][] board;
        static int[] dx = {0,0,-1,1};
        static int[] dy = {1,-1,0,0};
        static boolean[][] visited;
        static int count = 0;
        public static void main(String args[]) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            M = input[0]; //세로
            N = input[1]; //가로
            K = input[2];
            board = new int[M][N];
            //input값 처리 먼저 해주기
            //행: M - 받은 값
            //열: 받은 값
            while( K-- > 0){
                int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int startX = inputs[0];
                int endX = inputs[2];
                int startY = M - inputs[3];
                int endY = M - inputs[1];
                for(int i=startY; i<endY; i++){
                    for(int j=startX; j<endX; j++){
                        board[i][j] = 1;
                    }
                }
            }
            ArrayList<Integer> ret = new ArrayList<>();
            int areaCount = 0;
            visited = new boolean[M][N];
            for(int i=0; i<M; i++){
                for(int j=0; j<N; j++){
                    if(board[i][j] == 0 && !visited[i][j]){
                        visited[i][j] = true;
                        areaCount++;
                        count = 0;
                        dfs(i,j);
                        //탐색 종료 시점
                        ret.add(count);
                    }
                }
            }
            Collections.sort(ret);
            System.out.println(areaCount);
            for(int i : ret){
                System.out.print(i+" ");
            }
        }

        public static void dfs(int x, int y){
            count++;
            for(int i=0; i<4; i++){
                int x2 = x + dx[i];
                int y2 = y + dy[i];
                if(x2 < 0 || x2 >= M || y2 < 0 || y2 >= N || visited[x2][y2]) continue;
                if(board[x2][y2] == 0){
                    visited[x2][y2] = true;
                    dfs(x2,y2);
                }

            }

        }

}
