import java.util.*;

class Solutions {
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String[] skill_order =skill.split(""); //배열로 스킬 순서 받기
        boolean b =true;
        for(String s:skill_trees){
            //스킬트리를 배우는것을 반대로 생각해보기!
            for(int i=skill_order.length-1; i>=0; i--){
                b=true;
                int last = s.indexOf(skill_order[i]); //스킬트리의 마지막 위치 찾기 
                //스킬트리의 마지막이 존재한다면 그 앞의 스킬 위치 찾기
                if(last != -1 && i != 0){
                    int pre_last = s.indexOf(skill_order[i-1]);
                    if(pre_last == -1 || pre_last > last){ //선행 스킬이 없거나 선행 스킬보다 후행 스킬이 먼저 나올 경우 ->불가능
                        b=false;
                        break;

                    }
                }
            }
            //b가 true라면 가능한것임
            if(b==true)
                answer++;

        }
        return answer;
    }

}