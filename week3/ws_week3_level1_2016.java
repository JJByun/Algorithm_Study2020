class Solution {
  public String solution(int a, int b) {
    String answer = "";
    int day = 0;
    int M = a-1;
    
    if(M > 0){
        while( M > 0){
            if(M < 9){
                if(M % 2 == 1){
                    day += 31;
                }
                else{
                    if(M == 2)
                        day += 29;
                    else if(M == 8)
                        day += 31;
                    else
                        day += 30;
                }
            }
            else if(M >= 9){
                if(M % 2 == 1)
                    day += 30;
                else
                    day += 31;
            }
            M--;
        }
    }
    
    day += b;
    
    switch (day%7){
        case 1:
            answer = "FRI";
            break;
        case 2:
            answer = "SAT";
            break;
        case 3:
            answer = "SUN";
            break;
        case 4:
            answer = "MON";
            break;
        case 5:
            answer = "TUE";
            break;
        case 6:
            answer = "WED";
            break;
        case 0:
            answer = "THU";
            break;
    }
      return answer;
  }
}