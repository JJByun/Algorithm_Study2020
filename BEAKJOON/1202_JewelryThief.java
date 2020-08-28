import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class JewelryTheif {
    //solution number : 1202
    static int N; //보석 개수
    static int K; //가방 개수

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = nums[0];
        K = nums[1];
        jewerly[] jewerlies = new jewerly[N];
        int[] bag = new int[K];
        for(int i=0; i<N; i++){ //보석 정보 담기
            int[] gets = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            jewerlies[i] = new jewerly(gets[0],gets[1]);
        }
        Arrays.sort(jewerlies); //보석 무게 오름차순 정렬
        for(int i=0; i<K; i++) //가방 정보담기
            bag[i] = Integer.parseInt(br.readLine());
        Arrays.sort(bag); //가방 무게 오름차순 정렬

        //가방 무게의 최대값까지 들어갈 수 있는 모든 보석을 우선순위 큐에 넣어주기
        //그리고 가방의 개수만큼 우선순위 큐에서 빼주기
        // O(N+M)
        // 선형적으로 탐색을 시작한다. bag의 무게가 될떄까지 우선순위큐에 보석을 쭉 넣어주고 더이상 못넣으면 큐에서 가장 큰 값을 꺼내주고 다음 가방을 선택
        // 위의 과정 무한 반복

        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int idx = 0;
        for(int bagW : bag){
            while(idx < N && bagW >= jewerlies[idx].weight){
                pq.add(-jewerlies[idx].value);
                idx++;
            }
            if(!pq.isEmpty()) ans += Math.abs(pq.poll());// 현재 가방 무게에서 가장 큰 값을 뺴주므로 해당 무게의 최대 가치를 얻음
        }
        System.out.println(ans);

    }

    public static class jewerly implements Comparable<jewerly> {
        int weight;
        int value;
        jewerly(int weight, int value){
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(jewerly o) {
            return this.weight - o.weight;
        }
    }
}
