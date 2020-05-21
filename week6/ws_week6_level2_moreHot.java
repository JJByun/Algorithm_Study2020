import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int pos = -1;
        
        PriorityQueue<Integer> allQ = new PriorityQueue<>();
        
        for(int i : scoville)
        	allQ.add(i);
        
        Iterator<Integer> itr = allQ.iterator();
        
    	for(int i = 0; i < allQ.size(); i++) {
			if(itr.next() < K)
    			pos = i;	
    	}
    	if(pos == -1)
    		return 0;
    	
    	while(allQ.peek()< K && allQ.size() > 1) {
    		answer++;
    		int i = allQ.poll();
    		int j = allQ.poll();
    		allQ.add(i+j*2);
    	}
    	
    	if(allQ.peek() < K) {
    		return -1;
    	}
         
        return answer;
    }
}