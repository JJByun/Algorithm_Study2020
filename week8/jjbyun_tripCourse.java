import java.util.*;
class Solution {
    List<String> retList = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        for(int i=0; i<tickets.length; i++){
            //ICN출발인 것 찾아주기
            if(tickets[i][0].equals("ICN")){
                boolean [] visited = new boolean[tickets.length];
                visited[i] = true;
                dfs(tickets, 1, tickets.length, visited, "ICN "+tickets[i][1]+" ",tickets[i][1]);

            }else{
                continue;
            }
            
        }
        
        Collections.sort(retList);
        String []strRet = retList.get(0).trim().split(" ");
        
        return strRet;
    }
    
    
    public void dfs(String[][] tickets, int depth, int n, boolean[] visited, String ret, String dest){
        //종료조건
        if(depth == n){
            //System.out.println(ret);
            retList.add(ret);
            return;
        }
        
        //재귀
        for(int i=0; i<tickets.length;i++){
            // System.out.println("visited: "+visited[i]);
            // System.out.println("dest: "+tickets[i][0]);
            if(!visited[i] && dest.equals(tickets[i][0])){
                //System.out.println(tickets[i][0]+ "에서 출발");
                visited[i] = true;                
                dfs(tickets, depth+1, n, visited, ret+=tickets[i][1]+" ", dest=tickets[i][1]); 
                visited[i] = false; ret = ret.substring(0,ret.length()-4);
            }
        }
    }
}
