import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DSLR {
    //solution number : 9019

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testNum = Integer.parseInt(br.readLine());

        while(testNum-- > 0){
            String[] nums = br.readLine().split(" ");
            int start = Integer.parseInt(nums[0]);
            int end = Integer.parseInt(nums[1]);
            if(start == end){
                System.out.println("");
                continue;
            }
            boolean[] visited = new boolean[10001];
            //queue 시작 넣어주기
            Queue<Info> q = new LinkedList<>();
            visited[start] = true; //시작
            q.add(new Info(D(start),"D"));
            visited[D(start)] = true;
            q.add(new Info(S(start),"S"));
            visited[S(start)] = true;
            q.add(new Info(L(start),"L"));
            visited[L(start)] = true;
            q.add(new Info(R(start),"R"));
            visited[R(start)] = true;

            while(!q.isEmpty()){
                Info info = q.poll();
                int num = info.num;
                //System.out.println(num);
                if(num == end){
                    System.out.println(info.order);
                    break;
                }
                if(!visited[D(num)]){
                    q.add(new Info(D(num),info.order + "D"));
                    visited[D(num)] = true;
                }
                if(!visited[S(num)]){
                    q.add(new Info(S(num),info.order + "S"));
                    visited[S(num)] = true;
                }
                if(!visited[L(num)]){
                    q.add(new Info(L(num),info.order + "L"));
                    visited[L(num)] = true;
                }
                if(!visited[R(num)]){
                    q.add(new Info(R(num),info.order + "R"));
                    visited[R(num)] = true;
                }

            }

        }
    }
    public static int D(int n){
        return n*2 % 10000;
    }

    public static int S(int n){
        if(n == 0)
            return 9999;
        else
            return n-1;
    }

    public static int L(int n){
        int tmp = n%1000;
        tmp *= 10;
        tmp += (n/1000);
        return tmp;
    }

    public static int R(int n){
        int tmp = n%10;
        n /= 10;
        n += (tmp*1000);
        return n;
    }
    static class Info{
        int num;
        String order;
        Info(int num, String order){
            this.num=num;
            this.order=order;
        }
    }
}
