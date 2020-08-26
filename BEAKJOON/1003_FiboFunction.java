import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FiboFunction {
    //solution number : 1003

    static int[] dp1 = new int[50]; //배열의 값은 0이 호출되는 개수 저장
    static int[] dp2 = new int[50]; //배열의 값은 1이 호출되는 개수 저장
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp1[0] = 1;
        dp1[1] = 0;
        dp1[2] = 1;
        dp2[0] = 0;
        dp2[1] = 1;
        dp2[2] = 1;
        //배열 40까지 채우기
        for(int i=3; i<=40 ;i++){
            dp1[i] = dp1[i-1] + dp1[i-2];
            dp2[i] = dp2[i-1] + dp2[i-2];
        }
        while(n-- > 0){
            int num = Integer.parseInt(br.readLine());
            System.out.println(dp1[num]+" "+dp2[num]);
        }
    }

}