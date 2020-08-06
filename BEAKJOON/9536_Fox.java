import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Fox {
    //solution number : 9536
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-- >0){
            String[] voice = br.readLine().split(" ");
            ArrayList<String> list = new ArrayList<>();
            for(String s : voice){
                list.add(s);
            }
            while(true){
                String[] str = br.readLine().split(" ");
                if(str[0].startsWith("what")) break;
                while(list.contains(str[2]))
                    list.remove(str[2]);
            }
            StringBuilder sb= new StringBuilder();
            for(String s : list)
                sb.append(s+" ");
            System.out.println(sb.toString().trim());
        }
    }
}
