import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2294_Coin2 {
    //soution number : 2294 - 동전 2
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int N = Integer.parseInt(strs[0]);
        int k = Integer.parseInt(strs[1]);
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        //dp[i] = i 원을 만들때 최소로 만들 수 있는 개수
        int[] dp = new int[k+1];
        for(int i=1; i<dp.length; i++){
            dp[i] = 100001;
        }
        for(int i=0; i<arr.length; i++){
            int value = arr[i];
            for(int j=value; j<=k; j++){
                dp[j] = Math.min(dp[j], dp[j-value]+1);
            }
        }
        if(dp[k] == 100001) System.out.println("-1");
        else System.out.println(dp[k]);


    }
}
