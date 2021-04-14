import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_2437_저울 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        int min = 1;

        //누적합을 구해서 답 찾기
        //예를들어 1 2 3 4 라고 한다면
        // 1+2 인 3까지 누적합으로 구할수 있는 수는 1, 2, 3
        // 그 다음인 3을 더하면 누적합은 6인데, 이떄까지 구할 수 있는 수는 1~6이 된다
        // 왜냐하면 3까지는 구할 수 있다는것이 증명 됐으니까 4 5 6 은 이전꺼에서 +3을 하면 다 구할 수 있게 되니까
        // 근데 만약에 더했는데 이미 누적합보다 커진다면 그 수가 가장 작은 누적합 값이 된다.
        for(int i=0; i<N; i++){
            if(min < arr[i]) break;
            min += arr[i];
        }
        System.out.println(min);
    }
}
