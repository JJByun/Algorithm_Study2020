import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SeeHum {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] classes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long count =0;
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long first = arr[0];
        long second = arr[1];

        for(int i=0; i<classes.length;i++){
            count++;
            classes[i]-=first;
            if(classes[i] > 0){
                count+=classes[i]/second;
                if(classes[i]%second != 0 ) count++;
            }
        }
        System.out.println(count);
    }
}
