import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CutTree {
    //solution number : 2805 - 나무 자르기

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N,M; //나무 수, 가져가야 하는 길이
        String[] strs = br.readLine().split(" ");
        N = Integer.parseInt(strs[0]);
        M = Integer.parseInt(strs[1]);
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        //mid = 가져가야 하는 높이의 최댓 값
        long left=1;
        long right=0; //나무 길이 최댓값 저장
        for(int i : arr)
            right = Math.max(i,right);

        while(left<=right){
            long mid = (left+right)/2;C
            long sum=0;
            // mid 값으로 값 체크해주기
            for(int i=0; i<arr.length;i++) {
                if(arr[i]<=mid) continue;
                sum+=arr[i]-mid;
            }
            //조건 검사
            if(sum >= M) // 너무 많이 가져갔으면 높이를 올려서 더 적게 가져가게 만든다
                left = mid+1;
            else // 적게 가져갔으면 높이를 줄여서 더 가져가게 만든다.
                right =mid-1;
        }
        System.out.println(right);
    }
}
