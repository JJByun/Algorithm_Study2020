import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumberCount {
    // solution number : 2003
    public static void main(String args[]) throws IOException {
        //시간복잡도가 O(n)으로 만들어야함.
        //제한시간이 0.5 초 이므로 10,000번 계산만 가능
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N,M;
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = inputs[0];
        M = inputs[1];
        int count = 0;
        int sum = 0;
        int start = 0;
        int end = 0;
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        //무조건 증가하는 방향으로 포인터를 설정하기.
        //투포인터 알고리즘 사용
        while(true){
            if(sum >= M) sum -= nums[start++]; //부분합이 M 보다 크거나 같다면 start를 하나 올려서 부분합에서 빼주기
            else if(end == N) break; //부분합을 만들면서 왔기 때문에, end가 n의 크기만큼 오게됐다면 더이상 수를 만들 수 없음
            else if(sum < M) sum += nums[end++]; //M보다 작다면 end 인덱스를 하나 올려서 부분합 더해주기

            if(sum == M) count++;
        }
        System.out.println(count);

    }

    // 투포인터 알고리즘
    // 1. 시작점(start)과 끝점(end)이 첫번째 원소의 인덱스(0)를 가리키도록 한다.
    // 2. 현재 부분 합이 M과 같다면, 카운트 한다.
    // 3. 현재 부분 합이 M보다 작거나 같다면, end를 1증가 시킨다.
    // 4. 현재 부분 합이 M보다 이상이거나 OR end=n 이면, start를 1증가 시킨다.
    // 5. 모든 경우를 확인할 때까지 2번부터 4번까지의 과정을 반복한다.
}
