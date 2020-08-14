import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class StringCut {
    //solution number : 2866
    static int r;
    static int c;
    //O(n^2) 까지 가능
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] vals = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        r = vals[0];
        c = vals[1];
        char[][] board = new char[r][c];
        for(int i=0; i<r; i++){
            board[i] = br.readLine().toCharArray();
        }
        //일단은 string으로 만들어주기
        String[] strs = new String[c];
        for(int i=0; i<c; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<r; j++){
                sb.append(board[j][i]);
            }
            strs[i] = sb.toString();
        }
        //바이너리 서치로 문자를 잘랐을때 최대로 중복이 안되는 값 찾아주기
        // mid = (front + rear)/ 2
        // 만약 mid까지 했을 때 중복이 발생하면 mid 미만의 값들은 안되기 때문에 찾는 횟수를 log2(n)으로 줄일 수 있다.
        int front = 0;
        int rear =  r-1;
        int mid = 0;
        int ans = 0;
        while(true){
            if(front > rear) break;
            mid = (front + rear) / 2;

            if(isSame(board, mid)){ //중복이 있다면 mid를 위로
                ans = mid - 1;
                rear = mid -1;
            }else{
                ans = mid;
                front = mid + 1;
            }
        }
        System.out.println(ans);

    }
    public static boolean isSame(char[][] board, int mid){
        HashMap<String,Integer> map = new HashMap<>();
        String word = "";
        for(int j=0; j<board[0].length; j++){ //col
            word = "";
            for(int i=mid; i<board.length;i++){ //row
                word += board[i][j];
            }
            if(map.get(word) != null)
                return true;
            map.put(word,0);
        }
        return false;
    }
}
