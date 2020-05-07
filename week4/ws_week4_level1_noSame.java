import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();

        for(int i = arr.length-1; i >= 0; i--){
            if(stack.empty()){
                stack.push(arr[i]);
            }
            else if(!stack.peek().equals(arr[i])){
                stack.push(arr[i]);
                //System.out.println(stack.push(arr[i]));
            }
        }

        int[] answer = new int[stack.size()];
        int i = 0;
        while(!stack.empty()){
            answer[i++] = (int)stack.pop();
        }

        return answer;
    }
}
