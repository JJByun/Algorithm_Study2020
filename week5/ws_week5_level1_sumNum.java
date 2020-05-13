class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        if(a==b)
            answer = a;
        else{
            int big = a > b ? a : b;
            int sml = a < b ? a : b;
        
            while(sml <= big){
                answer += sml;
                sml++;
            }
        }
        return answer;
    }
}