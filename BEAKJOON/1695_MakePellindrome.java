import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1695_MakePellindrome {
    //solution number : 1695 - 팰린드롬 만들기
    static int ret = Integer.MAX_VALUE;
    static int dp[][];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if(isPel(arr)){
            System.out.println(0);
            return;
        }
        // dp[a][b] : a~b까지 팰린드롬 만들 때 끼워 넣어야 하는 최소 개수
        dp = new int[5001][5001];
        for(int i = 0; i < n-1; i++) {
            for(int j = i+1; j < n; j++) {
                cal(arr,i,j); //디피 배열 채워주기
            }
        }
        System.out.println(dp[0][n-1]);
    }

    public static int cal(int[] arr, int left, int right){
        if(dp[left][right] != 0) return dp[left][right]; //이미 방문한 경우 최솟값이 저장되어 있기 때문에 바로 리턴해준다

        if(left>=right){
            dp[left][right]=0;
            return dp[left][right];
        }
        //같다면 끼워주지 않고 한칸씩 포인터를 이동해주기
        if(arr[left]==arr[right]) dp[left][right] = cal(arr, left+1, right-1);
        //다르다면 둘중 하나를 끼워넣고 이동시켜야 하는데 더 작은 것 선택해주기
        else dp[left][right] = Math.min(cal(arr,left+1,right), cal(arr,left,right-1))+1;
        return dp[left][right];

    }
    public static boolean isPel(int[] arr){
        int length = arr.length/2;
        for(int i=0; i<length; i++){
            if(arr[i] != arr[arr.length-1-i]) return false;
        }
        return true;
    }

//    public static void dfs(int[] arr, int left, int right, int count){
//        if(ret < count) return; //가지치기
//        if(left>=right){
//            ret = Math.min(ret,count);
//            return;
//        }
//        if(arr[left] != arr[right]){
//            //왼쪽 맞춰주기
//            dfs(arr,left,right-1,count+1);
//            //오른쪽 맞춰주기
//            dfs(arr,left+1,right,count+1);
//        }else{
//            dfs(arr,left+1,right-1, count);
//        }
//
//    }
}
