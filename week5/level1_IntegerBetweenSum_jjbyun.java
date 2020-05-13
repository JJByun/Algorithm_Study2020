public class IntegerBetweenSum {
    public long solution(int a, int b) {
        long answer = 0;

        if(b > a){ //무조건 a가 더 크게 맞춰주기
            int n = a;
            a = b;
            b = n;
        }

        if(a == b)
            return (long)a;
        else{
            for(int i= b; i<=a; i++){
                answer += i;
            }
        }
        return answer;
    }
}
