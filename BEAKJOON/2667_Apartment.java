import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//백준 단지번호 붙이기
public class Apartment {
    static int count = 0; //전체 단지 개수 카운트
    static int aptCount = 0; //아파트 개수 카운트
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] board = new int[n][n];
        List<Integer> ret= new ArrayList<>();
        //board 생성
        for(int i=0; i<n; i++){
            String [] strs = br.readLine().split("");
            for(int j=0; j<n; j++)
                board[i][j] = Integer.parseInt(strs[j]);
        }
        //전체 board를 순회하면서 찾아주기
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 1){
                    count++; //단지 찾음
                    aptCount = 0;
                    dfs(board,i,j);
                    ret.add(aptCount);
                }
            }
        }
        Collections.sort(ret);
        System.out.println(count);
        for(int i : ret)
            System.out.println(i);

//        for(int[] i : board){
//            for(int ii : i){
//                System.out.print(ii);
//            }
//            System.out.println();
//        }
    }
    public static void dfs(int [][] board, int i , int j){
        //아파트를 만남
        aptCount += 1;
        //dfs에 들어왔으니 방문 체크 해주기
        board[i][j] = -1;
        //up
        if(i-1 >= 0 && board[i-1][j] == 1) dfs(board,i-1, j);
        //down
        if(i+1 < board.length && board[i+1][j] == 1) dfs(board, i+1, j);
        //left
        if(j-1 >= 0 && board[i][j-1] == 1) dfs(board,i,j-1);
        //right
        if(j+1 < board[0].length && board[i][j+1] == 1) dfs(board,i,j+1);
    }
    public static void bfs(int [][] board, int i , int j){

    }
}
