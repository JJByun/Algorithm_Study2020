import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class progress {
    public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> solution = new ArrayList<>();
        int index =0; //배열 인덱스 체크
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i= index; i< progresses.length; i++){
            q.offer(progresses[i]); //작업율 넣기
        }

        while(!q.isEmpty()){
            count = 0; //return 배열에 넣을 개수 카운트

            for(int i= index ; i<progresses.length; i++){
                int num = q.poll();
                System.out.println("인덱스:" +i);
                q.offer(num + speeds[i]);
            }
            for(int i: q){
                System.out.println(i);
            }
            while(q.peek() >= 100){
                System.out.println("데이터 추출:"+ q.peek());
                index++; //offset 이동
                count++; //리턴 배열에 넣어줄 count값 증가
                q.poll(); //맨 앞의 큐 없애주기
                if(q.isEmpty())
                    break;
            }
            if(count != 0){
                solution.add(count);
            }

        }

        return convertIntegers(solution);
    }

    public static int[] convertIntegers(ArrayList<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }
}
