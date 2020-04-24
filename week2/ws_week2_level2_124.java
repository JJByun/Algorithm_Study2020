import java.util.Arrays;
import java.util.ArrayList;
import java.util.*;

class Solution {
  public String solution(int n) {

      List <Integer> list = new ArrayList<>();

      String answer = "";
      int mod;
      int count = 0;
      int div = 0;

      while(true){

          count++;

          if(n < 3){

            list.add(n);
            break;

          }

          else{
              //3진수화
              mod = n%3;

              //0->4 나머지는 그대로
              if(mod == 0){
                  list.add(4);
              }
              else{
                  list.add(mod);
              }

              //모드값만큼 빼준다
              div = n - mod;

              //앞자리가 바뀌기 전의 마지막 수인 경우
              if(mod == 0){
                  div = (div/3) - 1;
              }
              //아닌경우
              else{
                  div = div/3;
              }

              //줄어든 값으로 계속 반복
              if(div == 0)
                  break;
              else{
                  n = div;
              }

          }
      }

      for(int i = count-1; i >= 0; i--){
        answer += Integer.toString(list.get(i));
      }

      return answer;
  }
}
