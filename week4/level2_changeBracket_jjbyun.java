import java.util.*;

public class changeBracket {
    String answer = "";
    Stack<Character> stack = new Stack<>();
    public String solution(String p) {

        boolean isRight = true; //균형 잡힌 괄호 문자열인지 판단
        isRight = isBalance(p);

        if(isRight){
            //올바른 괄호 문자열인 경우 그냥 리턴
            return p;
        }else{
            int cutIndex = divideUV(p);
            String u =p.substring(0,cutIndex);
            String v=p.substring(cutIndex,p.length());

            if(isBalance(u)){ //u가 올바른 괄호 문자열이라면 v만 올바르게 만들어주면 됨
                answer = u+changeUV(v);
            }else{ //u가 올바른 문자열이 아니라면 다시 나눈다음 바꿔야한다
                String str = "("+changeUV(v)+")";
                u = u.substring(1,u.length()-1); //4-4 첫번째와 마지막 문자 제거
                u = reverseString(u); //나머지 문자열의 괄호 방향을 뒤집기
                answer = str + u;
            }
            //여기까지 u,v 구하기
            System.out.println("u "+u);
            System.out.println("v "+v);
        }
        return answer;
    }

    public boolean isBalance(String p){
        boolean b=true;
        stack.clear();
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i)=='('){
                stack.push('(');
                continue;
            }else{
                if(!stack.isEmpty()){
                    stack.pop(); // ( 하나 제거해주기-짝 맞추기
                }else{
                    b=false;
                    break;
                }
            }
        }
        return b;
    }

    public String changeUV(String w){
        String str="";
        if(w.length() == 0)
            return "";

        int cutIndex = divideUV(w); //잘라야하는 위치 얻기
        String u = w.substring(0, cutIndex);
        String v = w.substring(cutIndex, w.length());

        if(isBalance(u)) { //u가 올바른 괄호 문자열이라면 v만 올바르게 만들어주면 됨
            str= u + changeUV(v);
        }else {
            String temp = '(' + changeUV(v) + ')';
            u = u.substring(1, u.length()-1); //4-4 첫번째와 마지막 문자 제거
            u = reverseString(u);//나머지 문자열의 괄호 방향을 뒤집기
            str= temp + u;
        }

        return str;
    }

    public int divideUV(String p){
        String u="";
        String v="";
        int i=0;
        int n=0;
        while(true){ //0이 되는순간 균형잡힌 괄호이므로 탈출
            if(p.charAt(i)=='('){
                n++; // (인 경우 1 증가
                u+=p.charAt(i);
            }else if(p.charAt(i)==')'){
                n--; //)인 경우 1 감소
                u+=p.charAt(i);
            }
            i++;
            if(i!=0 && n==0)
                break;
        }
        return i;
    }

    public String reverseString(String s){
        String res="";
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) == ')') {
                res+="(";
            }else
                res+=")";
        }
        return res;
    }
}
