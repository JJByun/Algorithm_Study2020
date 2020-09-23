import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MoonJeaJeep {
    //sol num : 1766 - 문제집

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //먼저 그래프의 값을 채운다
        //v1 -> v2 방향 그래프이므로 v2가 선택될때마다 마스킹 배열에 count 한다

        //마스킹 한 배열이 0인 애들을 먼저 pq에 넣는다
        //pq에 넣은 배열을 빌떄까지 반복. for(int i : pq) -> 여기서 마스킹 배열의 i값을 빼주고 0이라면 pq에 넣어준다
        int[] ints = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int size=ints[0];
        int rep = ints[1];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[] mark = new int[size+1];
        for(int i=0; i<=size; i++){
            list.add(new ArrayList<Integer>());
        }

        while(rep-->0){
            int[] v = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.get(v[0]).add(v[1]);
            mark[v[1]]++;
        }
        //마스킹 한 놈들 중 0인애들 넣기
        for(int i=1; i<=size; i++){
            if(mark[i]==0) pq.add(i);
        }
        StringBuffer sb = new StringBuffer();

        while(!pq.isEmpty()){
            int cur = pq.poll();
            for(int i: list.get(cur)){
                mark[i]--;
                if(mark[i]==0)
                    pq.add(i);
            }
            sb.append(cur+" ");
        }
        System.out.println(sb.toString().trim());
    }
}
