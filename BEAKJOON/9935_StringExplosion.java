import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class StringExplosion {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strs = br.readLine();
        String target = br.readLine();
        char[] arr = target.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        char lastWord = arr[arr.length-1]; //마지막 문자

        for(int i=0; i<strs.length(); i++){
            char c = strs.charAt(i);
            if(c == lastWord){
                if(list.size() < target.length()-1) //stack 사이즈보다 작다면 파괴 불가능
                    list.add(c);
                else{ //거꾸로 탐색해서 타겟 문자와 같다면 remove 시켜주기
                    boolean isBomb = true;
                    int listSize = list.size()-1;
                    for(int j=target.length()-2; j>=0; j--){
                        if(list.get(listSize) != arr[j])
                            isBomb=false;
                        listSize--;
                    }
                    if(isBomb){
                        for(int j=0; j<target.length()-1;j++)
                            list.remove(list.size()-1);
                    }else
                        list.add(c);

                }
            }else{
                list.add(c);
            }
            //System.out.println("list: "+list.toString());
        }
        if(list.size() == 0)
            System.out.println("FRULA");
        else{
            StringBuffer sb = new StringBuffer();
            for(char c : list)
                sb.append(c);
            System.out.println(sb.toString());
        }

    }


}
