import java.util.*;
public class SS {
    public static int[] solution(int[] heights) {
        final int arrSize = heights.length;
        int[] answer = new int[arrSize];

        Stack<Integer> stack = new Stack<>();

        for(int i : heights){
            stack.push(i); //먼저 스택에 넣어주기
        }

        for(int i=0; i<arrSize-1; i++){
            int num = stack.pop();

            Stack<Integer> tmpStack =(Stack<Integer>) stack.clone(); //배열 복사(clone으로 해야지 얕은 복사가 됨)

            while(!tmpStack.isEmpty()){
                int n2 = tmpStack.pop();
                answer[arrSize-1-i]=0; //일단 0이라고 초기화해주기
                if(n2 > num) {//왼쪽에 있는 탑이 더 높다면
                    answer[arrSize-1-i]=tmpStack.size()+1;
                    break;
                }

            }
        }
        for(int i:answer){
            System.out.println(i);
        }

        return answer;
    }

    public static void main(String args[]){
        int[] i= {6,9,5,7,4};
        solution(i);
    }
}
