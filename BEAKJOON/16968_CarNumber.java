import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CarNumber {
    //solution number : 16968
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] strs = br.readLine().toCharArray();

        //숫자 개수 : 10개
        //문자 개수 : 26개
        int count;
        if(strs[0] == 'd')
            count = 10;
        else
            count = 26;
        for(int i=1; i<strs.length; i++){
            if(strs[i] == 'd'){
                //앞에가 d라면 9 아니라면 10
                if(strs[i-1] == 'd')
                    count *= 9;
                else
                    count *= 10;
            }else{
                //앞에가 c라면 25 아니라면 26
                if(strs[i-1] == 'c')
                    count *= 25;
                else
                    count *= 26;
            }
        }
        System.out.println(count);
    }
}
