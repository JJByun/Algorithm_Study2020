import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Puyo {
    //solution number : 11559
    static final int N = 12;
    static final int M = 6;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static char[][] board;
    static int count = 0;
    static int bombCount;
    static boolean[][] visited;
    public static void main(String args[]) throws IOException {
        //board 생성
        board = new char[N][M];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int n=0; n<str.length();n++){
                board[i][n] = str.charAt(n);
            }
        }
        //뿌시기 시작하기
        boolean isGo = true;
        while(isGo){
            count++;
            isGo = false;
            visited = new boolean[N][M];
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(board[i][j] != '.' && !visited[i][j]){ //색이라면
                        bombCount = 0;
                        char color = board[i][j];
                        board[i][j] = 'T';
                        dfs(color,i,j);
                        //탐색 완료
                        if(bombCount >= 4)
                            isGo = true;
                        clear(bombCount, color);
                    }
                }
            }
            down();
            //print();
        }
        System.out.println(count-1);


    }
    //중력에의해 색깔 내려주기
    static void down(){
        for(int i=0; i<M; i++){
            for(int j=N-1; j>=0 ;j--){
                if(board[j][i] =='.'){
                    int n = j-1;
                    while(n>=0){
                        if(board[n][i] != '.') {
                            board[j][i] = board[n][i];
                            board[n][i] = '.';
                            break;
                        }
                        n--;
                    }
                }
            }
        }
    }
    static void dfs(char color,int x, int y){
        bombCount++;
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int x2 = x + dx[i];
            int y2 = y + dy[i];
            if(x2 < 0 || x2 >=N || y2 < 0 || y2 >= M || visited[x2][y2]) continue; //넘기기
            if(board[x2][y2] == color){
                board[x2][y2] = 'T'; //임시로 T로 바꿔주고 bombCount가 4이상일 경우만 '.'로 바꾸고 아니면 다시 되돌려주기
                dfs(color,x2,y2);
            }
        }

    }

    static void clear(int bombCount, char color){
        if(bombCount >= 4){
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(board[i][j] == 'T')
                        board[i][j] = '.';
                }
            }
        }else{
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(board[i][j] == 'T')
                        board[i][j] = color;
                }
            }
        }

    }
    static void print(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
