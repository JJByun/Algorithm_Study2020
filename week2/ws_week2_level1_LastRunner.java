import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class Solution {
    public String solution(String[] part, String[] comp) {
        String answer = "";
        int complen = comp.length;
        int partlen = part.length;
        
        //배열 풀이방식, 시간 초과
        // for(int i = 0; i < part.length; i++){
        // int lencheck = complen;
        //     for(int j = 0; j < complen; j++){
        //         if(part[i].equals(comp[j])){
        //             String tmp = comp[complen-1];
        //             comp[complen-1] = comp[j];
        //             comp[j] = tmp;
        //             complen--;
        //             break;
        //         }
        //     }
        //     if(lencheck == complen){
        //         return part[i];   
        //     }
        // }
        
        Arrays.sort(part);
        Arrays.sort(comp);
        
        for(int i = 0; i < complen; i++){
            if(!part[i].equals(comp[i]))
                return part[i];
        }
        return part[complen];
        
        
        
        //hash
//         HashMap<Integer, String> partmap = new HashMap<>();
//         int idx  = 0;
        
//         for(int i = 0; i < part.length; i++){
//             partmap.put(i, part[i]);
//         }
        
//         for(int i = 0; i < comp.length; i++){
//             idx = (int)getKey(partmap, comp[i]) ;
//             part[idx] = null;
//             partmap = new HashMap<>();
//             for(int k = 0; k < part.length; k++){
//                 if(part[k]!= null){
//                     partmap.put(k, part[k]);
//                     answer = part[k];
//                 }
//             }    
//         }

        //return answer;
    }
    
    // public static Object getKey(HashMap<Integer, String> m, Object val){
    //     for(Object o : m.keySet()){
    //         if(m.get(o).equals(val))
    //             return o;
    //     }
    //     return null;
    // }
}