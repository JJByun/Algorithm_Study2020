import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RemoveParathes {
    // solution number : 2800
//    static PriorityQueue<String> pq = new PriorityQueue<>();
//    static HashMap<Integer, Integer> map;
//    static String str;
//    public static void main(String args[]) throws IOException {
//        //stack을 사용하기
//        //priorityQueue를 이용하여 자동으로 사전순으로 string 정렬하기
//        Stack<Integer> stack = new Stack<>();
//        pq = new PriorityQueue<>();
//        map = new HashMap<>();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        str = br.readLine();
//        for(int i=0; i<str.length();i++){
//            if(str.charAt(i) == '(')
//                stack.push(i);
//            else if(str.charAt(i) == ')'){
//                int idx = stack.pop();
//                map.put(idx,i); // map(왼쪽 괄호 위치, 오른쪽 괄호 위치)
//            }
//        }
//        int[] keys = new int[map.keySet().size()];
//        int idx = 0;
//        for(Object o : map.keySet())
//            keys[idx++] = (int)o;
//
//        for(int i=1; i<=keys.length; i++){
//            boolean[] visited = new boolean[keys.length];
//            int[] ret = new int[i];
//            dfs(keys.length,i,0,visited,keys,ret);
//        }
//        for(String str : pq)
//            System.out.println(str);
//
//    }
//    //순열로 조합 만들어주기
//    static void dfs(int n, int r, int depth, boolean[] visited, int[] arr,int[] ret){
//        if(depth == r){
//            StringBuilder sb = new StringBuilder();
//            for(int i=0; i<str.length();i++){ //일단 문자열 만들어주기
//                sb.append(str.charAt(i));
//            }
//
//            for(int i : ret){ //제거해야 하는 문자 가져오기
//                int first = i;
//                int seconde = map.get(i);
//                //괄호 제거해주기 " " 로 변경해서 나중에 없애주기
//                sb.replace(first,first+1," ");
//                sb.replace(seconde,seconde+1," ");
//                String strs = sb.toString().replaceAll(" ","");
//                //System.out.println("strs: "+strs);
//                if(!pq.contains(strs)) //중복은 넣지 않기
//                    pq.add(strs);
//            }
//            return;
//        }
//        for(int i=0; i<n; i++){
//            if(!visited[i]){
//                visited[i] = true;
//                ret[depth] = arr[i];
//                dfs(n,r,depth+1, visited, arr, ret);
//                visited[i] = false;
//            }
//        }
//    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] line = str.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int[] open = new int[10];
        int[] close = new int[10];
        int num = 0;

        for(int i=0; i<line.length;i++){
            if(line[i] == '(') stack.push(i);
            else if(line[i] == ')'){
                open[num] = stack.pop();
                close[num++] = i;
            }
        }
        TreeSet<String> answer = new TreeSet<>();
        boolean[] check = new boolean[line.length];

        for(int i=0; i< (1<<num); i++){
            if(i != 0){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<num; j++){
                    if((i &(1<<j))>0){
                        check[open[j]] = true;
                        check[close[j]] = true;
                    }
                }
                for(int j=0; j<line.length;j++){
                    if(check[j]) check[j] = false;
                    else sb.append(line[j]);
                }
                answer.add(sb.toString());
            }
        }

        for(String s : answer)
            System.out.println(s);
    }


}
