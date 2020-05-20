import java.util.*;

public class hide {
    public int solution(String[][] clothes){
        int answer = 1;

        //key 값을 이름으로 가진 ArrayList 배열을 Map으로 만듦
        Map<String, ArrayList<String>> map = new HashMap<>();
        for(int i=0;i < clothes.length;i++){
            if(map.containsKey(clothes[i][0])){
                ArrayList<String> list = map.get(clothes[i][0]);
                list.add(clothes[i][1]);
            }else{
                map.put(clothes[i][0],new ArrayList<>());
                ArrayList<String> list = map.get(clothes[i][0]);
                list.add(clothes[i][1]);
            }
        }

        for(String key: map.keySet()){
            answer *= (map.get(key).size()+1);
        }
        answer-- ;

        return answer;
    }
}
