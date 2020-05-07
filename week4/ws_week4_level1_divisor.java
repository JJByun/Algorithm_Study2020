import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<>();
        int div = 0;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i]%divisor == 0 || arr[i]/divisor == arr[i]){
                list.add(arr[i]);
                div++;
                }
            else if(div == 0 && i == arr.length-1)
                list.add(-1);
        }
        
        int[] answer = new int[list.size()];
        list.sort(null);
        
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}