import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int MAXNUM = 100;
    static boolean stop = false;
    static String strRet = "";
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] heights = new int[10];

        for(int i=0; i<9; i++)
            heights[i] = Integer.parseInt(br.readLine());
        boolean [] visited = new boolean[9];
        dfs(heights,visited, 0, 0, ""); //dfs로 순회
        String[] sol = strRet.trim().split(" ");
        int [] intRet = new int [sol.length];
        for(int i=0; i<intRet.length; i++)
            intRet[i] = Integer.parseInt(sol[i]);
        Arrays.sort(intRet); //오름차순 정렬
        for(int i : intRet)
            System.out.println(i);
    }
    public static void dfs(int[] heights, boolean [] visited, int depth, int sum, String ret){
        if(stop)
            return;
        if(depth == 7){
            if(sum==MAXNUM){
                stop = true;
                strRet = ret;
            }
            return;
        }
        for(int i=0; i<9; i++){
            if(!visited[i]){
                visited[i] = true;
                ret+=heights[i]+" ";
                dfs(heights, visited, depth+1, sum+heights[i],ret);
                visited[i] = false; //방문이 끝났으니 다시 false로 만들어서 backTracking 해주기
                ret = ret.substring(0, ret.length() - Integer.toString(heights[i]).length()-1); //정답을 못찾았으니 삭제
            }
        }

    }
}