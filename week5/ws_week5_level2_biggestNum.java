import java.util.*;
import java.util.Collections;
class Solution {
    public String solution(int[] numbers) {
        String answer = new String();
        String[] answerArr = new String[numbers.length];
        
        //숫자 일단 문자열로 바꾸기
        for(int i = 0; i < numbers.length; i++){
            answerArr[i] = String.valueOf(numbers[i]);
        }
        
        //내림차순 정렬을 위한 메서드 오버라이드
        Arrays.sort(answerArr, new Comparator<String>(){
            public int compare(String s1, String s2){
                return (s2+s1).compareTo(s1+s2);
            }
        });
        
        //정렬된 배열의 시작이 0이면 0으로 함
        if(answerArr[0].equals("0")){
            return "0";
        }
        else{
            for(int i = 0; i < answerArr.length; i++){
                //System.out.println(answerArr[i]);
                answer += answerArr[i];
            }
        }
        
        return answer;
    }
}