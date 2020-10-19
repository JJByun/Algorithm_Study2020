import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1992_QuadTree {
    //solution number : 1992 - 쿼드트리
    static int N;
    static int[][] board;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //N은 2의 배수이다
        board = new int[N][N];

        for(int i=0; i<N; i++){
            String[] arr = br.readLine().split("");
            for(int j=0; j<N; j++){
                board[i][j] = Integer.parseInt(arr[j]);
            }
        }
        divide(0,0, N);
    }
    private static int check(int row, int col, int n) { // 해당 범위가 다 같은지 체크
        int std = board[row][col];
        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + n; j++) {
                if (std != board[i][j]) {
                    return -1;
                }
            }
        }
        return std;
    }
    static void divide(int x,int y, int n){
        int m = check(x,y,n);
        if(m != -1){
            System.out.print(m);
        }else{
            System.out.print("(");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    divide(x + n/2 * i, y + n/2 * j, n/2); //분할정복 코드
                }
            }
            System.out.print(")");
        }
    }
}
