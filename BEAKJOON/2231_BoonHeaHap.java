import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=n-1 ; i > 1; i--){
            int tmp = i;
            int sum = 0;
            while( tmp != 0){ //자리수 구하기
                sum += tmp%10;
                tmp /= 10;
            }

            if(i + sum == n) { //자리수 합과 해당 값이 생성자라면 list에 넣어주기
                list.add(i);
                //System.out.println("i " + i);
            }
        }
        if(list.isEmpty())
            System.out.println(0);
        else
            System.out.println(list.get(list.size()-1)); //내림차순으로 list에 넣었으니까 마지막거 출력
    }
}