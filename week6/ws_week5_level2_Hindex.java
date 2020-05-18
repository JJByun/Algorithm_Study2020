import java.util.*;
class Solution {
    public int solution(int[] citations) {
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        int check = 0;
        int top = 0;
        
        for(int n : citations){
            list.add(n);
        } 
        list.sort(null);
        
        for(int i = 0; i <= list.size(); i++){
            count = 0;
            for(int j = 0; j < list.size(); j++){
                if(i <= list.get(j)){
                    count++;
                }
            }
            if(count >= i && i > top){
                top = i;
            }
        }
        
        return top;
    }
}