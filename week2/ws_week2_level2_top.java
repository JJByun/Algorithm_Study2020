class Solution {
    public int[] solution(int[] heights) {
        
        int len = heights.length;
        int[] answer = new int[len];
        int send = 0;
        int get = 0;
        
        for(send = len-1; send > 0; send--){
            answer[send] = 0;
            for(get = send-1; get >= 0; get--){
                if(heights[send] < heights[get]){
                    answer[send] = get+1;
                    break;
                }
            }
        }
        
        for(int k : answer)
            System.out.print(k+" ");
        
        return answer;
    }
}