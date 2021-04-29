import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_12738_가장긴증가하는수열3 {
    // 가장 긴 증가하는 부분 수열 3
    // LIS - DP 문제
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp;
    static StringTokenizer stz;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        stz = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(stz.nextToken());
        dp = new int[N+1];
        dp[0] = arr[0];
        int j=0;
        for(int i=1; i<N; i++){
            //가장 큰 값보다 더 크다면 다음 dp 배열에 채워주기
            if(arr[i] > dp[j]){
                dp[++j] = arr[i];
            }else{ //작거나 같다면 파라매트릭서치로 해당 값보다 작은값중 첫번째 값 찾아주기
                int ans = lower_bound(j+1, arr[i]);
                dp[ans] = arr[i];
            }
        }
        System.out.println(j+1);
    }
    static int lower_bound(int size, int target){
        int left,right,mid;
        left = 0;
        right = size-1;
        while(left < right){
            mid = (left+right)/2;
            if(target <= dp[mid]){ //값이 더 크거나 같으면
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return right;
    }
}
