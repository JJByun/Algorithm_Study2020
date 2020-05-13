public class CountPY {
    boolean solution(String s) {
        boolean answer = true;
        s = s.toUpperCase();
        int n =0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'P')
                n++;
            else if(s.charAt(i) == 'Y')
                n--;
        }
        if(n==0)
            return answer;
        else
            answer = false;
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        //System.out.println("Hello Java");

        return answer;
    }
}
