import java.util.ArrayList;

public class noSameNumber {
    public int[] solution(int []arr) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(arr[0]);
        for(int i=1; i<arr.length; i++){
            if(list.get(list.size()-1) != arr[i]){
                list.add(arr[i]);
            }
        }

        return convertIntegers(list);
    }
    public static int[] convertIntegers(ArrayList<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }
}
