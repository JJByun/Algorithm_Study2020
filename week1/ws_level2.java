class Solution {
    public int[] solution(int[] prices) {
        /*전달할 배열을 가격배열 길이만큼 생성*/
        int[] answer = new int[prices.length];

        //이중반복문을 통해 한값에 대해 끝까지 비교
        for(int i = 0; i < prices.length; i++){
            int count = 0;
            for(int j = i+1; j < prices.length; j++){
                count++;
                //값이 떨어지면 탈출, 안떨어지면 끝까지 체크후 탈출
                if(prices[j] < prices[i]){
                    break;
                }
            }
            //탈출한 카운트 값을 배열에 넣음
            answer[i] = count;
        }
        return answer;
    }
}
