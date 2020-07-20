import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class OperInsert {
    //solution number : 14888
    static int[] numbers;
    static char[] operation;
    static boolean[] visited;
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        String[] strs =br.readLine().split(" ");
        for(int i=0; i<strs.length;i++)
            numbers[i] = Integer.parseInt(strs[i]);
        operation = new char[N-1];
        visited = new boolean[N-1];
        int idx = 0;
        String[] ops = br.readLine().split(" ");
        int plus = Integer.parseInt(ops[0]);
        while(plus-- > 0){
            operation[idx] = '+';
            idx++;
        }
        int minus = Integer.parseInt(ops[1]);
        while(minus-- > 0){
            operation[idx] = '-';
            idx++;
        }
        int mul = Integer.parseInt(ops[2]);
        while(mul-- > 0){
            operation[idx] = '*';
            idx++;
        }
        int div = Integer.parseInt(ops[3]);
        while(div-- > 0){
            operation[idx] = '/';
            idx++;
        }
        char[] cha = new char[N-1];
        dfs(0,N-1, cha);
        System.out.println(MAX+" "+MIN);
    }
    static void dfs(int depth, int n, char[] oper){
        if(n == depth){
            //계산하기
            int calRet = cal(oper);
            MAX = Math.max(MAX, calRet);
            MIN = Math.min(MIN, calRet);
            return;
        }
        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                oper[depth] = operation[i];
                dfs(depth+1, n, oper);
                visited[i] = false;
            }
        }
    }
    static int cal(char[] operation){
        int ret = numbers[0];
        for(int i=0; i<operation.length; i++){
            char c = operation[i];
            if(c == '+'){
                ret = ret + numbers[i+1];
            }else if(c == '-'){
                ret = ret - numbers[i+1];
            }else if(c == '*'){
                ret = ret * numbers[i+1];
            }else{
                ret = ret / numbers[i+1];
            }
        }
        return ret;
    }
}
