import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1; //0번째는 존재 x 
        //우선순위 queue를 내림차순으로 생성
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());

        //Queue에 넣어주기
        for(int q : priorities){
            pQueue.add(q);
        }

        System.out.println(pQueue);

        while(!pQueue.isEmpty()){
            //전체 순회하면서 우선순위 큐와 같은 것인지 비교
            for(int i=0; i<priorities.length; i++){
                if(priorities[i] == pQueue.peek()){
                    if(i == location){
                        return answer;
                    }

                    pQueue.poll();
                    answer++;
                }

            }
        }
        /*
        //최대값 찾아주기
        int max = priorities[0];
        for(int i=1; i<priorities.length; i++){
            if(priorities[i] > max)
                max = priorities[i];
        }
        
        ArrayList<Integer> list = new ArrayList<>(); 
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for(int i=0; i<priorities.length; i++){
            if(priorities[i] )
        }
        //sorting을 위해 list에 넣어주기
        for(int i=0; i<priorities.length; i++){
            list.add(priorities[i]);
        }
        int count =0;
        //동일한 우선순위가 자기보다 뒤에 몇개있는지 카운트
        for(int i=0; i<location; i++){
            if(num == priorities[i]){
                count++;
            }
        }
        if( count == 0){
            for(int i=priorities.length-1; i>location; i--){
                if(num == priorities[i]){
                 count ++;
                }
            }
            
        }
        //내림차순 정렬
        list.sort(Comparator.reverseOrder());
        answer = list.get(num) + count; //내림차순 정렬 위치 index + 앞 or 뒤에있는 동일 데이터 개수 더해주기
        */

        return answer;
    }
}