import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class TopNee {
    /// sol num : 14891 - 톱니바퀴 - 삼성 기출문제
    static final int N = -1;
    static final int S = 1;
    static final int CLOCK = 1;
    static final int UNCLOCK = -1;
    static final int LEFT = 6;
    static final int RIGHT=2;
    static ArrayList<Integer> l1 = new ArrayList<>();
    static ArrayList<Integer> l2 = new ArrayList<>();
    static ArrayList<Integer> l3 = new ArrayList<>();
    static ArrayList<Integer> l4 = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {
        init();
        int itr = Integer.parseInt(br.readLine());
        int t=0;
        while(itr-- >0){
            String[] strs = br.readLine().split(" ");
            int target = Integer.parseInt(strs[0]);
            int dir = Integer.parseInt(strs[1]); //-1 -> 반시계, 1-> 시계
//            System.out.println(t++ +"회전");
//            System.out.println(l1);
//            System.out.println(l2);
//            System.out.println(l3);
//            System.out.println(l4);
//            System.out.println();
            move(target, dir);
        }
//        System.out.println(l1);
//        System.out.println(l2);
//        System.out.println(l3);
//        System.out.println(l4);
//        System.out.println();
        System.out.println(cal());
    }
    public static void rotate(int target, int dir){
        if(target==1){
            if(dir==CLOCK){
                int tmp = l1.get(7);
                l1.remove(7);
                l1.add(0,tmp);
            }else{
                int tmp = l1.get(0);
                l1.remove(0);
                l1.add(tmp);
            }
        }else if(target==2){
            if(dir==CLOCK){
                int tmp = l2.get(7);
                l2.remove(7);
                l2.add(0,tmp);
            }else{
                int tmp = l2.get(0);
                l2.remove(0);
                l2.add(tmp);
            }
        }else if(target==3){
            if(dir==CLOCK){
                int tmp = l3.get(7);
                l3.remove(7);
                l3.add(0,tmp);
            }else{
                int tmp = l3.get(0);
                l3.remove(0);
                l3.add(tmp);
            }
        }else{
            if(dir==CLOCK){
                int tmp = l4.get(7);
                l4.remove(7);
                l4.add(0,tmp);
            }else{
                int tmp = l4.get(0);
                l4.remove(0);
                l4.add(tmp);
            }
        }
    }
    public static void move(int target, int dir){
        /// 왼쪽:6, 오른쪽:2
        //target:1인 경우 2 3 4 순서로 봐주기
        if(target==1){
            if(l1.get(RIGHT)*l2.get(LEFT) == -1){ //상극인 경우만
                //l2돌려주기
                if(l2.get(RIGHT)*l3.get(LEFT) == -1){
                    //l3돌려주기
                    if(l3.get(RIGHT)*l4.get(LEFT) == -1){
                        //l4 돌려주기
                        rotate(4,-dir);
                    }
                    rotate(3,dir);
                }
                rotate(2,-dir);
            }
            rotate(1,dir);
        }
        //target:2 -> 1 3 4 순서로 봐주기
        else if(target ==2 ){
            if(l2.get(LEFT)*l1.get(RIGHT)==-1){
                rotate(1,-dir);
            }
            if(l2.get(RIGHT)*l3.get(LEFT)==-1){
                if(l3.get(RIGHT)*l4.get(LEFT)==-1){
                    rotate(4,dir);
                }
                rotate(3,-dir);
            }
            rotate(2,dir);
        }
        //target:3 -> 2,1,4 순서로 봐주기
        else if(target==3){
            if(l3.get(LEFT)*l2.get(RIGHT)==-1){
                if(l1.get(RIGHT)*l2.get(LEFT)==-1){
                    rotate(1,dir);
                }
                rotate(2,-dir);
            }
            if(l3.get(RIGHT)*l4.get(LEFT)==-1) {
                rotate(4,-dir);
            }
            rotate(3,dir);
        }
        //target:4 -> 3,2,1 순서로 봐주기
        else{
            if(l4.get(LEFT)*l3.get(RIGHT)==-1){
                if(l2.get(RIGHT)*l3.get(LEFT)==-1){
                    if(l1.get(RIGHT)*l2.get(LEFT)==-1){
                        rotate(1,-dir);
                    }
                    rotate(2,dir);
                }
                rotate(3,-dir);
            }
            rotate(4,dir);
        }
    }
    public static void init() throws IOException {

        int[] arr1 = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        for(int j=0; j<arr1.length;j++){
            if(arr1[j]==0) l1.add(-1);
            else l1.add(arr1[j]);
        }

        int[] arr2 = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        for(int j=0; j<arr2.length;j++){
            if(arr2[j]==0) l2.add(-1);
            else l2.add(arr2[j]);
        }

        int[] arr3 = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        for(int j=0; j<arr3.length;j++){
            if(arr3[j]==0) l3.add(-1);
            else l3.add(arr3[j]);
        }

        int[] arr4 = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        for(int j=0; j<arr4.length;j++){
            if(arr4[j]==0) l4.add(-1);
            else l4.add(arr4[j]);
        }
    }
    public static int cal(){
        int ret = 0;
        if(l1.get(0) == S) ret+=1;

        if(l2.get(0) == S) ret+=2;

        if(l3.get(0) == S) ret+=4;

        if(l4.get(0) == S) ret+=8;

        return ret;
    }
}
