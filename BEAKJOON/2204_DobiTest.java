import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DobiTest {
    //solution number : 2204 도비의 난독증 테스트
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int num = Integer.parseInt(br.readLine());
            if(num == 0) break;
            PriorityQueue<pair> pq = new PriorityQueue<>(new Comparator<pair>() {
                @Override
                public int compare(pair o1, pair o2) {
                    return o1.lower.compareTo(o2.lower);
                }
            });
            while(num-->0){
                String str = br.readLine();
                pq.add(new pair(str,str.toLowerCase()));
            }
            System.out.println(pq.poll().origin);
        }
    }
    static class pair{
        String origin;
        String lower;
        pair(String origin, String lower){
            this.origin=origin;
            this.lower=lower;
        }
    }
}
