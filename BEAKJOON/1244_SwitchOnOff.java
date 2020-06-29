
import java.util.Arrays;
import java.util.Scanner;

public class SwitchOnOff {
    //solution number : 1244

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int students = sc.nextInt();
        for(int j=0; j<students; j++){
            int sex = sc.nextInt();
            int idx = sc.nextInt();
            if(sex == 1){ //남학생인 경우
                for(int i=idx; i<arr.length; i++){
                    if(i % idx == 0){ //배수라면
                        changeSwitch(arr, i);
                    }
                }
                //System.out.println(Arrays.toString(arr));
            }else{ //여학생인 경우
                int num =findChangeSize(arr, idx);
                //System.out.println(num);
                for(int i=idx-num; i<=idx+num; i++){
                    changeSwitch(arr,i);
                }
                //System.out.println(Arrays.toString(arr));
            }
        }
        String ret ="";
        for(int i=1; i<arr.length; i++)
            ret+=arr[i]+" ";
        System.out.println(ret.trim());
    }
    public static void changeSwitch(int[] arr, int idx){
        if(arr[idx] == 1)
            arr[idx] = 0;
        else
            arr[idx] = 1;
    }
    public static int findChangeSize(int[] arr, int idx){
        int n = 0;
        while(true){
            if(idx-n == 1 || idx+n == arr.length-1){
                if(arr[idx-n] == arr[idx+n])
                    return n;
                else
                    return n-1;
            }
            if(arr[idx-n] == arr[idx+n])
                n++;
            else{
                n--;
                break;
            }

        }
        return n;
    }
}
