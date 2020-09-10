import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class BalanceWorld {
    //solution number: 4949
    //균형잡힌 세상 문제
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String str = br.readLine();
            if(str.equals(".")) break;

            Stack<Character> stack = new Stack<>();
            boolean isStop = false;
            for(int i=0; i<str.length(); i++){
                char c = str.charAt(i);
                if(c == '(')
                    stack.push('(');
                else if(c == '[')
                    stack.push('[');
                else if(c == ')'){
                    if(stack.isEmpty()){
                        System.out.println("no");
                        isStop = true;
                        break;
                    }
                    if(stack.peek() != '('){
                        System.out.println("no");
                        isStop = true;
                        break;
                    }else
                        stack.pop();
                }else if(c == ']'){
                    if(stack.isEmpty()){
                        System.out.println("no");
                        isStop = true;
                        break;
                    }
                    if(stack.peek() != '['){
                        System.out.println("no");
                        isStop = true;
                        break;
                    }else
                        stack.pop();
                }else continue;
            }
            if(isStop) continue;
            if(!stack.isEmpty()) System.out.println("no");
            else System.out.println("yes");
        }
    }
}
