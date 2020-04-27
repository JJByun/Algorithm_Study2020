import java.util.ArrayList;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        n -= lost.length;
        
        ArrayList<Integer> lostList = new ArrayList<Integer>();
        
        for(int l : lost)
            lostList.add(l);
        
        for(int j = 0; j < reserve.length; j++){
            if(lostList.contains(reserve[j])){
                lostList.remove(lostList.indexOf(reserve[j]));
                reserve[j] = -10;
                n++;
            }
        }
        
        for(int i = 0; i < lostList.size(); i++){
            for(int j = 0; j < reserve.length; j++){
                if(reserve[j] > 0 &&
                   ( reserve[j]-1==lostList.get(i)||reserve[j]+1==lostList.get(i) )){
                    n++;
                    reserve[j] = -10;
                    break;
                }
            }
        }

        answer = n;
        return answer;
    }
}