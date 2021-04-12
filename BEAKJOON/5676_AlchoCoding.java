import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_5676_음주코딩 {
    //백준 5676 음주코딩
    //인덱스 트리 문제
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static int N,K;
    static StringBuilder sb;
    static int leafStart;
    static long[] tree = new long[100000*4+10];
    public static void main(String[] args) throws IOException {
        String input="";
        while((input = br.readLine()) != null) {
            sb = new StringBuilder();
            if (input.equals("")) break;
            String[] ins = input.split(" ");
            N = Integer.parseInt(ins[0]);
            K = Integer.parseInt(ins[1]);

            makeTree();

            int b, c;
            while (K-- > 0) {
                stz = new StringTokenizer(br.readLine());
                String tok = stz.nextToken();
                b = Integer.parseInt(stz.nextToken());
                c = Integer.parseInt(stz.nextToken());
                if (tok.equals("C")) { //변경
                    update(b, c);
                } else { //곱 출력
                    sb.append(cal(b, c));
                }
            }
            System.out.println(sb.toString());
        }
    }

    static void update(int n, int val){
        int pos = n + leafStart - 1;
        tree[pos] = (val==0) ? 0 : val > 0 ? 1 : -1;
        pos/=2;
        while(pos > 0){
            tree[pos] = tree[pos*2] * tree[pos*2+1];
            pos/=2;
        }
    }
    static String cal(int l, int r){
        int left = leafStart + l - 1;
        int right = leafStart + r - 1;
        long ret = 1;
        while(left <= right){
            if(left % 2 == 1){
                ret *= tree[left];
                left++;
            }
            if(right % 2 == 0){
                ret *= tree[right];
                right--;
            }
            left/=2;
            right/=2;
        }
        if(ret > 0) return "+";
        else if(ret == 0) return "0";
        else return "-";
    }
    static void makeTree() throws IOException {
        stz = new StringTokenizer(br.readLine());
        leafStart = 1;
        while(N > leafStart) leafStart*=2;
        Arrays.fill(tree,1);

        for(int i=0; i<N; i++){
            int n = Integer.parseInt(stz.nextToken());
            tree[leafStart+i] = (n==0) ? 0 : n > 0 ? 1 : -1;
        }
        for(int i=leafStart-1; i>0; i--) tree[i] = tree[i*2] * tree[i*2+1];
    }
}
