import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OneTwoThreeAdd {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[]dp = new int[12];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2; //1+1, 2
        dp[3] = 4; //1+2 2+1 1+1+1 3
        for(int i=4; i<12; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        while(num-- > 0){
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}
