import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Olympic {
    // solution number : 8979

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] val = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count = val[0];
        int target = val[1];
        if(count == 1){ //예외처리
            System.out.println(1);
            return;
        }
        PriorityQueue<Score> pq = new PriorityQueue<>(new Comparator<Score>() {
            @Override
            public int compare(Score o1, Score o2) {
                if(o1.gold > o2.gold){
                    return -1;
                }else if( o1.gold < o2.gold){
                    return 1;
                }else if(o1.gold ==o2.gold){
                    if(o1.silver > o2.silver){
                        return -1;
                    }
                    else if(o1.silver < o2.silver){
                        return 1;
                    }
                    else if(o1.silver == o2.silver){
                        if(o1.bronze > o2.bronze){
                            return -1;
                        }else if(o1.bronze < o2.bronze)
                            return 1;
                        else if(o1.bronze == o2.bronze)
                            return 0;
                    }
                }
                return  -1;
            }
        });
        for(int i=0; i<count; i++){
            int[] vals = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            pq.add(new Score(vals[0],vals[1],vals[2],vals[3]));
        }
        int sameCount = 0;
        int retCount = 1;
        while(!pq.isEmpty()){
            Score s = pq.poll();
            if(s.index == target){
                System.out.println(retCount - sameCount);
                return;
            }

            Score s2 = pq.peek();
            if(s.bronze == s2.bronze && s.silver == s2.silver && s.gold == s2.gold)
                sameCount++;
            else
                sameCount = 0;
            retCount++;
        }
    }

    public static class Score{
        int index;
        int gold;
        int silver;
        int bronze;
        public Score(int index, int gold, int silver, int bronze){
            this.index=index;
            this.gold=gold;
            this.silver=silver;
            this.bronze=bronze;
        }
    }
}
