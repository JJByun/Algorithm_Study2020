import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Numbers {
    //solution number : 5052 전화번호 목록
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int itr = Integer.parseInt(br.readLine());

        for(int i=0; i<itr; i++){
            int num = Integer.parseInt(br.readLine());
            String[] strs = new String[num];
            for(int j=0; j<num; j++){
                strs[j] = br.readLine();
            }
            Arrays.sort(strs);

            boolean isBreak = false;
            for(int k=0; k<num-1; k++){
                if(strs[k+1].startsWith(strs[k])){
                    isBreak = true;
                    break;
                }
            }
            if(isBreak) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
