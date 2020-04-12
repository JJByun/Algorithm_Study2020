public class levle2_week1 {
    public int[] solution(int[] prices) {
        int pickNumber;
        int tick=0; //몇초가 흘렀는지 검사
        int[] answer = new int[prices.length];
        try{
            for( int i=0; i<prices.length; i++) {
                pickNumber=prices[i];
                tick = 0;
                for(int j=i+1; j<prices.length;j++){
                    tick ++;
                    if(pickNumber > prices[j])
                        break;
                }
                answer[i]=tick;
            }
        }catch (Exception e){
            e.getStackTrace();
        }
        return answer;
    }
}
