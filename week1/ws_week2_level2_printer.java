import java.util.PriorityQueue;
import java.util.Queue;
import java.util.*;

class Solution {
    public int solution(int[] prior, int loc) {
        //몇번째로 인쇄 되는지 카운트
        int answer = 1;
        
        //우선순위 큐 생성
        PriorityQueue<Integer> pq = 
            new PriorityQueue<Integer>(Collections.reverseOrder());
        
        //prior배열의 값을 pq에 넣는다
        for(int q : prior){
            pq.add(q);
        }
        
        //우선순위큐의 내용물이 모두 없어질때까지
       while(!pq.isEmpty()){
           //기존의 배열의 값 처음부터 끝까지 비교
            for(int i = 0; i < prior.length; i++){
            //내림차순으로 정렬된 큐의 첫값을 기존의 배열과 비교
                if(pq.peek() == prior[i]){
                    //같은 값이면 위치값도 비교
                    if(i == loc){
                        //값이같고 같은 위치이면 원하는 값이므로 반환
                        return answer;
                    }
                    //아니면 다음 값과의 비교를 위해 뺀다
                    pq.poll();
                    //먼저 프린트 한것이므로 answer++
                    answer++;
                }
            }
        }
        
        
        return answer;
    }
}