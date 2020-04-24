import java.util.*;

public class stick {
    public int solution(String arrangement) {
        int answer = 0;
        int left, right =0;
        Stack<Integer> stack = new Stack<>();
        String[] strs = arrangement.split("");
        ArrayList <Integer> list = new ArrayList<>();
        //1. 왼쪽 괄호와 오른쪽괄호를 카운트 해서 개수가 같아질때가 계산해줘야하는 시기
        //2.왼쪽괄호 다음 바로 오른쪽 괄호가 나오면 그것은 레이저
        for(String s:strs){
            if(s.equals("(")) //왼쪽괄호라면 일단 넣어준다
                stack.push(1);
            else if(s.equals(")") && stack.peek() == 1){ //오른쪽 괄호인데 왼쪽이 1인경우 레이저임
                //pop 해준다.
                stack.pop();
                stack.push(0); //레이저 표시 넣어주기
            }else if((s.equals(")") && stack.peek() == 0) || s.equals(")") && stack.peek() == -1){
                stack.push(-1); //오른쪽 괄호 넣어주기
            }
        }
        //다 넣었을 경우 스택은 011100-110-10-1-110-1이 들어있어야 함
        //System.out.println(stack);

        //left와 right 개수를 카운트 해주면서 같다면 레이저 개수를 카운트 해줘야 함

        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        int first, last =0;
        while(list.contains(1)){
            for(int i=0; i<list.size();i++){
                if(list.get(i)==1){ //괄호 끝이 나온다면
                    int countLaser=0;
                    first =i;
                    while(list.get(i-1)==0){ //해당 위치 반대부터 0 개수 카운트
                        countLaser++;
                        i--;
                    }
                    last = i-1;
                    answer += countLaser+1; //잘라지는 개수는 레이저 개수 + 1
                    list.remove(first);
                    list.remove(last); //카운트가 끝난 막대기 삭제
                    break;  //다시 처음부터 찾아주기
                }
            }
        }

        return answer;
    }
}
