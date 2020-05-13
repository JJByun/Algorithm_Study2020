import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        ArrayList<String> list = new ArrayList<>();
        list.add(strings[0]);
        
        for(int i = 1; i < strings.length; i++){
            for(int Lidx = 0; Lidx < list.size(); Lidx++){
                if(strings[i].charAt(n) < (list.get(Lidx)).charAt(n)){
                    list.add(Lidx, strings[i]);
                    //System.out.println("작은거 넣기 > "+list.get(Lidx));
                    break;
                }    
                else if(strings[i].charAt(n) == (list.get(Lidx)).charAt(n)){
                    if(strings[i].compareTo(list.get(Lidx)) > 0 && Lidx == list.size()-1){
                        list.add(strings[i]);
                        //System.out.println("같은데 큰거 넣기 > "+strings[i]);
                        break;
                    }
                    else if(strings[i].compareTo(list.get(Lidx)) < 0 ){
                        list.add(Lidx, strings[i]);
                        //System.out.println("같은데 작은거 넣기 > "+list.get(Lidx));
                        break;
                    }
                }
                if(Lidx == list.size()-1){
                    list.add(strings[i]);
                    //System.out.println("큰거 넣기 > "+list.get(Lidx));
                    break;
                }
            }
        }
        String[] answer = new String[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            //System.out.println(list.get(i));
            answer[i] = list.get(i);
        }
        return answer;
    }
}