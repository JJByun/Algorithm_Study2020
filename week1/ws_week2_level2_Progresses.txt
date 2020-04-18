import java.util.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] pro, int[] spd) {
        List<Integer> answerL = new ArrayList<Integer>();
        int[] proDay = new int[pro.length];
        int LPos = 0;
        
        //각 진행도 걸리는 일수 배열 만듬
        for(int i = 0; i < pro.length; i++){
            proDay[i] = 0;
            for(int work = pro[i]; work < 100; work += spd[i]){
                proDay[i]++;
            }
        }
        
        for(int i = 0; i < proDay.length; i++)
            System.out.print("day:"+proDay[i]+" ");
        
        System.out.println();
        
        for(int day = 0; day < proDay.length; day++){
            //마지막날이 아닌 경우 다음날들과 비교
            if(day != proDay.length){
                int count = 1;
                for(int nextDay = day+1; nextDay < proDay.length; nextDay++){
                    if(proDay[day] >= proDay[nextDay]){
                        count++;
                        if(nextDay == proDay.length-1)
                            day = nextDay;
                    }
                    else{
                        day = nextDay-1;
                        break;
                    }
                }
                System.out.println("chekc:"+count);
                answerL.add(LPos, count);
                LPos++;
            }
            //마지막날의 경우
            else{
                answerL.add(LPos, 1);
            }
        }
        
        
        int[] answer = answerL.stream().mapToInt(i->i).toArray();
        for(int i = 0; i<answer.length; i++)
            System.out.print(">"+answer[i]+" ");
        return answer;
    }
}