class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        // 5개  1 2 3 4 5 
        // 8개  2 1 2 3 2 4 2 5
        // 10개 3 3 1 1 2 2 4 4 5 5 
        
        int[] A = {1,2,3,4,5};
        int[] B = {2,1,2,3,2,4,2,5};
        int[] C = {3,3,1,1,2,2,4,4,5,5};
        int[] ABC = {0,0,0}; 
        int n = 0;
        
        //정답개수체크
        while(n < answers.length){
            if(answers[n] == A[n%5])
                ABC[0]++;
            if(answers[n] == B[n%8])
                ABC[1]++;
            if(answers[n] == C[n%10])
                ABC[2]++;
            n++;
        }
        
        int max = 0;
        int same = 0;
        int diff = 0;
        
        //더맞은경우, 같은경우, 적은경우
        for(int i = 0; i < ABC.length; i++){
            if(ABC[max] < ABC[i]){
                //새로 최대값을 찾았으므로 same 초기화
                max = i;
                same = 1;
            }
            else if(ABC[max] == ABC[i])
                same++;
            else{
                //적은 경우 마지막 경우가 아닐때만 증가
                if(i != ABC.length-1)
                    diff++;
            }
        }
        
        answer = new int[same];
        
        max +=1;
        
        for(int i = 0; i < same; i++){
            answer[i] = max++;
            if(diff > 0){
                max++;
                diff--;
            }
        }
        
        return answer;
    }
}