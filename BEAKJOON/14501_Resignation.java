import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Resignation {
    //백준 문제
    //solution number : 14501 - 퇴사
    static int N,max = Integer.MIN_VALUE;
    static int P[];
    static int T[];
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        P = new int[N];
        T = new int[N];

        for(int i=0;i<N;i++) {
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            T[i] = tmp[0];
            P[i] = tmp[1];
        }
        cal(0,0);
        System.out.println(max);
    }

    static void cal(int day, int money) {
        if(day>=N) { //들어왔는데 이미 더 크다면 더이상 추가하지 못하고 리턴
            max = Math.max(max, money);
            return;
        }
        if(day+T[day]<=N) //현재 날+걸리는 작업 시간이 퇴사 전이라면
            cal(day+T[day],money+P[day]); //현재 날짜를 더해주고 다음 일 진행하기
        cal(day+1,money);//그냥 오늘 스킵하고 내일 일 시작하기
    }
}
