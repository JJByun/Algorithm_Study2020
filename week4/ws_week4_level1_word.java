import java.lang.String;

class Solution {
    public String solution(String s) {
        String answer = ""; 
        int len = s.length();
        if(s.length() %2 == 0){
            answer += String.valueOf(s.charAt(len/2-1));
            answer += String.valueOf(s.charAt(len/2));
        }
        else if(s.length() % 2 == 1){
            answer += String.valueOf(s.charAt(len/2));
        }
        
        return answer;
    }
}