import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Command {
    //solution number : 1032
    static int n;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] strs = new String[n];
        String ret="";
        for(int i=0; i<n; i++)
            strs[i] = br.readLine();
        int strLength = strs[0].length();
        for(int j=0; j<strLength; j++){ //문자 길이만큼 반복
            if(isSame(strs,j))
                ret += strs[0].charAt(j);
            else
                ret += "?";
        }
        System.out.println(ret);
    }
    static boolean isSame(String[] strs, int j){
        char c = strs[0].charAt(j);
        for(int i=1; i<n ;i++){ //문자열 개수만큼 반복
            if(c != strs[i].charAt(j)) return false;
        }
        return true;
    }
}
