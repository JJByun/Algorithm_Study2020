import java.util.LinkedList;
import java.util.Queue;

public class truck {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<truckInfo> BeforeQueue = new LinkedList<>();
        Queue<truckInfo> IngQueue = new LinkedList<>();
        //트럭 큐에 넣어주기
        for(int i=0; i<truck_weights.length;i++){
            truckInfo truck = new truckInfo(truck_weights[i]);
            BeforeQueue.add(truck);
        }
        int weightSum = 0;
        //먼저 트럭들을 넣어주기
        /*while(weightSum+BeforeQueue.peek().truck_weight <= weight ){
            weightSum += BeforeQueue.peek().truck_weight;
            IngQueue.add(BeforeQueue.poll());
            if(BeforeQueue.isEmpty())
                break;
        }*/
        weightSum+=BeforeQueue.peek().truck_weight;
        IngQueue.add(BeforeQueue.poll());

        while(!IngQueue.isEmpty() || BeforeQueue.size()>0) {

            //먼저 무게를 측정해서 ing 큐에 넣어줄지 말지 결정
            if(!BeforeQueue.isEmpty()){
                if(weightSum+BeforeQueue.peek().truck_weight <= weight){
                    weightSum+=BeforeQueue.peek().truck_weight; //무게 업데이트

                    IngQueue.add(BeforeQueue.poll());
                }
            }

            //System.out.println(IngQueue);
            //System.out.println(BeforeQueue);
            //System.out.println("weight Sum:"+weightSum);
            //1초 카운트
            for(truckInfo t:IngQueue){
                t.pass_time+=1;
            }
            //기다리는 시간도 카운트
            for(truckInfo t:BeforeQueue){
                t.wait_time+=1;
            }
            //다리 길이만큼 이동했는지 체크
            if(IngQueue.peek().pass_time >= bridge_length){
                if(BeforeQueue.isEmpty() && IngQueue.size()==1){
                    answer = IngQueue.peek().pass_time+IngQueue.peek().wait_time;
                    System.out.println("pass time: "+IngQueue.peek().pass_time);
                    System.out.println("wait time: "+IngQueue.peek().wait_time);
                    break;
                }
                weightSum-=IngQueue.peek().truck_weight;
                //System.out.println("weigthSum:" +weightSum);
                IngQueue.poll();
                System.out.println("Poll!");

            }



        }

        return answer+1;
    }

    public class truckInfo{
        public int truck_weight;
        public int pass_time;
        public int wait_time;

        public truckInfo(int truck_weight){
            this.pass_time=0;
            this.wait_time=0;
            this.truck_weight=truck_weight;
        }

        public void setPass_time(){
            this.pass_time++;
        }

        public int getPassTime(){
            return this.pass_time;
        }

    }

    public static void main(String args[]){
        int[] arr = {10,10,10,10,10,10,10,10,10};
        truck truck = new truck();
        int n = truck.solution(100,100,arr);
        System.out.println(n);
    }
}
