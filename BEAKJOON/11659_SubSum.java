import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11659 {
    // 백준 11659 : 구간 합 구하기 4

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N,M;
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        String[] nums = br.readLine().split(" ");
        int[] arr = new int[N+1];
        int sum = 0;
        for(int i=1; i<=N; i++){
            int num = Integer.parseInt(nums[i-1]);
            sum += num;
            arr[i] = sum;
        }

        while(M-- > 0){
            String[] in =  br.readLine().split(" ");
            int i = Integer.parseInt(in[0]);
            int j = Integer.parseInt(in[1]);
            System.out.println(arr[j] - arr[i-1]);
        }
    }
}
