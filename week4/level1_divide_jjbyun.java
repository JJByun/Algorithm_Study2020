import java.util.ArrayList;
import java.util.Collections;

public class divide {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i:arr){
            if(i%divisor == 0)
                list.add(i);
        }
        if(list.size()==0)
            list.add(-1);

        Collections.sort(list);
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
