import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_2042_구간합구하기 {
    //백준 2042 구간 합 구하기
    //인덱스 트리 문제
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static int N,M,K;
    static int leafStart;
    static long[] tree = new long[4*1000000+100];

    public static void main(String[] args) throws IOException {
        stz = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());
        K = Integer.parseInt(stz.nextToken());

        makeTree();

        int a,b;
        long c;
        int tmp = M+K;
        while(tmp-->0){
            stz = new StringTokenizer(br.readLine());
            a = Integer.parseInt(stz.nextToken());
            b = Integer.parseInt(stz.nextToken());
            c = Long.parseLong(stz.nextToken());
            if(a == 1){
                update(b,c);
            }else{
                System.out.println(getSum(b,(int) c));
            }
        }
    }
    static void makeTree() throws IOException {
        leafStart = 1;
        Arrays.fill(tree,0);
        while(N > leafStart){
            leafStart*=2;
        }
        long n;
        for(int i=0; i<N; i++){
            n = Long.parseLong(br.readLine());
            tree[leafStart+i] = n;
        }
        for(int i=leafStart-1; i>0; i--){
            tree[i] = tree[i*2] + tree[i*2+1];
        }

    }
    static void update(int n, long val){
        int pos = leafStart + n -1;
        tree[pos] = val;
        pos/=2;
        while(pos>0){
            tree[pos] = tree[pos*2] + tree[pos*2+1];
            pos/=2;
        }
    }
    static long getSum(int s, int e){
        long ret = 0;
        int start = leafStart + s -1;
        int end = leafStart + e  -1;
        while(start <= end){
            if(start % 2 == 1){
                ret+=tree[start];
                start++;
            }
            if(end % 2 == 0){
                ret += tree[end];
                end--;
            }
            start /=2;
            end /= 2;
        }
        return ret;
    }
}
