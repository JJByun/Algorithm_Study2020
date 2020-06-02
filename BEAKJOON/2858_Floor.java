import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
public class Floor {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] val = br.readLine().split(" ");
        int red = Integer.parseInt(val[1]);
        int brown = Integer.parseInt(val[0]);
        int L=0,W=0;
        for(int i=1; i<=5000; i++) {
            for(int j=1; j<=4000; j++) {
                if(red+brown == i*j) {
                    if(brown == (i*2) + (j-2)*2) {
                        L = i;
                        W = j;
                        break;
                    }
                    else if(brown == (j*2) + (i-2)*2) {
                        L = j;
                        W = i;
                        break;
                    }
                }
            }
        }
        System.out.println(L);
        System.out.println(W);
    }
}
