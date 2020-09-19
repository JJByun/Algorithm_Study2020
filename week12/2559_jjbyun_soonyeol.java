import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sooyeaol {
    // sol num : 2559 - 수열
    // 백준 문제

    public static void main(String args[]) throws IOException {
        //투포인터 알고리즘 적용 조건
        // 1. 연속된 숫자의 합이나 부분합을 구한다
        // 2. 시간복잡도를 O(N+M)으로 구해야한다. N: 배열의 크기, M: 부분합의 크기
        // 구현
        // 투포인터 알고리즘
        // 1. 시작점(start)과 끝점(end)이 첫번째 원소의 인덱스(0)를 가리키도록 한다.
        // 2. 현재 부분 합이 M과 같다면, 카운트 한다.
        // 3. 현재 부분 합이 M보다 작거나 같다면, end를 1증가 시킨다.
        // 4. 현재 부분 합이 M보다 이상이거나 OR end=n 이면, start를 1증가 시킨다.
        // 5. 모든 경우를 확인할 때까지 2번부터 4번까지의 과정을 반복한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = inputs[0];
        int m = inputs[1];
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int start=0;
        int end=0;
        int sum=0;
        int ret=Integer.MIN_VALUE;
        int cnt=0;
        while(true){
            if(cnt >= m){
                sum -= arr[start++]; //부분합이 M 보다 크거나 같다면 start를 하나 올려서 부분합에서 빼주기
                cnt--;
            }
            else if(end == n) break; //부분합을 만들면서 왔기 때문에, end가 n의 크기만큼 오게됐다면 더이상 수를 만들 수 없음
            else if(cnt < m){
                sum += arr[end++]; //M보다 작다면 end 인덱스를 하나 올려서 부분합 더해주기
                cnt++;
            }

            if(cnt == m) ret = Math.max(ret,sum); //같은 순간 count를 증가시킨다.
        }
        System.out.println(ret);
    }
}
