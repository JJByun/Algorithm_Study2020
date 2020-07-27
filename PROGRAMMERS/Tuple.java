import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        //가장 긴 문자열을 찾아서 그것들을 배열에 넣어주기
        //O(n) 의 시간복잡도로 알고리즘 설계
        s = s.substring(1,s.length()-1); //앞 뒤 괄호 제거
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        int startIdx = 0;
        int endIdx = 0;
        int cnt = 0; // { 괄호를 만나면 +1, } 괄호를 만나면 -1. cnt가 0 이 됐을 때 } 를 만나면 계산해주기
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '{'){
                startIdx = i+1;
            }
            if(s.charAt(i) == '}'){
                endIdx = i;
                String tmp = s.substring(startIdx, endIdx);
                String[] tmps = tmp.split(",");
                ArrayList<String> lTmp = new ArrayList<>();
                
                for(String a : tmps)
                    lTmp.add(a);
                list.add(lTmp);
                
            }
        }
        Collections.sort(list, new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                if(o1.size() > o2.size())
                    return 1;
                else if( o1.size() == o2.size())
                    return 0;
                else
                    return -1;
            }
        });
        ArrayList<String> ret = new ArrayList<>();
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            ArrayList<String> sList = list.get(i);
            //리스트 가져온다음 배열에 없는거 하나씩 넣어주기
            for(String myS : sList){
                if(!ret.contains(myS)){
                    answer[i] = Integer.parseInt(myS);
                    ret.add(myS);
                    break;
                }   
            }
        }
        return answer;
    }
}
