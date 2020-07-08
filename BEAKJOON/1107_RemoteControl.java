import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RemoteControl {
    //Solution number : 1107
    static int[] numbers;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        int retTarget = Integer.parseInt(target);
        if(retTarget == 100){ //100인 경우 바로 0 return
            System.out.println(0);
            return;
        }
        int brokenCount = Integer.parseInt(br.readLine());
        if(brokenCount == 10){ //모두 고장 이면 +,- 밖에 안됨
            System.out.println(Math.abs(retTarget - 100));
            return;
        }else if(brokenCount == 0){ //바로 이동하면 됨
            //여기서 런타임 에러 발생. 고장난게 없는 경우 다음에 읽을 것이 안생김
            System.out.println(Math.min(Math.abs(retTarget - 100)/* +,- 만 이용해서 이동*/ , Integer.toString(retTarget).length() /* 리모콘 숫자 이용*/));
            return;
        }
        int[] broken = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        numbers = new int[10];
        for(int i: broken){
            numbers[i] = -1; //고장난 것은 배열에 -1로 체크
        }
        int i = 0;
        String pressNum = "";
        while(true){
            int n1 = retTarget - i;
            int n2 = retTarget + i;
            if(n1 >= 0){
                if(isPossible(n1)){
                    pressNum = Integer.toString(n1);
                    break;
                }
            }
            if(n2 <= Integer.MAX_VALUE){ //Integer가 MaxValue를 벗어나면 다음은 -1로 이동됨. 방지
                if(isPossible(n2)){
                    pressNum = Integer.toString(n2);
                    break;
                }
            }
            i++;
        }

        System.out.println(Math.min(Math.abs(retTarget - 100)/* +,- 만 이용해서 이동*/ , pressNum.length() + i /* 리모콘 숫자 이용*/));
    }
    public static boolean isPossible(int n){ //리모콘 숫자로 이동 가능한지 판단
        if(n==0)
            if(numbers[0] != -1)
                return true;
            else
                return false;
        while(n != 0){
            int k = n % 10;
            n /= 10;
            if(numbers[k] == -1)
                return false;

        }
        return true;
    }
}
