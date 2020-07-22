import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOIO {
    //solution number : 5525
    /*
    입력 개수가
    String : 100만개
    Pattern : 100만개 이므로
    단순한 문자열 검색 알고리즘은 O(N*M) = 100만의 제곱 시간이 걸린다
    //따라서 KMP 알고리즘을 사용하여 O(100만) 을 만들어줘야만 풀리는 문제
    */
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int strLength = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String pattern = makeIO(N);

        System.out.println(kmp(str,pattern));

    }
    public static String makeIO(int n){
        StringBuilder sb = new StringBuilder();
        while(n-->0){
            sb.append("IO");
        }
        sb.append("I");
        return sb.toString();
    }
    public static int kmp(String s, String p){
        int count = 0;
        int[] pi = getPi(p);
        int n = s.length(), m=p.length(), j= 0;
        char[] strs = s.toCharArray();
        char[] patterns = p.toCharArray();
        for(int i=0; i<n ;i++){
            while(j>0 && strs[i] != patterns[j]){
                //중간단계 뛰어넘기
                j = pi[j-1];
            }
            if(strs[i] == patterns[j]){
                if(j==m-1){
                    count++;
                    j=pi[j];
                }else{
                    j++;
                }
            }
        }
        return count;
    }
    public static int[] getPi(String pattern){
        int m =pattern.length();
        int j =0;
        int[] pi = new int[m];
        char[] p = pattern.toCharArray();

        for(int i=1; i<m; i++){
            while(j>0 && p[i] != p[j]){
                j = pi[j-1];
            }
            if(p[i] == p[j]){
                pi[i] = ++j;
            }
        }
        return pi;
    }


}
