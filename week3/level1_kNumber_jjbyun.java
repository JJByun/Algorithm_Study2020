import java.util.ArrayList;
import java.util.Collections;

public class kNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};

        int arrLength = commands.length;
        ArrayList<Integer> tmpArr = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        for(int n=0; n<arrLength; n++){
            int i= commands[n][0];
            int j= commands[n][1];
            int k= commands[n][2];
            if(!tmpArr.isEmpty())
                tmpArr.clear();
            for(int nn=i-1; nn<j;nn++){
                tmpArr.add(array[nn]); //임시 배열에 넣어주기
            }
            System.out.println("N: "+n);
            System.out.println(tmpArr);
            Collections.sort(tmpArr); //오름차순 정렬
            int num = tmpArr.get(k-1);
            answers.add(num); //arrayList에 값 넣어주기
        }
        answer = convertIntegers(answers);
        return answer;
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
