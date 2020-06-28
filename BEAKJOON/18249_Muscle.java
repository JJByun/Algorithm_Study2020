import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Muscle {
    //Solution Number: 18249

    public static int count = 0;
    public static int loss;
    static final int MAX = 500;
    public static void main(String args[]) throws IOException {
        //순열로 순서 구하기
        //배열에 각각 값 넣어주기 ( index : key, value : weight)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int k = Integer.parseInt(strs[1]);
        loss = k; //무게 감소 변수에 넣
        String[] inputs = br.readLine().split(" ");
        int [] weights = new int[n]; //무게 저장 배열

        if(n == 1){ //운동 키트가 하나인 경우 예외 처리
            int w = Integer.parseInt(inputs[0]);
            if(w >= k){
                System.out.println(1);
                return;
            }
            else{
                System.out.println(0);
                return;
            }

        }
        //무게 넣어주기
        for(int i=0; i<weights.length; i++){
            weights[i] = Integer.parseInt(inputs[i]);
        }
        dfs(weights,n,0, new boolean[n] , new int[n]);

        System.out.println(count);
    }
    public static void dfs(int[] arr, int n , int depth, boolean[] visited,int[] ret){
        if(n == depth){
            boolean isOver = false;
            int cur = 500;
            for(int i: ret){
                cur += i;
                cur -= loss;
                if(cur < MAX){
                    isOver = true;
                    break;
                }
            }
            if(!isOver)
                count++;
            return;
        }
        for(int i=0; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                ret[depth] = arr[i];
                dfs(arr, n, depth+1, visited, ret);
                visited[i] = false; //재귀 끝나고 다음 재귀를 위해 초기
            }
        }
    }
}
