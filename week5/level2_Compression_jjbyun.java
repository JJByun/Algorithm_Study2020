import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Compression {
    public int solution(String s) {
        if(s.length()==1)
            return 1;
        int answer = 0;
        String[] strs = s.split("");
        Stack<String> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>(); //정답 개수를 담을 배열
        ArrayList<String> strList = new ArrayList<>();


        for (int n = 1; n <= strs.length / 2; n++) { //문자열의 개수 / 2 만큼 묶어서 압축 확인. 그 이상 묶으면 압축이 진행되지 않음
            String preStr = "";
            String postStr = "";

            //스택, 리스트 초기화
            if (!stack.isEmpty())
                stack.clear();
            if (!strList.isEmpty())
                strList.clear();
            for (String ts : strs) {
                strList.add(ts); //List에 넣어주기
            }

            int count = 1;
            while (strList.size() > n) { //list의 사이즈가 압축 가능할때 까지 반복
                //먼저 묶을 개수만큼 가져와주기
                preStr="";
                postStr="";
                for (int i = 0; i < n; i++) {
                    preStr += strList.get(0);
                    strList.remove(0); //pre에 넣을 문자열은 추출 후 제거해주기
                }
                if(strList.size() < n){ //n개씩 압축하는데 압축하는 크기보다 뒤에 남은게 작다면 더이상 압축되지 않음
                    if(count > 1){
                        if(count >= 10){ //count 개수가 10개가 넘어가면 하나씩 잘라서 각 자릿수 숫자를 넣어줘야 한다
                            String strCount = Integer.toString(count);
                            for(int i=0; i< strCount.length(); i++ ){
                                stack.push(strCount.valueOf(i)); //각 자릿수의 값을 넣어주기
                            }
                        }else{
                            stack.push(Integer.toString(count));
                        }
                    }

                    String[] tmpStr = preStr.split("");
                    for (String ss : tmpStr) {
                        stack.push(ss);
                    }
                    for(String ss : strList)
                        stack.push(ss);
                    break; //끝내기 위해서 탈출
                }
                for (int j = 0; j < n; j++) {
                    postStr += strList.get(j); //뒤의 문자열 추출
                }
                if (preStr.equals(postStr)) { //같은 경우 개수 카운트하고 넘기기
                    count++;
                } else { //pre와 post가 같지 않은 경우 압축된것이 있는지 판단
                    if (count > 1) { //압축된것이 있는 경우
                        if( count >= 10){
                            String strCount = Integer.toString(count);
                            for(int i=0; i< strCount.length(); i++ ){
                                stack.push(strCount.valueOf(i));
                            }
                        }else{
                            stack.push(Integer.toString(count));
                        }

                        String[] tmpStr = preStr.split("");
                        for (String ss : tmpStr) {
                            stack.push(ss);
                        }
                        count = 1 ; //count 초기화
                    } else { //압축이 안된경우우
                        String[] tmpStr = preStr.split("");
                        for (String ss : tmpStr) {
                            stack.push(ss);
                        }
                        count = 1; //count 초기화
                    }
                }

                if(strList.size() == n){
                    if (count > 1) { //압축된것이 있는 경우
                        if( count >= 10){
                            String strCount = Integer.toString(count);
                            for(int i=0; i< strCount.length(); i++ ){
                                stack.push(strCount.valueOf(i));
                            }
                        }else{
                            stack.push(Integer.toString(count));
                        }

                        String[] tmpStr = preStr.split("");
                        for (String ss : tmpStr) {
                            stack.push(ss);
                        }
                        count = 1 ; //count 초기화
                    } else { //압축이 안된경우우
                        String[] tmpStr = preStr.split("");
                        for (String ss : tmpStr) {
                            stack.push(ss);
                        }
                        count = 1; //count 초기화
                    }
                }

            }
            //System.out.print(n + "개씩 묶음:");
            //System.out.println(stack);
            list.add(stack.size());
        }
        //System.out.println(list);
        answer = Collections.min(list); //최대값 리턴
        return answer;
    }

//    public static void main(String args[]){
//        Compression c = new Compression();
//        //System.out.println(c.solution("aabbaccc"));
//        //System.out.println(c.solution("ababcdcdababcdcd"));
//        //System.out.println(c.solution("abcabcdede"));
//        //System.out.print(c.solution("abcabcabcabcdededededede"));
//        System.out.print(c.solution("xababcdcdababcdcd"));
//    }
}
