import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_2357_최솟값과최댓값 {
    //백준 2357 최솟값과 최댓값
    //세그먼트 트리 문제
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static int N,M;
    static int leafStart;
    static Node[] tree = new Node[100000*4+10];

    public static void main(String[] args) throws IOException {
        stz = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());
        makeTree();
        int a,b;
        while(M-- > 0){
            stz = new StringTokenizer(br.readLine());
            a = Integer.parseInt(stz.nextToken());
            b = Integer.parseInt(stz.nextToken());

            get(a,b);
        }
    }
    static void makeTree() throws IOException {
        leafStart = 1;

        for(int i=1; i<=100000*4+1; i++) tree[i] = new Node(Integer.MIN_VALUE,Integer.MAX_VALUE);
        while(leafStart < N){
            leafStart*=2;
        }
        int n;
        for(int i=0; i<N; i++){
            n = Integer.parseInt(br.readLine());
            tree[leafStart+i] = new Node(n,n);
        }
        for(int i=leafStart-1; i>0; i--){
            tree[i].max = Math.max(tree[i*2].max, tree[i*2+1].max);
            tree[i].min = Math.min(tree[i*2].min, tree[i*2+1].min);
        }
    }
    static void get(int l ,int r){
        int left = l + leafStart - 1;
        int right = r + leafStart - 1;
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;

        while(left <= right){
            if(left % 2 == 1){
                maxVal = Math.max(maxVal, tree[left].max);
                minVal = Math.min(minVal, tree[left].min);
                left++;
            }
            if(right % 2 == 0){
                maxVal = Math.max(maxVal, tree[right].max);
                minVal = Math.min(minVal, tree[right].min);
                right--;
            }
            left/=2;
            right/=2;
        }
        System.out.println(minVal+" "+maxVal);
    }
    static class Node{
        int max, min;
        public Node(int max, int min){
            this.max=max;
            this.min=min;
        }
    }
}
