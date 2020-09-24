import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CutLan {
    //sol num : 1654 - 랜선 자르기

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k, N; //k-가지고 있는 랜선 개수, N-만들고 싶은 랜선 수
        String[] strs = br.readLine().split(" ");
        k = Integer.parseInt(strs[0]);
        N = Integer.parseInt(strs[1]);
        int[] arr = new int[k];
        int idx=0;
        while(k-->0){
            arr[idx++] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        //오름차순으로 배열 정렬
        //802
        //743
        //457
        //539

        // 457 -> 539 -> 743 -> 802
        long right = arr[arr.length-1];
        long left = 1;
        while(left<=right) {
            long mid = (right + left) / 2;

            long count = 0;
            for (int i = 0; i < arr.length; i++) {
                count += arr[i] / mid;
            }
            if(count>=N) //너무 랜선이 많이 나왔다면 랜선 길이를 늘려서 개수를 줄여줘야 한다
                left=mid+1;
            else
                right=mid-1; //너무 랜선이 적다면 랜선 길이를 줄여서 개수를 늘려줘야 한다 .
        }

        System.out.println(right);
    }
}
