import java.util.PriorityQueue;

public class MoreHot {
    public int solution(int[] scoville, int k) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<scoville.length; i++){
            pq.offer(scoville[i]);
        }

        //오름차순으로 정렬되기 때문에 맨 앞의 값만 비교해주면 됨
        while(pq.peek() < k && pq.size() > 1){
            int n1 = pq.poll(); //첫번째 값
            int n2 = pq.poll(); //두번째 값
            int n = n1 + n2*2;
            pq.offer(n);
            answer++;

            if(pq.size()==1 && pq.peek() < k){
                return -1;
            }
        }

        return answer;
    }
}
