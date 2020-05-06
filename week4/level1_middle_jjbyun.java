public class middle {
    public String solution(String s) {
        String answer = "";

        if(s.length() % 2 == 0){
            //길이가 짝수라면
            int n = s.length()/2;
            answer=s.substring(n-1,n+1);
        }else{
            //길이가 홀수라면
            int n =(int) Math.floor(s.length()/2); //올림해서 가운데로 맞춰주기
            answer = s.substring(n,n+1);
        }
        return answer;
    }
}
