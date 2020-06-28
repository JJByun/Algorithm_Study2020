import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class APlusB {
    //solution number: 15740
    public static  void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String [] strs = bf.readLine().split(" "); //String

        //BigInteger type으로 받아서 덧셈 진행
        BigInteger num1 = new BigInteger(strs[0]);
        BigInteger num2 = new BigInteger(strs[1]);

        System.out.println(num1.add(num2).toString());
    }
}
