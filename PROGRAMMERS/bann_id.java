//불량 사용자 문제 풀이 

import java.util.*;
class Solution {
    static ArrayList<ArrayList<String>> ret = new ArrayList<>();
    static int count = 0;
    public int solution(String[] user_id, String[] banned_id) {
        if(user_id.length == banned_id.length) //예외처리
            return 1;

        String[] str = new String[banned_id.length];
        boolean[] visited = new boolean[user_id.length];
        
        perm(user_id,banned_id,str,visited,0,user_id.length,banned_id.length);
        return count;
    }
    
    
    void perm(String[] user_id, String[] banned_id, String[] output, boolean[] visited, int depth, int n, int r) {
        if(depth == r){
            boolean allRight = true;
            for(int i=0; i<banned_id.length; i++){
                if(!isMapped(output[i], banned_id[i]))
                    allRight = false;
            }
            if(allRight){ //모두 조건에 충족하는 경우
                
                if(!isExist(output)){
                    count++;
                    ArrayList<String> tmp = new ArrayList<>();
                    for(String s : output)
                        tmp.add(s);
                    ret.add(tmp);
                }
                    
            }                
            return;    
        }
        
 
        for (int i=0; i<n; i++) {
            
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = user_id[i];
                perm(user_id,banned_id, output, visited, depth + 1, n, r);       
                visited[i] = false;
            }
        }
    }
    
    boolean isMapped(String str1, String str2){
        if(str1.length() != str2.length())
            return false;
        for(int i=0; i<str2.length(); i++){
            if(str2.charAt(i) == '*')
                continue;
            else{
                if(str1.charAt(i) != str2.charAt(i))
                    return false;
            }
        }
        return true;
    }
    
    boolean isExist(String[] output){      
        for(int i=0; i<ret.size(); i++){
            ArrayList<String> list = ret.get(i);
            Collections.sort(list);
            String[] tmpOut = output.clone();
            Arrays.sort(tmpOut);
            
            boolean b = true;
            for(int j=0; j<list.size(); j++){
                if(!list.get(j).equals(tmpOut[j]))
                    b=false;
            }
            if(b) //다 같은게 있는경우
                return true;
        }
        return false;
    }
}
