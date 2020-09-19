import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class GuitarLesson {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = inputs[0];
        int m = inputs[1]; //m 개로 섹션을 나누어야

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int start=0;
        int end=0;
        for(int i : arr){
            end+=i;
            start = Math.max(start,i);
        }

        while(start <= end){ //이분탐색 시작
            int mid =(start+end)/2; //레코드의 숫자를 중간값 임의로 정해보기
            int sum=0;
            int cnt=0;
            for(int i=0; i<n;i++){
                if(sum+arr[i]>mid){
                    sum=0;
                    cnt++;
                }
                sum+=arr[i];
            }
            if(sum!=0) cnt++;
            if(cnt<=m) end=mid-1;
            else start=mid+1;
        }
        System.out.println(start);
    }
}
