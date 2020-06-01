import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String [] arr = br.readLine().split(" ");
            if(arr.length == 1) //-1이면 종료
                break;
            int [] data = new int[arr.length - 1];
            for(int i=0; i<data.length; i++)
                data[i] = Integer.parseInt(arr[i]);
            //반복
            int count = 0;
            Arrays.sort(data);
            for(int i=0; i<data.length-1;i++){
                for(int j=i+1; j<data.length; j++){ //부르트포스로 순회
                    if(data[i]*2 == data[j]) 
                        count++;
                }
            }
            System.out.println(count);
        }
    }

}
