public class H_Index {
    public int solution(int[] citations) {
        int answer = 0;
        for(int i=1; i <= citations.length; i++){
            int n=0;
            int pre = answer;
            for(int j : citations){
                if(j >= i){
                    n++;
                }
                if(n >= i){
                    answer++;
                    break;
                }
            }
            if(pre == answer)
                break;
        }
        return answer;
    }
}
