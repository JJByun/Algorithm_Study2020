import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BestSeller {
    //solution number : 1302
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeMap<String, Integer> map = new TreeMap<>();
        for(int i=0; i<n; i++){
            String str = br.readLine();
            if(map.containsKey(str))
                map.replace(str,map.get(str)+1);
            else
                map.put(str,1);
        }
        int maxVal = 0;
        for(String s : map.keySet()){
            maxVal = Math.max(maxVal,map.get(s));
        }
        ArrayList<String> ret = new ArrayList<>(map.keySet());
        Collections.sort(ret);
        for(String s : ret){
            if(map.get(s) == maxVal){
                System.out.println(s);
                break;
            }

        }
//        PriorityQueue<pair> pq = new PriorityQueue<>(new Comparator<pair>() {
//            @Override
//            public int compare(pair o1, pair o2) {
//                if(o1.count > o2.count) return -1;
//                else if(o1.count == o2.count){
//                    return o1.str.compareTo(o2.str);
//                }else return 1;
//            }
//        });
//        for(int i=0; i<n; i++){
//            String str = br.readLine();
//            if(pq.contains(str))
//
//        }
    }
    static class pair{
        String str;
        int count;
        pair(String str, int count){
            this.str = str;
            this.count = count;
        }
    }
}
