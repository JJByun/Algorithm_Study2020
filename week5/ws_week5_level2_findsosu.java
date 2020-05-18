import java.util.*;
import java.util.stream.Stream;

class Solution {
    int answer = 0;
    public int solution(String numbers) {
        int[] numarr = Stream.of(numbers.split("")).
                        mapToInt(Integer::parseInt).toArray();
        
        for(int r = 1; r <= numarr.length; r++){
            Permutation(numarr.length, r);
            perm(numarr, 0);
        }
        return answer;
    }
    
    public boolean checkN(int n){
        boolean result = false;
        if(n == 2)
            return true;
        if(n == 1)
            return false;
        
        for(int i = 2; i < n; i++){
            if(n%i == 0){
                result = false;
                break;
            }
            else
                result = true;
        }
        return result;
    }
    
    //nPr -> n개중에서 r개를 중복하여 모든 조합을 뽑는다
    private int n;
    private int r;
    private int[] res;
    ArrayList<Integer> list = new ArrayList<>();
    
    //생성자
    public void Permutation(int n, int r){
        this.n = n;
        this.r = r;
        res = new int[r];
    }
    
    public void swap(int[] arr , int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    public void perm(int[] arr, int depth){
        //r개만큼만 뽑음
        if(depth == r){
            String numStr = new String();
            for(int i = 0; i < res.length; i++){
                String str = Integer.toString(res[i]);
                numStr += str;
            }
            int strN = Integer.parseInt(numStr);
            if(!list.contains(strN) && checkN(strN)){
                //System.out.println("num strN > "+strN);
                list.add(strN);
            }
            answer = list.size();
            return;
        }
        for(int i = depth; i < n; i++){
            swap(arr, depth, i);
            res[depth] = arr[depth];
            perm(arr, depth+1);
            swap(arr, depth, i);
        }
    }
}