import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Cheez {
    // solution number : 2636
    static int N,M;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static ArrayList<Integer> retArr;
    static int rest = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = size[0];
        M = size[1];
        //board 만들기
       board = new int[N+10][M+10];
       retArr = new ArrayList<>();
       for(int i=0; i<N; i++){
           int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
           for(int j=0; j<M; j++){
               board[i][j] = input[j];
           }
       }
       int count = 0;
       clear();
       while(!isEnd()){
           count++;
           bfs(new Dot(0,0));
           melt();
           clear();
       }
       System.out.println(count);
       System.out.println(retArr.get(retArr.size()-2));

    }
    public static void bfs(Dot firstNode){
        visited = new boolean[N+10][M+10];
        Queue<Dot> q = new LinkedList<>();
        q.add(firstNode);
        board[firstNode.x][firstNode.y] = 2;
        visited[firstNode.x][firstNode.y] = true;
        while(!q.isEmpty()){
            Dot node = q.poll();
            int x = node.x;
            int y = node.y;
            for(int i=0; i<4; i++){
                int x2 = x + dx[i];
                int y2 = y + dy[i];
                if(x2 < 0 || x2 >= N || y2 < 0 || y2 >= M) continue;
                if(!visited[x2][y2] && board[x2][y2] == 0){
                    visited[x2][y2] = true;
                    board[x2][y2] = 2;
                    q.add(new Dot(x2,y2));
                }
            }
        }
    }
    public static void clear(){
        rest = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++)
                if(board[i][j] == 2)
                    board[i][j] = 0;
                else if(board[i][j] == 1)
                    rest++;
        }
        retArr.add(rest);
    }
    public static void melt(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j] == 1){
                    if(board[i-1][j] == 2 || board[i+1][j] == 2 || board[i][j-1] == 2 || board[i][j+1] == 2)
                        board[i][j] = 0;
                }
            }
        }
    }
//    public static void print(){
//        for(int i=0; i<N; i++){
//            for(int j=0; j<M; j++){
//                System.out.print(board[i][j]+" ");
//            }
//            System.out.println();
//        }
//    }
    public static boolean isEnd(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++)
                if(board[i][j] != 0)
                    return false;
        }
        return true;
    }
    public static class Dot{
        int x;
        int y;
        public Dot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
