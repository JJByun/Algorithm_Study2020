import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindNumber {
    //solution number : 1920
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        int[] val = new int[nums.length];
        int i = 0;
        for(String s : nums){
            val[i] = Integer.parseInt(s);
            i++;
        }
        //시간복잡도: nlogn + log2n -> logn < n 이므로 문제가 풀리게 됨
        Arrays.sort(val);
        n = Integer.parseInt(br.readLine());
        String[] strNums = br.readLine().split(" ");
        for(String s : strNums){
            int num = Integer.parseInt(s);
            if(Arrays.binarySearch(val,num) < 0)
                System.out.println(0);
            else
                System.out.println(1);
        }
    }
}
