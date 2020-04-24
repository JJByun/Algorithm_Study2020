import java.util.Arrays;
import java.util.ArrayList;
import java.util.*;

class Solution {
  public String solution(int n) {
      
      List <Integer> list = new ArrayList<>();
      
      int mod;
      int count = 0;
      int div = 0;
      
      while(true){
          
          if(n < 3){
              
            list.add(n);
            count++;
            break;
              
          }
          
          else{
          
              mod = n%3;
              System.out.println("mod:"+mod);

              if(mod == 0){
                  list.add(4);
                  count++;
              }
              else{
                  list.add(mod);
                  count++;
              }    
              div = n - mod;

              if(mod == 0){

                  div = (div/3) - 1;
                  
                  if(div == 0)
                      break;

                  if(div == 3){
                      list.add(4);
                      count++;
                      break;
                  }
                  else if(div <= 2){
                      list.add(div);
                      count++;
                      break;
                  }
                  else{
                      n = div;
                  }

              }
              else{

                  div = div/3;

                  if(div == 3){
                      list.add(4);
                      count++;
                      break;
                  }
                  else if(div <= 2){
                      list.add(div);
                      count++;
                      break;
                  }
                  else{
                      n = div;
                  }
              }          
          }
      }
      
      String answer = "";
            
      for(int i = count-1; i >= 0; i--){
        System.out.println("list > " + list.get(i));
        answer += Integer.toString(list.get(i));
      }
      
      return answer;
  }
}