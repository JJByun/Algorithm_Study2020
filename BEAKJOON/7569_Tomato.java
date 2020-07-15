import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Base64;
import java.util.LinkedList;
import java.util.Queue;

public class Tomato {
    //solution number :7569
    static int N,M,H;
    static int[][][] board;
    static int[] dy = {0,0,-1,1};
    static int[] dz = {1,-1,0,0};
    static int[] dx = {-1,1};
    static boolean visited[][][];
    static int maxCount = 0;
    static Queue<location> q;
    public static void main(String arsg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        M = size[0]; //가로
        N = size[1]; //세로
        H = size[2]; //높이
        q = new LinkedList<>(); //static queue 생성
        board = new int[H][N][M];
        boolean isEnd = true;
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                int[] boards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for(int k=0; k<M; k++){
                    board[i][j][k] = boards[k];
                    if(boards[k] == 0) //익지 않은 토마토가 하나라도 있으면 종료는 아님
                        isEnd = false;
                }
            }
        }
        //예외처리
        if(isEnd){ //시작부터 모두 익은상태라면 끝내주기
            System.out.println(0);
            return;
        }
        visited = new boolean[H][N][M];
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(board[i][j][k] == 1 && !visited[i][j][k]){
                        q.add(new location(i,j,k,0));
                    }
                }
            }
        }
        bfs();
        //print();
        if(isSearchEnd())
            System.out.println(maxCount);
        else
            System.out.println(-1);
    }
    static boolean isSearchEnd(){
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(board[i][j][k] == 0)
                        return false;
                }
            }
        }
        return true;
    }
    static public void bfs(){
        while(!q.isEmpty()){
            int qSize = q.size();
            //System.out.println("===== q Start =====" + qSize);
            maxCount++;
            for(int n=0; n<qSize; n++){
                location l = q.poll();
                int x = l.x;
                int y = l.y;
                int z = l.z;
                int count = l.count;
                visited[x][y][z] = true;
                //System.out.println("------------");
                //print();
                //상하좌우 봐주기
                for(int i=0; i<4; i++){
                    int y2 = y + dy[i];
                    int z2 = z + dz[i];
                    if(y2 < 0 || y2 >= N || z2 < 0 || z2 >= M || visited[x][y2][z2]) continue;
                    if(board[x][y2][z2] == 0){
                        visited[x][y2][z2] = true;
                        board[x][y2][z2] = 1;
                        q.add(new location(x,y2,z2, count++));
                    }
                }
                //위에칸 아래칸 봐주기
                for(int i=0; i<2; i++){
                    int x2 = x + dx[i];
                    if(x2 < 0 || x2 >= H || visited[x2][y][z]) continue;
                    if(board[x2][y][z] == 0){
                        visited[x2][y][z] = true;
                        board[x2][y][z] = 1;
                        q.add(new location(x2,y,z, count++));
                    }
                }
            }
            if(isSearchEnd())
                break;
        }
    }
    public static class location{
        int x;
        int y;
        int z;
        int count;
        public location(int x, int y, int z, int count){
            this.x = x;
            this.y = y;
            this.z = z;
            this.count = count;
        }
    }
    static void print(){
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    System.out.print(board[i][j][k] +" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
