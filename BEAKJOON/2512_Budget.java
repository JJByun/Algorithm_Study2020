import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;

public class BOJ_2512_Budget {
    //solution number : 2512 - 예산
    //이분탐색 문제

    //이분탐색은 O(N^2) -> O(NlogN)으로 줄이는데 효과적이다
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.parseInt(br.readLine());

        //mid -> 상한액
        long left = 0; //최솟값을 0으로 잡아야 통과 된다.
        long right = Integer.MIN_VALUE;
        for(int i : arr){
            //left = Math.min(left,i);
            right= Math.max(right,i);
        }

        while(left<=right){
            long mid = (left+right)/2;
            long sum=0;

            for(int i=0; i<arr.length; i++){
                if(arr[i] > mid)
                    sum+=mid;
                else
                    sum+=arr[i];
            }
            if(sum <= M){ //너무 작은 경우 상한액을 늘려줘야 한다.
                left = mid+1;
            }else{//상한액을 너무 크게 잡은 경우 줄여줘야 한다.
                right=mid-1;
            }
        }
        System.out.println(right);
    }
}
