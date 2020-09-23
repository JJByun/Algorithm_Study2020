import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WIFI {
    public static void main(String args[]) throws IOException {
        int N; int C; //집 개수, 공유기 개수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        N = inputs[0];
        C = inputs[1];
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        //2분탐색
        // 전제조건: 오름차순 정렬
        //l=0 r = size-1 로 인덱스 초기화
        //mid값을 추출하려 그 값이 원하는 값인지 체크
        //mid 보다 값이 작다면 right=mid-1 세팅
        //mid 보다 값이 크다면 left=mid+1 세팅

        //풀이 설
        //특정 간격을 기준으로 가능한 위치에 공유기를 설치한다.
        //설치한 후에는 다음과 판단한다.
        //공유기 수가 더 설치되어야 한다면, 간격을 줄인다.
        // 공유기 수를 줄여야한다면, 간격을 늘린다

        int l = 1; //공유기 사이의 인접한 거리가 최소
        int r = arr[N-1]-arr[0]; //공유기 사이의 인접한 거리가 최대
        int d =0;
        int ans=0;

        while(l<=r){
            int mid=(l+r)/2;
            int start=arr[0]; //0번쨰 값 받기
            int cnt=1;

            //간격 d를 기준으로 공유기 설치
            for(int i=1; i<N; i++){
                d=arr[i]-start;
                if(mid<=d){
                    cnt++;
                    start=arr[i];
                }
            }
            if(cnt >=C){
                //공유기 수를 줄여야 한다 ->간격 넓히기
                ans=mid;
                l=mid+1;
            }else{
                //공유기를 더 설치해야 한다 -> 간격 좁히기
                r=mid-1;
            }
        }
        System.out.println(ans);

    }
}
